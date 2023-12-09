import card.CardPack
import card.deck.CardDeck
import player.PlayerFactory
import player.PlayerGroup
import view.PlayInputView
import view.CardOutputView

fun main() {

    val playerNames = PlayInputView.inputPlayerName()
    val playerGroup = PlayerGroup(PlayerFactory.createPlayerList(playerNames))
    val cardDeck = CardDeck(CardPack.cards)

    val game = BlackjackGame(cardDeck = cardDeck, playerGroup = playerGroup, PlayInputView, CardOutputView)

    CardOutputView.showGameStart(game.playerGroup)

    game.start()

    CardOutputView.showGameEnd(game.playerGroup)
}
