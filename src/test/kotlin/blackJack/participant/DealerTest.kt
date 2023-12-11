package blackJack.participant

import card.CardRank
import card.PlayingCard
import card.Suit
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import player.Dealer
import player.Player

class DealerTest {

    @Test
    fun `,다른 참여자의 카드를 받아 비교할 때, 승패가 반환된다`() {
        // given :
        val dealer = Dealer()
        dealer.hit(PlayingCard(Suit.DIAMOND, CardRank.ACE))
        dealer.hit(PlayingCard(Suit.DIAMOND, CardRank.KING))

        val player = Player("OYJ")
        player.hit(PlayingCard(Suit.DIAMOND, CardRank.ACE))
        player.hit(PlayingCard(Suit.DIAMOND, CardRank.TREE))

        // when :
        val actual: Boolean = dealer.isWinning(player)

        // then :
        Assertions.assertThat(actual).isTrue()
    }
}
