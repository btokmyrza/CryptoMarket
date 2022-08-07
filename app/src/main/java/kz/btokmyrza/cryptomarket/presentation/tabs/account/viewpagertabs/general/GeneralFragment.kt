package kz.btokmyrza.cryptomarket.presentation.tabs.account.viewpagertabs.general

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anychart.AnyChart
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Cartesian
import com.anychart.core.cartesian.series.Column
import com.anychart.enums.Anchor
import com.anychart.enums.HoverMode
import com.anychart.enums.Position
import com.anychart.enums.TooltipPositionMode
import kz.btokmyrza.cryptomarket.databinding.FragmentGeneralBinding
import kz.btokmyrza.cryptomarket.domain.model.Card
import kz.btokmyrza.cryptomarket.presentation.tabs.account.AccountViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class GeneralFragment : Fragment() {

    private var _binding: FragmentGeneralBinding? = null
    private val binding get() = _binding!!

    private val accountViewModel by sharedViewModel<AccountViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGeneralBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupCardRecyclerView()
        setupChart()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupCardRecyclerView() {
        val cardAdapter = CardAdapter()
        binding.rvHorizontalCards.adapter = cardAdapter
        binding.rvHorizontalCards.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        cardAdapter.setCards(getMockCards())
    }

    private fun getMockCards(): List<Card> =
        listOf(
            Card("Nord Bank", "Fast home delivery of the card and free service"),
            Card("Trade", "Invite a friend and you could both get $10 in BTC"),
            Card("Jusan Bank", "Jusan has launched a new project which calls Jusan Junior"),
        )

    private fun setupChart() {
        val cartesian: Cartesian = AnyChart.column()

        val data: MutableList<DataEntry> = ArrayList()
        data.add(ValueDataEntry("Incomes", 5690))
        data.add(ValueDataEntry("Expenses", 2280))

        val column: Column = cartesian.column(data)

        column.color("#8D3AFF")

        column.tooltip()
            .titleFormat("{%X}")
            .position(Position.CENTER_BOTTOM)
            .anchor(Anchor.CENTER_BOTTOM)
            .offsetX(0.0)
            .offsetY(5.0)
            .format("\${%Value}{groupsSeparator: }")
            .fontColor("#000000")

        cartesian.animation(true)

        cartesian.yScale().minimum(0.0)

        cartesian.yAxis(0).labels().format("\${%Value}{groupsSeparator: }")

        cartesian.tooltip().positionMode(TooltipPositionMode.POINT)
        cartesian.interactivity().hoverMode(HoverMode.BY_X)

        binding.acvExpenses.setChart(cartesian)
    }

}