import com.gildedrose.domain.AgedBrie
import com.gildedrose.domain.BackstagePass
import com.gildedrose.domain.Conjured
import com.gildedrose.domain.Item
import com.gildedrose.domain.Sulfuras
import com.gildedrose.domain.factory.createItem
import com.gildedrose.domain.validation.Outcome
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ItemFactoryTests {
    @Test
    fun `GIVEN item with name containing BACKSTAGE PASS WHEN create THEN item of type BackstagePass created`() {
        val item = createItem("BACKSTAGE PASSES TO A TAFKAL80ETC CONCERT", 15, 20)

        assertThat(item).isInstanceOfSatisfying(Outcome.Success::class.java) { success ->
            assertThat(success.item).isInstanceOf(BackstagePass::class.java)
        }
    }

    @Test
    fun `GIVEN item with name containing backstage pass WHEN create THEN item of type BackstagePass created`() {
        val item = createItem("backstage passes to a tafkal80etc concert", 15, 20)

        assertThat(item).isInstanceOfSatisfying(Outcome.Success::class.java) { success ->
            assertThat(success.item).isInstanceOf(BackstagePass::class.java)
        }
    }

    @Test
    fun `GIVEN item with name containing Backstage Pass WHEN create THEN item of type BackstagePass created`() {
        val item = createItem("Backstage Passes to a TAFKAL80ETC concert", 15, 20)

        assertThat(item).isInstanceOfSatisfying(Outcome.Success::class.java) { success ->
            assertThat(success.item).isInstanceOf(BackstagePass::class.java)
        }
    }

    @Test
    fun `GIVEN item with name containing SULFURAS WHEN create THEN item of type Sulfuras created`() {
        val item = createItem("SULFURAS, HAND OF RAGNAROS", 0, 80)

        assertThat(item).isInstanceOfSatisfying(Outcome.Success::class.java) { success ->
            assertThat(success.item).isInstanceOf(Sulfuras::class.java)
        }
    }

    @Test
    fun `GIVEN item with name containing sulfuras WHEN create THEN item of type Sulfuras created`() {
        val item = createItem("sulfuras, hand of ragnaros", 0, 80)

        assertThat(item).isInstanceOfSatisfying(Outcome.Success::class.java) { success ->
            assertThat(success.item).isInstanceOf(Sulfuras::class.java)
        }
    }

    @Test
    fun `GIVEN item with name containing AGED BRIE WHEN create THEN item of type AgedBrie created`() {
        val item = createItem("AGED BRIE", 10, 20)

        assertThat(item).isInstanceOfSatisfying(Outcome.Success::class.java) { success ->
            assertThat(success.item).isInstanceOf(AgedBrie::class.java)
        }
    }

    @Test
    fun `GIVEN item with name containing aged brie WHEN create THEN item of type AgedBrie created`() {
        val item = createItem("aged brie", 10, 20)

        assertThat(item).isInstanceOfSatisfying(Outcome.Success::class.java) { success ->
            assertThat(success.item).isInstanceOf(AgedBrie::class.java)
        }
    }


    @Test
    fun `GIVEN item with name containing CONJURED WHEN create THEN item of type Conjured created`() {
        val item = createItem("CONJURED MANA CAKE", 5, 30)

        assertThat(item).isInstanceOfSatisfying(Outcome.Success::class.java) { success ->
            assertThat(success.item).isInstanceOf(Conjured::class.java)
        }
    }

    @Test
    fun `GIVEN item with name containing conjured WHEN create THEN item of type Conjured created`() {
        val item = createItem("conjured mana cake", 5, 30)

        assertThat(item).isInstanceOfSatisfying(Outcome.Success::class.java) { success ->
            assertThat(success.item).isInstanceOf(Conjured::class.java)
        }
    }

    @Test
    fun `GIVEN item with name containing Sulfuras WHEN create THEN item of type Sulfuras created`() {
        val item = createItem("Sulfuras, Hand of Ragnaros", 0, 80)

        assertThat(item).isInstanceOfSatisfying(Outcome.Success::class.java) { success ->
            assertThat(success.item).isInstanceOf(Sulfuras::class.java)
        }
    }

    @Test
    fun `GIVEN item with name containing Aged Brie WHEN create THEN item of type AgedBrie created`() {
        val item = createItem("Aged Brie", 10, 20)

        assertThat(item).isInstanceOfSatisfying(Outcome.Success::class.java) { success ->
            assertThat(success.item).isInstanceOf(AgedBrie::class.java)
        }
    }

    @Test
    fun `GIVEN item with name containing Conjured WHEN create THEN item of type Conjured created`() {
        val item = createItem("Conjured Mana Cake", 5, 30)

        assertThat(item).isInstanceOfSatisfying(Outcome.Success::class.java) { success ->
            assertThat(success.item).isInstanceOf(Conjured::class.java)
        }
    }

    @Test
    fun `GIVEN generic item WHEN create THEN generic item created`() {
        val item = createItem("Random Item", 15, 25)

        assertThat(item).isInstanceOfSatisfying(Outcome.Success::class.java) { success ->
            assertThat(success.item).isInstanceOf(Item::class.java)
        }
    }

}