package com.saqr.datetimeutils

import android.os.Build
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.*
import java.time.format.DateTimeFormatter
import java.util.Locale
@RequiresApi(Build.VERSION_CODES.O)
object DateTimeUtils {

    @RequiresApi(Build.VERSION_CODES.O)
    fun now(): LocalDateTime = LocalDateTime.now()

    fun today(): LocalDate = LocalDate.now()

    fun currentTimestamp(): Long = System.currentTimeMillis()

    fun currentUtcTimestamp(): Long = Instant.now().toEpochMilli()

    fun getCurrentUtcTime(): LocalDateTime =
        LocalDateTime.now(ZoneOffset.UTC)

    fun getCurrentLocalTime(): LocalDateTime =
        LocalDateTime.now()

    fun isLeapYear(year: Int): Boolean =
        Year.isLeap(year.toLong())

    fun daysInMonth(year: Int, month: Int): Int =
        YearMonth.of(year, month).lengthOfMonth()

    fun formatter(
        pattern: String,
        locale: Locale = Locale.getDefault()
    ): DateTimeFormatter =
        DateTimeFormatter.ofPattern(pattern, locale)

    fun simpleFormatter(
        pattern: String,
        locale: Locale = Locale.getDefault()
    ): SimpleDateFormat =
        SimpleDateFormat(pattern, locale)
}