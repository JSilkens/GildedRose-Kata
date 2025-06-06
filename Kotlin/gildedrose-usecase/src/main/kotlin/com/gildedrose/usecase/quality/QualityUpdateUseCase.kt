package com.gildedrose.usecase.quality

import com.gildedrose.domain.Item

interface QualityUpdateUseCase {
    fun invoke(item: Item)
}