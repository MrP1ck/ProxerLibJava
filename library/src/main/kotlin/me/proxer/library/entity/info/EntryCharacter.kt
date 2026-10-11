package me.proxer.library.entity.info

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import me.proxer.library.entity.ProxerIdItem

/**
 * Entity holding the most important information of a character of an entry.
 *
 * @property name The name.
 * @property type The type of the character. For example "main".
 */
@JsonClass(generateAdapter = true)
data class EntryCharacter(
    @Json(name = "id") override val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "type") val type: String
) : ProxerIdItem
