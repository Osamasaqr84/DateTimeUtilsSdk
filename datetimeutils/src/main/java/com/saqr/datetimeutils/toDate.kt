package com.saqr.datetimeutils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun String.toDate(
    pattern: String,
    locale: Locale = Locale.getDefault(),
    timeZone: TimeZone = TimeZone.getDefault()
): Date? {
    return try {
        SimpleDateFormat(pattern, locale).apply {
            this.timeZone = timeZone
            isLenient = false
        }.parse(this)
    } catch (e: Exception) {
        null
    }
}
@RequiresApi(Build.VERSION_CODES.O)
fun String.toLocalDate(
    pattern: String,
    locale: Locale = Locale.getDefault()
): LocalDate? {
    return try {
        LocalDate.parse(this, DateTimeFormatter.ofPattern(pattern, locale))
    } catch (e: DateTimeParseException) {
        null
    }
}
@RequiresApi(Build.VERSION_CODES.O)
fun String.toLocalDateTime(
    pattern: String,
    locale: Locale = Locale.getDefault()
): LocalDateTime? {
    return try {
        LocalDateTime.parse(this, DateTimeFormatter.ofPattern(pattern, locale))
    } catch (e: DateTimeParseException) {
        null
    }
}

fun String.convertDateFormat(
    fromPattern: String,
    toPattern: String,
    locale: Locale = Locale.getDefault()
): String {
    val date = this.toDate(fromPattern, locale)
    return date?.format(toPattern, locale).orEmpty()
}