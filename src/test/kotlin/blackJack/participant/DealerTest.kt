package blackJack.participant

import card.CardRank
import card.PlayingCard
import card.Suit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import player.Dealer
import player.Player

class DealerTest {

    @Test
    fun `,다른 참여자의 카드를 받아 비교할 때, 승패가 반환된다`() {
        // given : 딜러와 플레이어 카드 배포
        // 딜러 21
        val dealer = Dealer()
        dealer.hit(PlayingCard(Suit.DIAMOND, CardRank.ACE))
        dealer.hit(PlayingCard(Suit.DIAMOND, CardRank.KING))

        // 플레이어 4
        val player = Player("OYJ")
        player.hit(PlayingCard(Suit.DIAMOND, CardRank.ACE))
        player.hit(PlayingCard(Suit.DIAMOND, CardRank.TREE))

        // when : 승패 비교
        val actual: Boolean = dealer.isWinning(player)

        // then : 딜러 승리 시 True
        assertThat(actual).isTrue()
    }

    @Test
    fun `딜러의 상태가 BUST일 때, 딜러는 무조건 패배한다`() {
        // given : 딜러와 플레이어 카드 배포
        // 딜러 BUST
        val dealer = Dealer()
        dealer.hit(PlayingCard(Suit.DIAMOND, CardRank.FIVE))
        dealer.hit(PlayingCard(Suit.DIAMOND, CardRank.KING))
        dealer.hit(PlayingCard(Suit.DIAMOND, CardRank.KING))

        // 플레이어 BUST
        val player = Player("OYJ")
        dealer.hit(PlayingCard(Suit.DIAMOND, CardRank.FIVE))
        dealer.hit(PlayingCard(Suit.DIAMOND, CardRank.KING))
        dealer.hit(PlayingCard(Suit.DIAMOND, CardRank.KING))

        // when : 승패 비교
        val actual: Boolean = dealer.isWinning(player)

        // then :
        assertThat(actual).isFalse()
    }

    @Test
    fun `딜러의 카드를 받고, 카드의 합이 17미만일 때, True를 반환한다`() {
        // given : 딜러와 플레이어 카드 배포
        // 딜러 16
        val dealer = Dealer()
        dealer.hit(PlayingCard(Suit.DIAMOND, CardRank.SIX))
        dealer.hit(PlayingCard(Suit.DIAMOND, CardRank.KING))

        // when : 승패 비교
        val actual = dealer.isUnderSeventeen()

        // then : 딜러 승리 시 True
        assertThat(actual).isTrue()
    }
}
