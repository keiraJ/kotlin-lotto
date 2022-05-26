package lottoview

import lotto.LottoWinningHandler.matchCount
import lotto.LottoWinningInfo
import lotto.WinningPriceEnum
import lotto.getPrice

object LottoOutputView {

    fun resultForWinning(issuedLottos: List<List<Int>>, winningInfo: LottoWinningInfo): Int {
        println(WINNING_STATISTICS_MESSAGE)
        println(SEPARATOR_MESSAGE)

        val revenue = 0
        matchCount(issuedLottos, winningInfo).filter { it.value > 0 }.forEach {
            val price = getPrice(it.key)
            println(CONTAIN_MESSAGE.format(it.key, price, it.value))
            revenue.plus(it.value)
        }

        return revenue
    }

    fun displayRevenue(amount: Int, revenue: Int) {
        val revenuePercentage = amount / revenue * 100
        REVENUE_MESSAGE.format(revenuePercentage)
    }

    const val WINNING_STATISTICS_MESSAGE = "당첨 통계"
    const val SEPARATOR_MESSAGE = "---------"
    const val CONTAIN_MESSAGE = "%d 개 일치 (%d원) - %d "
    const val REVENUE_MESSAGE = "총 수익률은 %.2f입니다."
}