package kz.btokmyrza.cryptomarket.presentation.tabs.account.viewpagertabs.stats

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Cartesian
import com.anychart.core.cartesian.series.Line
import com.anychart.data.Set
import com.anychart.enums.Anchor
import com.anychart.enums.MarkerType
import com.anychart.enums.TooltipPositionMode
import kz.btokmyrza.cryptomarket.databinding.FragmentStatsBinding
import kz.btokmyrza.cryptomarket.domain.model.Statistics
import java.util.*

class StatsFragment : Fragment() {

    private var _binding: FragmentStatsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupStatsRecyclerView()
        setupChart()
    }

    private fun setupStatsRecyclerView() {
        val statsAdapter = StatsAdapter()
        binding.rvStats.adapter = statsAdapter
        binding.rvStats.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        statsAdapter.setStats(getMockStats())
    }

    private fun setupChart() {
        val cartesian = AnyChart.line()

        cartesian.animation(true)
        cartesian.padding(10, 20, 5, 20)
        cartesian.crosshair().enabled(true)
        cartesian.crosshair().yLabel(true)
        cartesian.tooltip().positionMode(TooltipPositionMode.POINT)
        cartesian.xAxis(0).labels().padding(5.0, 5.0, 5.0, 5.0)

        val seriesData: MutableList<DataEntry> = mutableListOf()
        seriesData.add(CustomDataEntry("1986", 3.6, 2.3, 2.8))
        seriesData.add(CustomDataEntry("1987", 7.1, 4.0, 4.1))
        seriesData.add(CustomDataEntry("1988", 8.5, 6.2, 5.1))
        seriesData.add(CustomDataEntry("1989", 9.2, 11.8, 6.5))

        val set = Set.instantiate()
        set.data(seriesData)
        val series1Mapping = set.mapAs("{ x: 'x', value: 'value' }")
        val series2Mapping = set.mapAs("{ x: 'x', value: 'value2' }")

        val series1: Line = cartesian.line(series1Mapping)
        series1.name("Income")
        series1.hovered().markers().enabled(true)
        series1.hovered().markers()
            .type(MarkerType.CIRCLE)
            .size(4.0)
        series1.tooltip()
            .position("right")
            .anchor(Anchor.LEFT_CENTER)
            .offsetX(5.0)
            .offsetY(5.0)

        val series2: Line = cartesian.line(series2Mapping)
        series2.name("Expense")
        series2.hovered().markers().enabled(true)
        series2.hovered().markers()
            .type(MarkerType.CIRCLE)
            .size(4.0)
        series2.tooltip()
            .position("right")
            .anchor(Anchor.LEFT_CENTER)
            .offsetX(5.0)
            .offsetY(5.0)

        cartesian.legend().enabled(true)
        cartesian.legend().fontSize(13.0)
        cartesian.legend().padding(0.0, 0.0, 10.0, 0.0)

        binding.chartView.setChart(cartesian)
    }

    private fun getMockStats(): List<Statistics> =
        listOf(
            Statistics(name = "Alan Denver", amount = "+$280.00"),
            Statistics(name = "Airline Ticket", amount = "-$756.00"),
            Statistics(name = "House Rent", amount = "-$150.00"),
            Statistics(name = "Investing", amount = "+$15.00"),
        )

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private class CustomDataEntry(
    x: String?,
    value: Number?,
    value2: Number?,
    value3: Number?
) :
    ValueDataEntry(x, value) {
    init {
        setValue("value2", value2)
        setValue("value3", value3)
    }
}