package com.gildedrose.domain.factory

import com.gildedrose.domain.AgedBrie
import com.gildedrose.domain.BackstagePass
import com.gildedrose.domain.Conjured
import com.gildedrose.domain.Item
import com.gildedrose.domain.Sulfuras
import com.gildedrose.domain.validation.Outcome
import com.gildedrose.domain.validation.validateQuality

fun createItem(name: String, sellin: Int, quality: Int): Outcome<Item> {
    val item = when {
        name.contains("Sulfuras", ignoreCase = true) -> Sulfuras(name, sellin, quality)
        name.contains("Aged Brie", ignoreCase = true) -> AgedBrie(name, sellin, quality)
        name.contains("Conjured", ignoreCase = true) -> Conjured(name, sellin, quality)
        name.contains("Backstage pass", ignoreCase = true) -> BackstagePass(name, sellin, quality)
        else -> Item(name, sellin, quality)
    }
    return validateQuality(item)
}