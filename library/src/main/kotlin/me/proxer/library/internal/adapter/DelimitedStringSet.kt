package me.proxer.library.internal.adapter

import com.squareup.moshi.JsonQualifier

/**
 * @author Ruben Gees
 */
@JsonQualifier
internal annotation class DelimitedStringSet(
    val delimiter: String = " ",
    val valuesToKeep: Array<String> = []
)
