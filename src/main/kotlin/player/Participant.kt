package player

import card.PlayingCard
import card.deck.Hands

open class Participant(
    status: Status = Status.START,
    hands: Hands = Hands(),
) {

    var status = status
        private set

    var hands = hands
        private set

    fun playDone() {
        this.status = Status.STAND
    }

    fun hit(card: PlayingCard) {
        hands.addCard(card)
        updateStatus()
    }

    fun updateStatus() {
        val totalPoint = hands.getResultPoint()

        if (totalPoint > BLACKJACK_NUMBER) {
            this.status = Status.BUST
        } else if (isBlackJack()) {
            this.status = Status.BLACK_JACK
        } else {
            this.status = Status.PLAYING
        }
    }

    fun getResultPoint(): Int {
        return hands.getResultPoint()
    }

    private fun isBlackJack(): Boolean {
        val totalPoint = hands.getResultPoint()
        return hands.cardDeckSize() == BLACKJACK_CARD_COUNT && totalPoint == BLACKJACK_NUMBER
    }

    companion object {
        private const val BLACKJACK_CARD_COUNT = 2
        private const val BLACKJACK_NUMBER = 21
    }
}
