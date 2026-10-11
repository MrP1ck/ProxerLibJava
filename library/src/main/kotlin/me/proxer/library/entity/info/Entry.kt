package me.proxer.library.entity.info

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import me.proxer.library.entity.ProxerIdItem
import me.proxer.library.entity.list.IndustryCore
import me.proxer.library.enums.Category
import me.proxer.library.enums.FskConstraint
import me.proxer.library.enums.License
import me.proxer.library.enums.MediaLanguage
import me.proxer.library.enums.MediaState
import me.proxer.library.enums.Medium
import me.proxer.library.internal.adapter.DelimitedEnumSet
import me.proxer.library.internal.adapter.NumberBasedBoolean

/**
 * Entity holding all info of an entry. This is everything what [EntryCore] contains and some
 * more which could also be retrieved by the respective standalone APIs.
 *
 * @property name The name.
 * @property fskConstraints The fsk ratings.
 * @property description The description.
 * @property medium The medium.
 * @property episodeAmount The amount of episodes, this entry has. They do not necessarily have to be uploaded.
 * @property state The current state.
 * @property ratingSum The sum of all ratings.
 * @property ratingAmount The clicks on this entry, in this season.
 * @property category The category.
 * @property license The type of license.
 * @property adaptionInfo Information regarding the adaption of this entry.
 * @property isAgeRestricted If this entry is age restricted.
 * @property synonyms The synonyms in different languages.
 * @property languages The languages, this entry is available in.
 * @property seasons The seasons, this entry was aired. If present,
 * the first in the list is the start and the second the end.
 * @property translatorGroups The translator groups.
 * @property industries The industries involved in production and marketing.
 * @property tags The tags.
 * @property genres The genres.
 * @property mediaFormat The format of the medium. For example "tv" or "ona".
 * @property ranking The place in the ranking of all entries.
 * @property cleanedRating The average of the ratings, with suspicious votes removed.
 * @property bayesianRating The bayesian average of the ratings, which the ranking is based on.
 * @property availableEpisodeAmount The amount of episodes, which are actually available.
 * @property isDeactivatedForApps If this entry is not available in apps.
 *
 * @author Ruben Gees
 */
@JsonClass(generateAdapter = true)
data class Entry(
    @Json(name = "id") override val id: String,
    @Json(name = "name") val name: String,
    @field:DelimitedEnumSet @Json(name = "fsk") val fskConstraints: Set<FskConstraint>,
    @Json(name = "description") val description: String,
    @Json(name = "medium") val medium: Medium,
    @Json(name = "count") val episodeAmount: Int,
    @Json(name = "state") val state: MediaState,
    @Json(name = "rate_sum") val ratingSum: Int,
    @Json(name = "rate_count") val ratingAmount: Int,
    @Json(name = "clicks") val clicks: Int,
    @Json(name = "kat") val category: Category,
    @Json(name = "license") val license: License,
    @Json(name = "adaption_data") val adaptionInfo: AdaptionInfo,
    @Json(name = "gate") val isAgeRestricted: Boolean,
    @Json(name = "names") val synonyms: List<Synonym>,
    @Json(name = "lang") val languages: Set<MediaLanguage>,
    @Json(name = "seasons") val seasons: List<EntrySeasonInfo>,
    @Json(name = "groups") val translatorGroups: List<EntryTranslatorGroup>,
    @Json(name = "publisher") val industries: List<IndustryCore>,
    @Json(name = "tags") val tags: List<InfoTag>,
    @Json(name = "genres") val genres: List<InfoGenre>,
    @Json(name = "media_format") val mediaFormat: String? = null,
    @Json(name = "ranking") val ranking: Int? = null,
    @Json(name = "rating_cleaned_average") val cleanedRating: Float? = null,
    @Json(name = "rating_bayesian_average") val bayesianRating: Float? = null,
    @Json(name = "count_available") val availableEpisodeAmount: Int? = null,
    @field:NumberBasedBoolean @Json(name = "flag_deactivate_apps") val isDeactivatedForApps: Boolean = false
) : ProxerIdItem {

    /**
     * Returns the average of all ratings.
     */
    val rating = when {
        ratingAmount <= 0 -> 0f
        else -> ratingSum.toFloat() / ratingAmount.toFloat()
    }
}
