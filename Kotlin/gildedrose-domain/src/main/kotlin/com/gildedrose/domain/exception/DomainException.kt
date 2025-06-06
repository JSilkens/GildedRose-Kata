package com.gildedrose.domain.exception

import java.lang.RuntimeException

abstract class DomainException(message: String) : RuntimeException(message) {
}