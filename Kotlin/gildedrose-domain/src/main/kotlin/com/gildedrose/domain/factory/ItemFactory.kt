package com.gildedrose.domain.factory

import com.gildedrose.domain.AgedBrie
import com.gildedrose.domain.Conjured
import com.gildedrose.domain.Item
import com.gildedrose.domain.Sulfuras

fun createItem(name: String , sellin: Int , quality: Int): Item {
    return when {
        name.contains("Sulfuras", ignoreCase = true) -> Sulfuras(name, sellin, quality)
        name.contains("Aged Brie", ignoreCase = true) -> AgedBrie(name, sellin, quality)
        name.contains("Conjured", ignoreCase = true) -> Conjured(name, sellin, quality)
        else -> Item(name, sellin, quality)
    }
}