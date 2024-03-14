package blackjack.model.role

import blackjack.model.card.CardDeck
import blackjack.model.card.CardHand
import blackjack.model.card.state.CardsState
import blackjack.model.card.state.Decide
import blackjack.model.card.state.Done
import blackjack.model.card.state.InitialState
import blackjack.model.config.GameRule.INITIAL_CARD_COUNT

abstract class Role(open val name: PlayerName) {
    var state: CardsState = InitialState(CardHand())

    init {
        repeat(INITIAL_CARD_COUNT) {
            state = state.draw(CardDeck.getRandomCard())
        }
    }

    fun runPhase(
        canDraw: () -> Boolean,
        showCards: () -> Unit,
    ): CardsState {
        while (state is Decide && canDraw.invoke()) {
            state = state.draw(CardDeck.getRandomCard())
            showCards.invoke()
            if (state is Done) return state
        }
        state = state.stay()
        return state
    }
}
