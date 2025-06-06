package com.gildedrose.usecase.quality

import com.gildedrose.domain.BackstagePass
import com.gildedrose.domain.Item

class BackstagePassQualityUpdateUseCase : QualityUpdateUseCase {
    override fun invoke(item: Item) {
            if (item is BackstagePass && item.quality < 50) {
                item.quality += 1
                if (item.sellIn < 11 && item.quality < 50) item.quality += 1
                if (item.sellIn < 6 && item.quality < 50) item.quality += 1
            }
            item.sellIn -= 1
            if (item.sellIn < 0) item.quality = 0
        }
}