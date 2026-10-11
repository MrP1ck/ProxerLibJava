package me.proxer.library.api.info

import me.proxer.library.ProxerCall
import me.proxer.library.api.Endpoint
import me.proxer.library.entity.info.EntryCharacter

/**
 * Endpoint for retrieving the characters of an entry.
 */
class EntryCharactersEndpoint internal constructor(
    private val internalApi: InternalApi,
    private val id: String
) : Endpoint<List<EntryCharacter>> {

    override fun build(): ProxerCall<List<EntryCharacter>> {
        return internalApi.entryCharacters(id)
    }
}
