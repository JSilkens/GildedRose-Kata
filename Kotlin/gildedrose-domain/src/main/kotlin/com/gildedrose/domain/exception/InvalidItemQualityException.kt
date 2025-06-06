package com.gildedrose.domain.exception

class InvalidItemQualityException(quality: Int): DomainException("Invalid item quality: $quality") {

}