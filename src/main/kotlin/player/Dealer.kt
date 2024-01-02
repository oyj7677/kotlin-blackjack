package player

class Dealer : Participant() {
    fun isWinning(player: Player): Boolean {
        if (status == Status.BUST) return false

        val dealerResultPoint = getResultPoint()
        val playerResultPoint = player.getResultPoint()

        return dealerResultPoint > playerResultPoint
    }

    fun isUnderSeventeen(): Boolean {
        return true
    }
}
