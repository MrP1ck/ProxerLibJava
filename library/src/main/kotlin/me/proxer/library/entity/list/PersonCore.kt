package me.proxer.library.entity.list

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import me.proxer.library.entity.ProxerIdItem

/**
 * Entity containing the core information of a person.
 *
 * @property name The name.
 * @property text The beginning of the description, formatted with BBCode.
 */
@JsonClass(generateAdapter = true)
data class PersonCore(
    @Json(name = "id") override val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "text") val text: String?
) : ProxerIdItem
