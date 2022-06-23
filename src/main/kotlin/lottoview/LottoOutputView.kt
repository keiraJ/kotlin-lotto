package lottoview

import lotto.LottoTickets
import lotto.LottoWinningInfo
import lotto.WinningPriceEnum

object LottoOutputView {

    fun displayIssuedLottos(issuedLottos: LottoTickets) {
        issuedLottos.lotto.forEach {
            println(it.ticketList.map { it.number })
        }
    }

    fun resultForWinning(winningInfo: LottoWinningInfo) {
        println(WINNING_STATISTICS_MESSAGE)
        println(SEPARATOR_MESSAGE)

        winningInfo.scoreInfos.sortBy { it.match }
        winningInfo.scoreInfos.forEach {
            var message = CONTAIN_MESSAGE.format(it.match.number, it.price, it.count)
            if (it.match == WinningPriceEnum.FIVE_BONUS) {
                message = BONUS_CONTAIN_MESSAGE.format(5, it.price, it.count)
            }
            println(message)
        }
    }

    fun displayRevenue(revenuePercentage: Double) {
        println(REVENUE_MESSAGE.format(revenuePercentage))
    }

    const val WINNING_STATISTICS_MESSAGE = "당첨 통계"
    const val SEPARATOR_MESSAGE = "---------"
    const val CONTAIN_MESSAGE = "%d 개 일치 (%d원) - %d"
    const val BONUS_CONTAIN_MESSAGE = "%d 개 일치, 보너스 볼 일치 (%d원) - %d"
    const val REVENUE_MESSAGE = "총 수익률은 %.2f입니다."
}
