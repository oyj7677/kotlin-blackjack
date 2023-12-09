import card.deck.CardDeck
import player.Player
import player.PlayerGroup
import player.Status
import view.InputViewInterface
import view.OutputViewInterface

class BlackjackGame(
    private val cardDeck: CardDeck,
    val playerGroup: PlayerGroup,
    private val inputView: InputViewInterface,
    private val outputView: OutputViewInterface,
) {

    init {
        for (player in playerGroup.playerList) {
            settingCard(player)
        }
    }

    fun start() {
        for (player in playerGroup.playerList) {
            gamePlay(player)
        }
    }

    private fun gamePlay(player: Player) {
        while (player.status == Status.PLAYING) {
            val response = inputView.askForHit(player.name)
            handleForResponse(response, player)
            outputView.showPlayingCard(player)
        }
    }

    private fun handleForResponse(inputAnswer: InputAnswer, player: Player) {
        when (inputAnswer) {
            InputAnswer.YES -> {
                player.saveCard(cardDeck.getCardWithIncrease())
            }
            InputAnswer.NO -> {
                player.playDone()
            }
            else -> {
                outputView.showInputError()
            }
        }
    }

    private fun settingCard(player: Player) {
        repeat(2) {
            player.saveCard(cardDeck.getCardWithIncrease())
        }
    }
}
