package player

class Player(
    val name: String
) : Participant() {

    private fun isBlackJack(): Boolean {
        val totalPoint = hands.getResultPoint()
        return hands.cardDeckSize() == BLACKJACK_CARD_COUNT && totalPoint == BLACKJACK_NUMBER
    }

    companion object {
        private const val BLACKJACK_CARD_COUNT = 2
        private const val BLACKJACK_NUMBER = 21
    }
}
