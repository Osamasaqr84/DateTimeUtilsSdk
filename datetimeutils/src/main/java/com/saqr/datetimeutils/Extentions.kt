package com.saqr.datetimeutils

import java.util.Date
import java.util.Locale

fun String.toDate(
    pattern: String,
    locale: Locale = Locale.getDefault()
): Date?