package me.proxer.library.entity.info

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import me.proxer.library.entity.ProxerIdItem

/**
 * Entity holding the most important information of a person involved in an entry.
 *
 * @property name The name.
 * @property type The type of involvement. For example "original-creator".
 */
@JsonClass(generateAdapter = true)
data class EntryPerson(
    @Json(name = "pid") override val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "type") val type: String
) : ProxerIdItem
