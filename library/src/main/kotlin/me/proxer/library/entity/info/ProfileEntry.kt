package me.proxer.library.entity.info

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import me.proxer.library.entity.ProxerIdItem

/**
 * Entity holding the reference to an entry from a [Character] or [Person].
 *
 * @property type The role in the entry. For example "main" for characters or "original-creator" for persons.
 * @property name The name of the entry.
 */
@JsonClass(generateAdapter = true)
data class ProfileEntry(
    @Json(name = "eid") override val id: String,
    @Json(name = "type") val type: String,
    @Json(name = "name") val name: String
) : ProxerIdItem
