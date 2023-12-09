package view

import player.Player

interface OutputView {
    fun showPlayingCard(player: Player)

    fun showInputError()
}
