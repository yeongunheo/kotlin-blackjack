package blackjack.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class PlayerTest : BehaviorSpec({
    Given("이름이 주어지면") {
        val name = "pobi"
        When("플레이어는") {
            val player = Player(name)
            Then("주어진 이름을 갖는 플레이어가 생성된다.") {
                player.name shouldBe name
            }
        }
    }

    Given("이름과 패가 주어지면") {
        val name = "pobi"
        val hand = Hand(listOf(Card(CardSuit.HEART, CardNumber.TWO), Card(CardSuit.SPADE, CardNumber.EIGHT)))
        When("플레이어는") {
            val player = Player(name, hand)
            Then("주어진 이름과 패를 갖는 플레이어가 생성된다.") {
                player.name shouldBe name
                player.hand shouldBe hand
            }
        }
    }

    Given("플레이어는 자신이 가진 패로") {
        When("추가로 Hit 할 수 있는지 없는지를") {
            Then("판단하여 반환한다.") {
                forAll(
                    row(Hand(listOf(Card(CardSuit.SPADE, CardNumber.TEN), Card(CardSuit.CLUB, CardNumber.TEN))), true),
                    row(Hand(listOf(Card(CardSuit.SPADE, CardNumber.ACE), Card(CardSuit.CLUB, CardNumber.TEN))), false),
                    row(
                        Hand(listOf(Card(CardSuit.SPADE, CardNumber.TEN), Card(CardSuit.CLUB, CardNumber.TEN), Card(CardSuit.HEART, CardNumber.TWO))),
                        false
                    ),
                ) { hand, expected ->
                    Player("yeongun", hand).canHit() shouldBe expected
                }
            }
        }
    }
})
