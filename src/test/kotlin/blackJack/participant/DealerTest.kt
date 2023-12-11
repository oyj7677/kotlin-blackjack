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
        Assertions.assertThat(actual).isTrue()
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
        Assertions.assertThat(actual).isFalse()
    }
}
