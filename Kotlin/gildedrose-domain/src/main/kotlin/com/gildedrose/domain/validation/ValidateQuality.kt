package com.gildedrose.domain.validation

import com.gildedrose.domain.Conjured
import com.gildedrose.domain.Item
import com.gildedrose.domain.exception.InvalidItemQualityException

fun validateQuality(item: Item): Outcome<Item> {
    return if (item !is Conjured && item.quality > 50) {
        Outcome.Failure(InvalidItemQualityException(item.quality))
    } else {
        Outcome.Success(item)
    }
}