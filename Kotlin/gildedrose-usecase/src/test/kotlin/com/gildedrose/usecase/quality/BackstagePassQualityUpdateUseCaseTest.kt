package com.gildedrose.usecase.quality

import com.gildedrose.domain.factory.createItem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BackstagePassQualityUpdateUseCaseTest {

    private val useCase = BackstagePassQualityUpdateUseCase()

    @Test
    fun `GIVEN Backstage pass with sellIn greater than 10 WHEN updating quality THEN quality increases by 1`() {
        //GIVEN
        val item = createItem("Backstage Pass", sellin = 15, quality = 20)
        val expected = createItem("Backstage Pass", sellin = 14, quality = 21)

        //WHEN
        useCase.invoke(item)

        //THEN
        assertThat(item).isEqualTo(expected)
    }

    @Test
    fun `GIVEN Backstage pass with sellIn 10 WHEN updating quality THEN quality increases by 2`() {
        //GIVEN
        val item = createItem("Backstage Pass", sellin = 10, quality = 20)
        val expected = createItem("Backstage Pass", sellin = 9, quality = 22)

        //WHEN
        useCase.invoke(item)

        //THEN
        assertThat(item).isEqualTo(expected)
    }

    @Test
    fun `GIVEN Backstage pass with sellIn 5 WHEN updating quality THEN quality increases by 3`() {
        //GIVEN
        val item = createItem("Backstage Pass", sellin = 5, quality = 5)
        val expected = createItem("Backstage Pass", sellin = 4, quality = 8)

        //WHEN
        useCase.invoke(item)

        //THEN
        assertThat(item).isEqualTo(expected)
    }

    @Test
    fun `GIVEN Backstage pass with sellIn 0 WHEN updating quality THEN quality drops to 0`() {
        //GIVEN
        val item = createItem("Backstage Pass", sellin = 0, quality = 1)
        val expected = createItem("Backstage Pass", sellin = -1, quality = 0)

        //WHEN
        useCase.invoke(item)

        //THEN
        assertThat(item).isEqualTo(expected)
    }

    @Test
    fun `GIVEN Backstage pass with quality near max WHEN updating quality THEN quality does not exceed 50`() {
        //GIVEN
        val item = createItem("Backstage Pass", sellin = 5, quality = 50)
        val expected = createItem("Backstage Pass", sellin = 4, quality = 50)

        //WHEN
        useCase.invoke(item)

        //THEN
        assertThat(item).isEqualTo(expected)
    }
}