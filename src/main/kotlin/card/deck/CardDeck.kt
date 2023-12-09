package card.deck

import card.PlayingCard

class CardDeck(private var cardList: List<PlayingCard>) {

    private var index = 0

    init {
        cardShuffle()
    }

    fun getCardWithIncrease(): PlayingCard {
        if (isMaxIndexOfCard()) resetCard()
        return cardList[index++]
    }

    private fun isMaxIndexOfCard(): Boolean {
        return index == cardList.size
    }

    private fun resetCard() {
        cardShuffle()
        index = 0
    }

    private fun cardShuffle() {
        cardList = cardList.shuffled()
    }
}
