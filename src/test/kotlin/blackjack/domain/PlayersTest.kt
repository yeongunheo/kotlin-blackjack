package blackjack.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class PlayersTest : BehaviorSpec({
    Given("플레이어의 이름들이 주어지면") {
        val names = listOf("pobi", "jason")
        When("Players는") {
            val players = Players.init(Dealer(), names)
            Then("주어진 이름들을 갖는 Players를 생성한다.") {
                players.players[0].name shouldBe "pobi"
                players.players[1].name shouldBe "jason"
            }
        }
    }

    Given("플레이어가 생성되고 나면") {
        val players = Players.init(Dealer(), listOf("pobi", "jason"))
        When("initCard를 통해") {
            players.initCard(FixedDeck())
            Then("각 Player들은 카드 2장을 새로 갖는다.") {
                players.players[0].hand.cards[0] shouldBe Card(CardSuit.HEART, CardNumber.TWO)
                players.players[0].hand.cards[1] shouldBe Card(CardSuit.SPADE, CardNumber.EIGHT)
            }
        }
    }
})