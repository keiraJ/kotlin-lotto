package lottoview

import lotto.LottoPriceRule
import lotto.LottoPurchaseHandler
import lotto.LottoWinningInfo

object LottoInputView {

    fun inputPurchaseAmount(): LottoPriceRule {
        println(INPUT_PURCHASE_AMOUNT_MESSAGE)
        val amount = readln()

        val priceInfo = LottoPurchaseHandler.calculateLottoCountByAmount(amount.toInt())
        println(priceInfo.count.toString() + INPUT_PURCHASE_NUMBER_MESSAGE)

        return priceInfo
    }

    fun inputWinningNumbers(): LottoWinningInfo {
        println(INPUT_WINNING_NUMBER_MESSAGE)
        val winningNumbers = readln()

        return LottoWinningInfo(winningNumbers)
    }

    const val INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요."
    const val INPUT_PURCHASE_NUMBER_MESSAGE = "개를 구매했습니다."
    const val INPUT_WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요."
}
