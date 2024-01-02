package blackJack.participant

import card.CardPack
import card.CardRank
import card.PlayingCard
import card.Suit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import player.Participant
import player.Status

class ParticipantTest {
    @Test
    fun `참여자의 카드팩이 생성되고, 참여자가 카드를 받을 때, 받은 카드는 저장한다`() {
        // given : 참여자와 카드팩을 생성한다.
        val participant = Participant()
        val card = CardPack.cards[0]

        // when : 참여자가 카드를 받는다.
        participant.hit(card)
        val actual = participant.hands.cardList[0]

        // then :
        assertThat(actual).isEqualTo(card)
    }

    @Test
    fun `,참여자  생성될 때 ,초기 상태는 플레이중 이다 `() {
        // given :

        // when : 참여자가 생성될 때
        val participant = Participant()
        val actual = participant.status

        // then : 초기 상태는  PLAYING이다.
        val expect = Status.START
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    fun `참여자  생성되고, 카드 받기가 종료될 때, 참여자 상태는 STAND가 된다`() {
        // given : 참여자가 생성된다.
        val participant = Participant()

        // when : 참여자가 카드 받기를 멈춘다.
        participant.playDone()
        val actual = participant.status

        // then : 참여자의 상태는 STAND이다.
        val expect = Status.STAND
        assertThat(actual).isEqualTo(expect)
    }

    @Test
    fun `참여자가 카드를 받고, 참여자 보유 카드 합이 20이하 일 때, 참여자 상테는 PLAYING로 업데이트 된다`() {
        // given : 참여자 보유 카드 합 20 이하(8)
        val participant = Participant()
        participant.hit(PlayingCard(Suit.DIAMOND, CardRank.TREE))
        participant.hit(PlayingCard(Suit.DIAMOND, CardRank.FIVE))

        // when : 참여자 상태 업데이트
        participant.updateStatus()
        val actual = participant.status

        // then : 참여자 상태는 PLAYING이다.
        assertThat(actual).isEqualTo(Status.PLAYING)
    }

    @Test
    fun `참여자가 카드를 받고, 참여자 보유 카드 합이 21이상 일 때, 참여자 상테는 BUST로 업데이트 된다`() {
        // given : 참여자 보유 카드 합 21 이상(28)
        val participant = Participant()
        participant.hit(PlayingCard(Suit.DIAMOND, CardRank.EIGHT))
        participant.hit(PlayingCard(Suit.DIAMOND, CardRank.KING))
        participant.hit(PlayingCard(Suit.DIAMOND, CardRank.JACK))

        // when : 참여자 상태 업데이트
        participant.updateStatus()
        val actual = participant.status

        // then : 참여자 상태는 PLAYING이다.
        assertThat(actual).isEqualTo(Status.BUST)
    }

    @Test
    fun `참여자가 초기 2장의 카드를 받고, 참여자 보유 가드 합이 21 일 때, 참여자 상테는 BLACK_JACK으로 업데이트 된다`() {
        // given : 참여자 보유 카드 2장 && 합 21
        val participant = Participant()
        participant.hit(PlayingCard(Suit.DIAMOND, CardRank.ACE))
        participant.hit(PlayingCard(Suit.DIAMOND, CardRank.KING))

        // when : 참여자 상태 업데이트
        participant.updateStatus()
        val actual = participant.status

        // then : 참여자 상태는 PLAYING이다.
        assertThat(actual).isEqualTo(Status.BLACK_JACK)
    }

    @Test
    fun `, 참여자가 플레이를 멈춘다고 할때, 참여자  상태는 STAND로 업데이트 된다`() {
        // given : 참여자 보유 카드 합 21 이상(28)
        val participant = Participant()

        // when : 참여자 상태 업데이트
        participant.playDone()
        val actual = participant.status

        // then : 참여자 상태는 PLAYING이다.
        assertThat(actual).isEqualTo(Status.STAND)
    }


}
