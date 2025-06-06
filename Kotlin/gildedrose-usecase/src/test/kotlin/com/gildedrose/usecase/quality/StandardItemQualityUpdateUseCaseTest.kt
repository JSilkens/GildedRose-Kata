package com.gildedrose.usecase.quality

import com.gildedrose.domain.factory.createItem
import com.gildedrose.domain.validation.Outcome
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StandardItemQualityUpdateUseCaseTest {

    private val useCase = StandardItemQualityUpdateUseCase()

    @Test
    fun `GIVEN standard item WHEN updating quality THEN quality and sellIn decrease by one`() {
        //GIVEN
        val outcome = createItem(name = "Regular Item", sellin = 10, quality = 20)
        val item = (outcome as Outcome.Success).item

        //WHEN
        useCase.invoke(item)

        //THEN
        assertThat(item.sellIn).isEqualTo(9)
        assertThat(item.quality).isEqualTo(19)
    }

    @Test
    fun `GIVEN standard item with sellIn zero WHEN updating quality THEN quality decreases by two`() {
        // GIVEN
        val outcome = createItem(name = "Regular Item", sellin = 0, quality = 20)
        val item = (outcome as Outcome.Success).item

        // WHEN
        useCase.invoke(item)

        // THEN
        assertThat(item.sellIn).isEqualTo(-1)
        assertThat(item.quality).isEqualTo(18)
    }

    @Test
    fun `GIVEN standard item with zero quality WHEN updating quality THEN quality remains zero`() {
        // GIVEN
        val outcome = createItem(name = "Regular Item", 5, 0)
        val item = (outcome as Outcome.Success).item

        // WHEN
        useCase.invoke(item)

        // THEN
        assertThat(item.sellIn).isEqualTo(4)
        assertThat(item.quality).isEqualTo(0)
    }

    @Test
    fun `GIVEN standard item with sellIn zero and quality one WHEN updating quality THEN quality does not go below zero`() {
        // GIVEN
        val outcome = createItem(name = "Regular Item", sellin = 0 , quality = 1)
        val item = (outcome as Outcome.Success).item

        // WHEN
        useCase.invoke(item)

        // THEN
        assertThat(item.sellIn).isEqualTo(-1)
        assertThat(item.quality).isEqualTo(0)
    }
}