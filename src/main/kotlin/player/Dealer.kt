package player

class Dealer : Participant() {
    fun isWinning(player: Player): Boolean {
        val dealerResultPoint = getResultPoint()
        val playerResultPoint = player.getResultPoint()

        return dealerResultPoint > playerResultPoint
    }
}
