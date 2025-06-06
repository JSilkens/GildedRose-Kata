package com.gildedrose.usecase

import com.gildedrose.domain.factory.createItem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class GildedRoseTest {

    @Test
    fun `GIVEN a regular item WHEN updating quality THEN quality and sellIn decrease by one`() {
        //GIVEN
        val items = listOf(createItem("regular item", 10, 20))
        val app = GildedRose(items)

        //WHEN
        app.updateQuality()

        //THEN
        assertThat(items[0])
            .extracting("sellIn", "quality")
            .containsExactly(9, 19)
    }

    @Test
    fun `GIVEN a regular item with sellIn zero WHEN updating quality THEN quality degrades twice as fast`() {
        // GIVEN
        val items = listOf(createItem("regular item", 0, 20))
        val app = GildedRose(items)

        // WHEN
        app.updateQuality()

        // THEN
       assertThat(items[0])
           .extracting("sellIn", "quality")
           .containsExactly(-1, 18)
    }

    @Test
    fun `GIVEN a regular item with zero quality WHEN updating quality THEN quality remains zero`() {
        // GIVEN
        val items = listOf(createItem("regular item", 5, 0))
        val app = GildedRose(items)

        // WHEN
        app.updateQuality()

        // THEN
       assertThat(items[0].quality)
           .isGreaterThanOrEqualTo(0)
    }

    @Test
    fun `GIVEN Aged Brie WHEN updating quality THEN quality increases`() {
        // GIVEN
        val items = listOf(createItem("Aged Brie", 5, 10))
        val app = GildedRose(items)

        // WHEN
        app.updateQuality()

        // THEN
       assertThat(items[0].quality)
           .isEqualTo(11)
    }

    @Test
    fun `GIVEN an item at max quality WHEN updating quality THEN quality does not exceed 50`() {
        // GIVEN
        val items = listOf(createItem("Aged Brie", 5, 50))
        val app = GildedRose(items)

        // WHEN
        app.updateQuality()

        // THEN
       assertThat(items[0].quality)
           .isEqualTo(50)
    }

    @Test
    fun `GIVEN Sulfuras WHEN updating quality THEN quality and sellIn do not change`() {
        // GIVEN
        val items = listOf(createItem("Sulfuras, Hand of Ragnaros", 5, 80))
        val app = GildedRose(items)

        // WHEN
        app.updateQuality()

        // THEN
      assertThat(items[0])
          .extracting("sellIn", "quality")
          .containsExactly(5, 80)
    }


    @ParameterizedTest
    @CsvSource(
        // sellIn, quality, expectedQuality, description
        "11, 20, 21, 'Normal increase'",
        "10, 20, 22, 'Increases by 2'",
        "5, 20, 23, 'Increases by 3'",
        "0, 20, 0, 'Drops to 0 after concert'"
    )
    fun `GIVEN Backstage passes WHEN updating quality THEN quality changes as expected`(
        sellIn: Int,
        quality: Int,
        expectedQuality: Int,
        description: String
    ) {
        // GIVEN
        val items = listOf(createItem("Backstage passes to a TAFKAL80ETC concert", sellIn, quality))
        val app = GildedRose(items)

        // WHEN
        app.updateQuality()

        // THEN
        assertThat(items[0].quality)
            .`as`(description)
            .isEqualTo(expectedQuality)
    }
}