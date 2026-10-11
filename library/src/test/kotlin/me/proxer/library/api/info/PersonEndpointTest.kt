package me.proxer.library.api.info

import me.proxer.library.ProxerTest
import me.proxer.library.entity.info.PersonCharacter
import me.proxer.library.entity.info.PersonOccupation
import me.proxer.library.entity.info.ProfileEntry
import me.proxer.library.runRequest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class PersonEndpointTest : ProxerTest() {

    @Test
    fun testDefault() {
        val (result, _) = server.runRequest("person.json") {
            api.info
                .person("701")
                .build()
                .safeExecute()
        }

        result.id shouldBeEqualTo "701"
        result.name shouldBeEqualTo "Eiichiro Oda"
        result.gender shouldBeEqualTo "m"
        result.bloodType shouldBeEqualTo "A"
        result.birthday shouldBeEqualTo "1975-01-01"
        result.birthplace shouldBeEqualTo "Kumamoto / Japan"
        result.nationality shouldBeEqualTo "JP"
        result.residence shouldBeEqualTo "Tokyo / Japan"
        result.descriptions.single().subject shouldBeEqualTo "intro"
        result.names.single().alternative shouldBeEqualTo "尾田 栄一郎"
        result.names.single().language shouldBeEqualTo null
        result.occupations shouldBeEqualTo listOf(PersonOccupation("seiuu"), PersonOccupation("mangaka"))
        result.entries shouldBeEqualTo listOf(
            ProfileEntry("53", "original-creator", "One Piece"),
            ProfileEntry("2786", "author-art", "One Piece")
        )
        result.characters shouldBeEqualTo listOf(PersonCharacter("3990", "seiyuu", "jp", "Odacchi"))
    }

    @Test
    fun testPath() {
        val (_, request) = server.runRequest("person.json") {
            api.info.person("701")
                .build()
                .execute()
        }

        request.path shouldBeEqualTo "/api/v1/info/person?id=701"
    }
}
