package blackjack.domain.participant

class Players(val values: List<Player>) : List<Player> by values {
    init {
        val distinctPlayerNames = values.map { it.name }.toSet()
        require(distinctPlayerNames.size == values.size) { "게임 참가자의 이름이 중복됩니다." }
    }

    companion object {
        fun of(names: List<String>): Players {
            val players = names.map { Player(it) }
            return Players(players)
        }
    }
}