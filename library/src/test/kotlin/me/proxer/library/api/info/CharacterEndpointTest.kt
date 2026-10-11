package me.proxer.library.api.info

import me.proxer.library.ProxerTest
import me.proxer.library.entity.info.CharacterPerson
import me.proxer.library.entity.info.ProfileEntry
import me.proxer.library.runRequest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class CharacterEndpointTest : ProxerTest() {

    @Test
    fun testDefault() {
        val (result, _) = server.runRequest("character.json") {
            api.info
                .character("4")
                .build()
                .safeExecute()
        }

        result.id shouldBeEqualTo "4"
        result.name shouldBeEqualTo "Monkey D. Luffy"
        result.gender shouldBeEqualTo "m"
        result.hairColor shouldBeEqualTo "#000000"
        result.bloodType shouldBeEqualTo "B"
        result.birthday shouldBeEqualTo "0000-05-05"
        result.height shouldBeEqualTo "172"
        result.weight shouldBeEqualTo ""
        result.descriptions.size shouldBeEqualTo 5
        result.descriptions.first().subject shouldBeEqualTo "intro"
        result.descriptions.first().language shouldBeEqualTo "de"
        result.names.map { it.name } shouldBeEqualTo listOf("Strohhut-Ruffy", "Straw Hat Luffy")
        result.names.first().language shouldBeEqualTo "de"
        result.persons.first() shouldBeEqualTo CharacterPerson("670", "seiyuu", "de", "Daniel Schlauch")
        result.entries shouldBeEqualTo listOf(
            ProfileEntry("2786", "main", "One Piece"),
            ProfileEntry("53", "main", "One Piece")
        )
    }

    @Test
    fun testPath() {
        val (_, request) = server.runRequest("character.json") {
            api.info.character("4")
                .build()
                .execute()
        }

        request.path shouldBeEqualTo "/api/v1/info/character?id=4"
    }
}
