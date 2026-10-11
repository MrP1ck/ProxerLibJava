package me.proxer.library.entity.info

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import me.proxer.library.entity.ProxerIdItem

/**
 * Entity with detailed information concerning a character.
 *
 * @property name The name.
 * @property gender The gender. For example "m" or "f".
 * @property hairColor The hair color as hex string.
 * @property eyeColor The eye color as hex string.
 * @property bloodType The blood type.
 * @property birthday The birthday in the format "yyyy-MM-dd". The year is "0000" if unknown.
 * @property height The height in centimeters.
 * @property weight The weight in kilograms.
 * @property descriptions The sections of the description.
 * @property names The names in different languages.
 * @property persons The persons, who voice this character.
 * @property entries The entries this character appears in.
 */
@JsonClass(generateAdapter = true)
data class Character(
    @Json(name = "id") override val id: String,
    @Json(name = "name") val name: String,
    @Json(name = "gender") val gender: String?,
    @Json(name = "hair_color") val hairColor: String?,
    @Json(name = "eye_color") val eyeColor: String?,
    @Json(name = "bloodtype") val bloodType: String?,
    @Json(name = "birthday") val birthday: String?,
    @Json(name = "height") val height: String?,
    @Json(name = "weight") val weight: String?,
    @Json(name = "description") val descriptions: List<ProfileDescription>,
    @Json(name = "names") val names: List<ProfileName>,
    @Json(name = "persons") val persons: List<CharacterPerson>,
    @Json(name = "links") val entries: List<ProfileEntry>
) : ProxerIdItem

/**
 * Entity holding a person, who voices a [Character].
 *
 * @property type The type of involvement. For example "seiyuu".
 * @property language The language the person voices the character in.
 * @property name The name of the person.
 */
@JsonClass(generateAdapter = true)
data class CharacterPerson(
    @Json(name = "pid") override val id: String,
    @Json(name = "type") val type: String,
    @Json(name = "language") val language: String?,
    @Json(name = "name") val name: String
) : ProxerIdItem
