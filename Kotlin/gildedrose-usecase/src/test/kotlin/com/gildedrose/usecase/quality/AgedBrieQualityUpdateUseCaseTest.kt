package com.gildedrose.usecase.quality

import com.gildedrose.domain.factory.createItem
import com.gildedrose.domain.validation.Outcome
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AgedBrieQualityUpdateUseCaseTest {

    private val useCase = AgedBrieQualityUpdateUseCase()

    @Test
    fun `GIVEN Aged Brie WHEN updating quality THEN quality increases by one`() {
        // GIVEN
        val item = (createItem(name = "Aged Brie", sellin = 5, quality = 10) as Outcome.Success).item
        val expected = (createItem(name = "Aged Brie", sellin = 4, quality = 11) as Outcome.Success).item

        // WHEN
        useCase.invoke(item)

        // THEN
        assertThat(item).isEqualTo(expected)
    }

    @Test
    fun `GIVEN Aged Brie at max quality WHEN updating quality THEN quality does not exceed 50`() {
        // GIVEN
        val item = (createItem(name = "Aged Brie", sellin = 5, quality = 50) as Outcome.Success).item
        val expected = (createItem(name = "Aged Brie", sellin = 4, quality = 50) as Outcome.Success).item

        // WHEN
        useCase.invoke(item)

        // THEN
        assertThat(item).isEqualTo(expected)
    }

    @Test
    fun `GIVEN Aged Brie with sellIn zero and quality near max WHEN updating quality THEN quality does not exceed 50`() {
        // GIVEN
        val item = (createItem(name = "Aged Brie", sellin = 0, quality = 50) as Outcome.Success).item
        val expected = (createItem(name = "Aged Brie", sellin = -1, quality = 50) as Outcome.Success).item

        // WHEN
        useCase.invoke(item)

        // THEN
        assertThat(item).isEqualTo(expected)
    }
}