package me.proxer.library.entity.info

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import me.proxer.library.entity.ProxerIdItem

/**
 * Entity with detailed information concerning a person.
 *
 * @property name The name.
 * @property gender The gender. For example "m" or "f".
 * @property bloodType The blood type.
 * @property birthday The birthday in the format "yyyy-MM-dd".
 * @property birthplace The place of birth.
 * @property nationality The nationality as country code.
 * @property residence The place of residence.
 * @property descriptions The sections of the description.
 * @property names The names in different writings.
 * @property occupations The occupations. For example "mangaka".
 * @property entries The entries this person was involved in.
 * @property characters The characters this person voices.
 */
@JsonClass(generateAdapter = true)
data class Person(
    @Json(name = "id") override val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "gender") val gender: String?,
    @Json(name = "bloodtype") val bloodType: String?,
    @Json(name = "birthday") val birthday: String?,
    @Json(name = "birthplace") val birthplace: String?,
    @Json(name = "nationality") val nationality: String?,
    @Json(name = "residence") val residence: String?,
    @Json(name = "description") val descriptions: List<ProfileDescription>,
    @Json(name = "names") val names: List<ProfileName>,
    @Json(name = "occupations") val occupations: List<PersonOccupation>,
    @Json(name = "entrys") val entries: List<ProfileEntry>,
    @Json(name = "characters") val characters: List<PersonCharacter>
) : ProxerIdItem

/**
 * Entity holding an occupation of a [Person].
 *
 * @property type The type. For example "mangaka" or "seiuu".
 */
@JsonClass(generateAdapter = true)
data class PersonOccupation(
    @Json(name = "type") val type: String
)

/**
 * Entity holding a character voiced by a [Person].
 *
 * @property type The type of involvement. For example "seiyuu".
 * @property language The language the character is voiced in.
 * @property name The name of the character.
 */
@JsonClass(generateAdapter = true)
data class PersonCharacter(
    @Json(name = "cid") override val id: String,
    @Json(name = "type") val type: String,
    @Json(name = "language") val language: String?,
    @Json(name = "name") val name: String
) : ProxerIdItem
