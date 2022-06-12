package lotto

object LottoWinningHandler {

    fun matchCount(issuedLottos: List<LottoTicket>, numbers: List<Int>): Map<WinningPriceEnum, Int> {
        val result = mutableMapOf<Int, Int>()

        for (i in issuedLottos) {
            val c = count(i.ticket, numbers)
            result[c] = result[c]?.plus(1) ?: 1
        }

        return setMatchedLottoNumber(result)
    }

    fun calculateRevenue(scoreInfos: List<ScoreInfo>): Int {
        return scoreInfos.sumOf { it.price }
    }

    private fun count(ticket: List<Int>, winnerNumbers: List<Int>): Int {
        return winnerNumbers.count { ticket.contains(it) }
    }

    private fun setMatchedLottoNumber(matchedMap: Map<Int, Int>): Map<WinningPriceEnum, Int> {
        return matchedMap.entries.associate { find(it.key) to it.value }
    }
}
