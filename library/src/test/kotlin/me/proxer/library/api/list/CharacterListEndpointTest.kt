package me.proxer.library.api.list

import me.proxer.library.ProxerTest
import me.proxer.library.runRequest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class CharacterListEndpointTest : ProxerTest() {

    @Test
    fun testDefault() {
        val (result, _) = server.runRequest("character_list.json") {
            api.list
                .characterList()
                .build()
                .safeExecute()
        }

        result.size shouldBeEqualTo 3
        result.first().id shouldBeEqualTo "5170"
        result.first().name shouldBeEqualTo "001"
    }

    @Test
    fun testPath() {
        val (_, request) = server.runRequest("character_list.json") {
            api.list.characterList()
                .search("ab")
                .searchStart("cd")
                .page(1)
                .limit(100)
                .build()
                .execute()
        }

        request.path shouldBeEqualTo "/api/v1/list/characters?start=cd&contains=ab&p=1&limit=100"
    }
}
