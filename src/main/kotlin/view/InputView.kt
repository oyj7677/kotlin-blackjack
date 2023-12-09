package view

import InputAnswer

object InputView : InputViewInterface {

    private const val TEXT_INPUT_PROMPT = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)"
    private const val TEXT_HIT_PROMPT_FORMAT = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)"
    private const val ERR_MSG_MINIMUM_PLAYER_COUNT = "출전할 플레이어는 2명 이상이어야 합니다."
    private const val TEXT_ANSWER_YES = "Y"
    private const val TEXT_ANSWER_NO = "N"

    fun inputPlayerName(): String {
        println(TEXT_INPUT_PROMPT)
        val inputData = readln()
        validatePlayerNameInputData(inputData)
        return inputData
    }

    override fun askForHit(playerName: String): InputAnswer {
        println(TEXT_HIT_PROMPT_FORMAT.format(playerName))
        val inputData = readln()
        return when (inputData.uppercase()) {
            TEXT_ANSWER_YES -> {
                InputAnswer.YES
            }

            TEXT_ANSWER_NO -> {
                InputAnswer.NO
            }

            else -> {
                InputAnswer.NONE
            }
        }
    }

    private fun validatePlayerNameInputData(inputData: String) {
        validateZeroPlayerCnt(inputData)
    }

    private fun validateZeroPlayerCnt(inputData: String) {
        val nameList = inputData.split(',')
            .map { it.trim() }
            .filter { it.isNotBlank() }

        require(nameList.isNotEmpty()) { ERR_MSG_MINIMUM_PLAYER_COUNT }
    }
}
