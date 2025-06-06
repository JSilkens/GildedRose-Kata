package com.gildedrose.usecase.quality

import com.gildedrose.domain.factory.createItem
import com.gildedrose.domain.validation.Outcome
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ConjuredQualityUpdateUseCaseTest {

    private val useCase = ConjuredQualityUpdateUseCase()

    @Test
    fun `GIVEN Conjured item WHEN updating quality THEN quality decreases by 2`() {
        // GIVEN
        val item = (createItem(name = "Conjured Mana Cake", sellin = 5, quality = 10) as Outcome.Success).item
        val expected = (createItem(name = "Conjured Mana Cake", sellin = 4, quality = 8) as Outcome.Success).item

        // WHEN
        useCase.invoke(item)

        // THEN
        assertThat(item).isEqualTo(expected)
    }

    @Test
    fun `GIVEN Conjured item with quality 1 WHEN updating quality THEN quality does not go below 0`() {
        // GIVEN
        val item = (createItem(name ="Conjured Mana Cake", sellin = 5, quality = 1) as Outcome.Success).item
        val expected = (createItem(name = "Conjured Mana Cake", sellin = 4, quality = 0) as Outcome.Success).item

        // WHEN
        useCase.invoke(item)

        // THEN
        assertThat(item).isEqualTo(expected)
    }

    @Test
    fun `GIVEN Conjured item with sellIn zero WHEN updating quality THEN quality decreases by 4`() {
        // GIVEN
        val item = (createItem(name = "Conjured Mana Cake", sellin = 0, quality = 10) as Outcome.Success).item
        val expected = (createItem(name = "Conjured Mana Cake", sellin = -1, quality = 6) as Outcome.Success).item

        // WHEN
        useCase.invoke(item)

        // THEN
        assertThat(item).isEqualTo(expected)
    }

    @Test
    fun `GIVEN Conjured item with sellIn zero and low quality WHEN updating quality THEN quality does not go below 0`() {
        // GIVEN
        val item = (createItem("Conjured Mana Cake", sellin = 0, quality = 1) as Outcome.Success).item
        val expected = (createItem("Conjured Mana Cake", sellin = -1, quality = 0) as Outcome.Success).item

        // WHEN
        useCase.invoke(item)

        // THEN
        assertThat(item).isEqualTo(expected)
    }
}