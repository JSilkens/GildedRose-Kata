import com.gildedrose.domain.Conjured
import com.gildedrose.domain.Item
import com.gildedrose.domain.exception.InvalidItemQualityException
import com.gildedrose.domain.validation.Outcome
import com.gildedrose.domain.validation.validateQuality
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ValidateQualityTest {

    @Test
    fun `GIVEN a regular item with quality smaller or equal to 50 WHEN validateQuality is called THEN returns Success`() {
        // GIVEN
        val item = Item("Regular", 10, 50)
        // WHEN
        val result = validateQuality(item)
        // THEN
        assertThat(result)
            .isInstanceOf(Outcome.Success::class.java)
            .extracting { (it as Outcome.Success).item }
            .isEqualTo(item)
    }

    @Test
    fun `GIVEN a regular item with quality greater than 50 WHEN validateQuality is called THEN returns Failure`() {
        // GIVEN
        val item = Item("Regular", 10, 51)
        // WHEN
        val result = validateQuality(item)
        // THEN
        assertThat(result)
            .isInstanceOf(Outcome.Failure::class.java)
        assertThat((result as Outcome.Failure).exception)
            .isInstanceOf(InvalidItemQualityException::class.java)
    }

    @Test
    fun `GIVEN a conjured item with quality greater than 50 WHEN validateQuality is called THEN returns Failure`() {
        // GIVEN
        val item = Conjured("Conjured Mana Cake", 5, 80)
        // WHEN
        val result = validateQuality(item)
        // THEN
        assertThat(result)
            .isInstanceOf(Outcome.Failure::class.java)

    }
}