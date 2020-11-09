package com.tomisztomek.kursakademiaandroida.core.extenstion

fun String.Companion.empty() = ""

fun String.getOrNullIfUnknown() =
    if (this == "unknown") null
    else this