package lotto

import IssueStrategy
import RandomIssueStrategy
import lotto.LottoCreator.issue
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoCreatorTest {

    @Test
    fun `로또를 설정한 횟수에 맞게 랜덤하게 발급한다`() {
        val count = 3

        var strategy = RandomIssueStrategy(count)
        assertThat(issue(strategy).size).isEqualTo(count)
    }

    @Test
    fun `발급된 숫자에 중복이 없어야 한다`() {
        var strategy = IssueStrategy { listOf(LottoTicket(listOf(1, 2, 3, 3, 4, 5))) }

        val randomIssuedList = issue(strategy)
        assertThat(randomIssuedList.distinct().size).isEqualTo(randomIssuedList.size)
    }
}
