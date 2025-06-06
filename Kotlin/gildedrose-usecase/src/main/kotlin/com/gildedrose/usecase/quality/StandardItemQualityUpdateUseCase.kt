package com.gildedrose.usecase.quality

import com.gildedrose.domain.Item

class StandardItemQualityUpdateUseCase : QualityUpdateUseCase {
    override fun invoke(item: Item) {
        if (item.quality > 0) {
            item.quality -= 1
        }
        item.sellIn -= 1

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality -= 1
        }
    }
}