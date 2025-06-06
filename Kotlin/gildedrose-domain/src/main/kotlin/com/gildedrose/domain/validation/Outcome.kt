package com.gildedrose.domain.validation

import com.gildedrose.domain.exception.DomainException

sealed class Outcome<out T> {
    data class Success<out T>(val item: T) : Outcome<T>()
    data class Failure(val exception: DomainException) : Outcome<Nothing>()
}