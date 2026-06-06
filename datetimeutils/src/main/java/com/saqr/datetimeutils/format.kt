package com.saqr.datetimeutils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Calendar
import java.util.Date
import java.util.Locale
import java.util.TimeZone

fun Date.format(
    pattern: String,
    locale: Locale = Locale.getDefault(),
    timeZone: TimeZone = TimeZone.getDefault()
): String {
    return SimpleDateFormat(pattern, locale).apply {
        this.timeZone = timeZone
    }.format(this)
}

fun Date.startOfDay(): Date {
    return Calendar.getInstance().apply {
        time = this@startOfDay
        set(Calendar.HOUR_OF_DAY, 0)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
        set(Calendar.MILLISECOND, 0)
    }.time
}

fun Date.endOfDay(): Date {
    return Calendar.getInstance().apply {
        time = this@endOfDay
        set(Calendar.HOUR_OF_DAY, 23)
        set(Calendar.MINUTE, 59)
        set(Calendar.SECOND, 59)
        set(Calendar.MILLISECOND, 999)
    }.time
}

fun Date.plusDays(days: Int): Date {
    return Calendar.getInstance().apply {
        time = this@plusDays
        add(Calendar.DAY_OF_YEAR, days)
    }.time
}

fun Date.plusMonths(months: Int): Date {
    return Calendar.getInstance().apply {
        time = this@plusMonths
        add(Calendar.MONTH, months)
    }.time
}

fun Date.plusYears(years: Int): Date {
    return Calendar.getInstance().apply {
        time = this@plusYears
        add(Calendar.YEAR, years)
    }.time
}

fun Date.daysBetween(other: Date): Long =
    (other.time - this.time) / (24 * 60 * 60 * 1000)

fun Date.hoursBetween(other: Date): Long =
    (other.time - this.time) / (60 * 60 * 1000)

fun Date.minutesBetween(other: Date): Long =
    (other.time - this.time) / (60 * 1000)

@RequiresApi(Build.VERSION_CODES.O)
fun Date.toLocalDateTime(
    zoneId: ZoneId = ZoneId.systemDefault()
): LocalDateTime {
    return this.toInstant()
        .atZone(zoneId)
        .toLocalDateTime()
}
@RequiresApi(Build.VERSION_CODES.O)
fun Date.toLocalDate(
    zoneId: ZoneId = ZoneId.systemDefault()
): LocalDate {
    return this.toInstant()
        .atZone(zoneId)
        .toLocalDate()
}

