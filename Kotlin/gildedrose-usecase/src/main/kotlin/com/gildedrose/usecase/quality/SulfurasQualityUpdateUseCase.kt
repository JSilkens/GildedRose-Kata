package com.gildedrose.usecase.quality

import com.gildedrose.domain.Item

class SulfurasQualityUpdateUseCase : QualityUpdateUseCase {
    override fun invoke(item: Item) {
        // Sulfuras is a legendary item, its quality does not change
    }
}