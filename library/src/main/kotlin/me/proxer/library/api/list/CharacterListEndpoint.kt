package me.proxer.library.api.list

import me.proxer.library.ProxerCall
import me.proxer.library.api.PagingLimitEndpoint
import me.proxer.library.entity.list.CharacterCore

/**
 * Endpoint for retrieving a list of characters.
 */
class CharacterListEndpoint internal constructor(
    private val internalApi: InternalApi
) : PagingLimitEndpoint<List<CharacterCore>> {

    private var page: Int? = null
    private var limit: Int? = null

    private var searchStart: String? = null
    private var search: String? = null

    override fun page(page: Int?) = this.apply { this.page = page }
    override fun limit(limit: Int?) = this.apply { this.limit = limit }

    /**
     * Sets the query to search for only from the start.
     */
    fun searchStart(searchStart: String?) = this.apply { this.searchStart = searchStart }

    /**
     * Sets the query to search for.
     */
    fun search(search: String?) = this.apply { this.search = search }

    override fun build(): ProxerCall<List<CharacterCore>> {
        return internalApi.characterList(searchStart, search, page, limit)
    }
}
