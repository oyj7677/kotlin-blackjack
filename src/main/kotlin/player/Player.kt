package player

import card.deck.Hands

class Player(
    val name: String,
    status: Status = Status.START,
    hands: Hands = Hands(),
): Participant(status, hands) {

}
