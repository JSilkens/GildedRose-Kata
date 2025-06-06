package com.gildedrose.usecase

import com.gildedrose.domain.AgedBrie
import com.gildedrose.domain.BackstagePass
import com.gildedrose.domain.Conjured
import com.gildedrose.domain.Item
import com.gildedrose.domain.Sulfuras
import com.gildedrose.usecase.quality.AgedBrieQualityUpdateUseCase
import com.gildedrose.usecase.quality.BackstagePassQualityUpdateUseCase
import com.gildedrose.usecase.quality.ConjuredQualityUpdateUseCase
import com.gildedrose.usecase.quality.StandardItemQualityUpdateUseCase
import com.gildedrose.usecase.quality.SulfurasQualityUpdateUseCase

class GildedRose(val items: List<Item>) {
    private val standardUpdate = StandardItemQualityUpdateUseCase()
    private val conjuredUpdate = ConjuredQualityUpdateUseCase()
    private val agedBrieUpdate = AgedBrieQualityUpdateUseCase()
    private val backstagePassUpdate = BackstagePassQualityUpdateUseCase()
    private val sulfurasUpdate = SulfurasQualityUpdateUseCase()

    fun updateQuality() {
        items.forEach { item ->
            val updateStrategy = when (item) {
                is Conjured -> conjuredUpdate
                is AgedBrie -> agedBrieUpdate
                is BackstagePass -> backstagePassUpdate
                is Sulfuras -> sulfurasUpdate
                else -> standardUpdate
            }
            updateStrategy.invoke(item)
        }
    }
}

