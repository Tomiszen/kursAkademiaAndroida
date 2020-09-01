package com.tomisztomek.kursakademiaandroida.core.exception

interface ErrorMapper {
    fun map(throwable: Throwable): String
}