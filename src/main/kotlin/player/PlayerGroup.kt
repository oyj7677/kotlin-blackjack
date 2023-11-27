package player

class PlayerGroup(val playerList: List<Player>) {
    private var playerIndex = 0

    init {
        validatePlayer()
    }

    private fun validatePlayer() {
        require(playerList.size in MIN_PLAYER_CNT..MAM_PLAYER_CNT) { "참여 가능한 플레이어의 범위를 넘어섰습니다." }
    }

    fun getCurrentPlayer(): Player {
        return playerList[playerIndex]
    }

    fun turnOverPlayer() {
        playerIndex++
    }

    companion object {
        private const val MIN_PLAYER_CNT = 2
        private const val MAM_PLAYER_CNT = 26
    }
}
