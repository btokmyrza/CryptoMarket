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
import kz.btokmyrza.cryptomarket.R
import kz.btokmyrza.cryptomarket.databinding.FragmentStatsBinding
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
        createLineChart()
    }

    private fun setupStatsRecyclerView() {
        val statsAdapter = StatsAdapter()
        binding.rvStats.adapter = statsAdapter
        binding.rvStats.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


    }

    private fun createLineChart() {
        val lineChart = AnyChart.line()

        val data = LinkedList<DataEntry>()
        data.add(ValueDataEntry("Jusan", 800))
        data.add(ValueDataEntry("Nord Bank", 940))
        data.add(ValueDataEntry("Central Bank", 750))

        lineChart.data(data)
        binding.chartView.setChart(lineChart)
    }

}