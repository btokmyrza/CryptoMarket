package kz.btokmyrza.cryptomarket.presentation.tabs.main.stock_detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Cartesian
import com.anychart.data.Mapping
import com.anychart.data.Set
import com.anychart.enums.Anchor
import com.anychart.enums.MarkerType
import com.anychart.enums.TooltipPositionMode
import kotlinx.coroutines.launch
import kz.btokmyrza.cryptomarket.databinding.FragmentStockDetailBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.math.roundToInt


class StockDetailFragment : Fragment() {

    private var _binding: FragmentStockDetailBinding? = null
    private val binding get() = _binding!!

    private val stockDetailViewModel by viewModel<StockDetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStockDetailBinding.inflate(inflater, container, false)

        val stockSymbol = arguments?.getString("stockSymbol") ?: "NULL"
        val stockName = arguments?.getString("stockName") ?: "NULL"

        binding.tvCompanySymbol.text = stockSymbol
        binding.tvCompanyName.text = stockName
        binding.tvCompanyLogo.text = stockName.first().toString()

        lifecycleScope.launch {
            stockDetailViewModel.loadStockGraphInfo(stockSymbol)
        }

        val cartesian: Cartesian = AnyChart.line()
        cartesian.animation(true)
        cartesian.padding(10.0, 20.0, 5.0, 20.0)
        cartesian.crosshair().enabled(true)
        cartesian.crosshair()
            .yLabel(true)
        cartesian.tooltip().positionMode(TooltipPositionMode.POINT)
        cartesian.yAxis(0).title("")
        cartesian.xAxis(0).labels().padding(5.0, 5.0, 5.0, 5.0)

        val set = Set.instantiate()

        stockDetailViewModel.stockInfos.observe(viewLifecycleOwner) { stockInfos ->
            val seriesData = stockInfos.map { CustomDataEntry(it.date.hour.toString(), it.close) }
            set.data(seriesData)
            val series1Mapping: Mapping = set.mapAs("{ x: 'x', value: 'value' }")
            val series1 = cartesian.line(series1Mapping)
            series1.name(stockSymbol)
            series1.color("#8D3AFF")
            series1.hovered().markers().enabled(true)
            series1.hovered().markers()
                .type(MarkerType.CIRCLE)
                .size(4.0)
            series1.tooltip()
                .position("right")
                .anchor(Anchor.LEFT_CENTER)
                .offsetX(5.0)
                .offsetY(5.0)

            binding.tvCurrentPriceAmount.text =
                "${stockInfos.last().close.roundToInt() / 100.0} USD"
        }

        cartesian.legend().enabled(true)
        cartesian.legend().fontSize(13.0)
        cartesian.legend().padding(0.0, 0.0, 10.0, 0.0)

        binding.anvStocksValue.setChart(cartesian)

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private class CustomDataEntry constructor(
        x: String?,
        value: Number?
    ) : ValueDataEntry(x, value)

}