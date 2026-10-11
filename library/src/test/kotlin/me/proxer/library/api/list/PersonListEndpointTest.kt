package me.proxer.library.api.list

import me.proxer.library.ProxerTest
import me.proxer.library.runRequest
import org.amshove.kluent.shouldBeEqualTo
import org.junit.jupiter.api.Test

class PersonListEndpointTest : ProxerTest() {

    @Test
    fun testDefault() {
        val (result, _) = server.runRequest("person_list.json") {
            api.list
                .personList()
                .build()
                .safeExecute()
        }

        result.size shouldBeEqualTo 3
        result.first().id shouldBeEqualTo "4584"
        result.first().name shouldBeEqualTo "100,000 Won"
    }

    @Test
    fun testPath() {
        val (_, request) = server.runRequest("person_list.json") {
            api.list.personList()
                .search("ab")
                .searchStart("cd")
                .page(1)
                .limit(100)
                .build()
                .execute()
        }

        request.path shouldBeEqualTo "/api/v1/list/persons?start=cd&contains=ab&p=1&limit=100"
    }
}
