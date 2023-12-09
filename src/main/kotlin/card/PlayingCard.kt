package card

data class PlayingCard(val suit: Suit, val cardRank: CardRank) {
    fun getPoint(): Int {
        return cardRank.point
    }

    fun getSuitName(): String {
        return suit.koName
    }

    override fun toString(): String {
        return "${cardRank.symbol}${suit.koName}"
    }

    companion object {
        private val CARD_DECK: MutableMap<String, PlayingCard> = mutableMapOf()

        init {
            for (suit in Suit.values()) {
                for (cardRank in CardRank.values()) {
                    PlayingCard(suit, cardRank).inputCardDeck()
                }
            }
        }

        fun of(suit: Suit, cardRank: CardRank): PlayingCard {
            return CARD_DECK[toKey(suit, cardRank)] ?: throw NoSuchElementException()
        }

        private fun toKey(suit: Suit, cardRank: CardRank): String {
            return suit.name + cardRank.name
        }

        private fun PlayingCard.inputCardDeck() {
            CARD_DECK[toKey(suit, cardRank)] = this
        }
    }
}
