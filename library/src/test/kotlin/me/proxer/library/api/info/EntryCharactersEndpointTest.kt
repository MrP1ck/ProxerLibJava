package me.proxer.library.api.info

import me.proxer.library.ProxerTest
import me.proxer.library.entity.info.EntryCharacter
import me.proxer.library.runRequest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class EntryCharactersEndpointTest : ProxerTest() {

    @Test
    fun testDefault() {
        val (result, _) = server.runRequest("entry_characters.json") {
            api.info
                .entryCharacters("53")
                .build()
                .safeExecute()
        }

        result.size shouldBeEqualTo 3
        result.first() shouldBeEqualTo EntryCharacter("517", "Brook", "main")
    }

    @Test
    fun testPath() {
        val (_, request) = server.runRequest("entry_characters.json") {
            api.info.entryCharacters("53")
                .build()
                .execute()
        }

        request.path shouldBeEqualTo "/api/v1/info/characters?id=53"
    }
}
