package com.saqr.datetimeutils

import android.os.Build
import androidx.annotation.RequiresApi


import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.Date
import java.util.Locale

fun Long.toDate(): Date =
    Date(this)
@RequiresApi(Build.VERSION_CODES.O)
fun Long.toLocalDateTime(
    zoneId: ZoneId = ZoneId.systemDefault()
): LocalDateTime {
    return Instant.ofEpochMilli(this)
        .atZone(zoneId)
        .toLocalDateTime()
}
@RequiresApi(Build.VERSION_CODES.O)
fun Long.toLocalDate(
    zoneId: ZoneId = ZoneId.systemDefault()
): LocalDate {
    return Instant.ofEpochMilli(this)
        .atZone(zoneId)
        .toLocalDate()
}

fun Long.toTimeAgo(
    nowMillis: Long = System.currentTimeMillis()
): String {
    val diffMillis = nowMillis - this

    if (diffMillis < 0) return "In the future"

    val seconds = diffMillis / 1000
    val minutes = seconds / 60
    val hours = minutes / 60
    val days = hours / 24
    val weeks = days / 7
    val months = days / 30
    val years = days / 365

    return when {
        seconds < 60 -> "Just now"
        minutes == 1L -> "1 minute ago"
        minutes < 60 -> "$minutes minutes ago"
        hours == 1L -> "1 hour ago"
        hours < 24 -> "$hours hours ago"
        days == 1L -> "Yesterday"
        days < 7 -> "$days days ago"
        weeks == 1L -> "1 week ago"
        weeks < 4 -> "$weeks weeks ago"
        months == 1L -> "1 month ago"
        months < 12 -> "$months months ago"
        years == 1L -> "1 year ago"
        else -> "$years years ago"
    }
}

fun Long.toRemainingTime(
    nowMillis: Long = System.currentTimeMillis()
): String {
    var diffMillis = this - nowMillis

    if (diffMillis <= 0) return "Expired"

    val days = diffMillis / (24 * 60 * 60 * 1000)
    diffMillis %= 24 * 60 * 60 * 1000

    val hours = diffMillis / (60 * 60 * 1000)
    diffMillis %= 60 * 60 * 1000

    val minutes = diffMillis / (60 * 1000)
    diffMillis %= 60 * 1000

    val seconds = diffMillis / 1000

    return when {
        days > 0 -> "${days}d ${hours}h"
        hours > 0 -> "${hours}h ${minutes}m"
        minutes > 0 -> "${minutes}m ${seconds}s"
        else -> "${seconds}s"
    }
}