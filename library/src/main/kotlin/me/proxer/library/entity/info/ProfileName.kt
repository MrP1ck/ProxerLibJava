package me.proxer.library.entity.info

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Entity holding a name of a [Character] or [Person].
 *
 * @property name The name.
 * @property alternative The name in an alternative writing. For example the Japanese one.
 * @property type The type of the name.
 * @property language The language of the name. Only available for characters.
 */
@JsonClass(generateAdapter = true)
data class ProfileName(
    @Json(name = "name") val name: String,
    @Json(name = "alternative") val alternative: String?,
    @Json(name = "type") val type: String?,
    @Json(name = "language") val language: String? = null
)
