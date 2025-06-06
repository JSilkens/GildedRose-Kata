package com.gildedrose.usecase.quality

import com.gildedrose.domain.AgedBrie
import com.gildedrose.domain.Item

class AgedBrieQualityUpdateUseCase : QualityUpdateUseCase {
    override fun invoke(item: Item) {
        if (item is AgedBrie && item.quality < 50) {
            item.quality += 1
        }
        item.sellIn -= 1
    }
}