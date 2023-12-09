package view

import InputAnswer

interface InputView {
    fun askForHit(playerName: String): InputAnswer
}
