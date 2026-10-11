package me.proxer.library.api.info

import me.proxer.library.ProxerCall
import me.proxer.library.api.Endpoint
import me.proxer.library.entity.info.EntryPerson

/**
 * Endpoint for retrieving the persons involved in an entry.
 */
class EntryPersonsEndpoint internal constructor(
    private val internalApi: InternalApi,
    private val id: String
) : Endpoint<List<EntryPerson>> {

    override fun build(): ProxerCall<List<EntryPerson>> {
        return internalApi.entryPersons(id)
    }
}
