package view

import InputAnswer

interface InputViewInterface {
    fun askForHit(playerName: String): InputAnswer
}
