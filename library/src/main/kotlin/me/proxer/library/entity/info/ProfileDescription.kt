package me.proxer.library.entity.info

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

/**
 * Entity holding a section of the description of a [Character] or [Person].
 *
 * @property subject The subject of the section. For example "intro" or "appearance".
 * @property text The text of the section, formatted with BBCode.
 * @property language The language of the text.
 */
@JsonClass(generateAdapter = true)
data class ProfileDescription(
    @Json(name = "subject") val subject: String,
    @Json(name = "text") val text: String,
    @Json(name = "language") val language: String?
)
