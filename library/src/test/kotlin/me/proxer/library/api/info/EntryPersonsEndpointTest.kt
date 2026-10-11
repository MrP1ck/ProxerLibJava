package me.proxer.library.api.info

import me.proxer.library.ProxerTest
import me.proxer.library.entity.info.EntryPerson
import me.proxer.library.runRequest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class EntryPersonsEndpointTest : ProxerTest() {

    @Test
    fun testDefault() {
        val (result, _) = server.runRequest("entry_persons.json") {
            api.info
                .entryPersons("53")
                .build()
                .safeExecute()
        }

        result.size shouldBeEqualTo 3
        result.first() shouldBeEqualTo EntryPerson("701", "Eiichiro Oda", "original-creator")
    }

    @Test
    fun testPath() {
        val (_, request) = server.runRequest("entry_persons.json") {
            api.info.entryPersons("53")
                .build()
                .execute()
        }

        request.path shouldBeEqualTo "/api/v1/info/persons?id=53"
    }
}
