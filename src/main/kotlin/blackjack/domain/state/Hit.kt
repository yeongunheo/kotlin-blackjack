package blackjack.domain.state

import blackjack.domain.Card
import blackjack.domain.Hand
import blackjack.domain.User

class Hit(
    hand: Hand,
) : Started(hand) {

    override fun draw(card: Card): State {
        hand.receive(card)
        return if (hand.getSum() > User.BLACKJACK) {
            Bust(hand)
        } else {
            Hit(hand)
        }
    }

    override fun stay(): State {
        return Stay(hand)
    }

    override fun isFinished(): Boolean {
        return false
    }

    override fun isBlackjack(): Boolean {
        return false
    }
}
