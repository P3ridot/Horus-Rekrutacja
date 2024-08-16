package rekrutacja;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SimpleBlockTest extends BaseUnitTest {

    @Test
    void shouldCreateSimpleBlock() {
        // when
        Block block = new SimpleBlock(COLOR, MATERIAL);

        // then
        assertEquals(COLOR, block.getColor());
        assertEquals(MATERIAL, block.getMaterial());
    }

    @Test
    void shouldThrowExceptionIfAnyArgumentIsNull() {
        // expect
        assertThrows(NullPointerException.class, () -> new SimpleBlock(null, MATERIAL));
        assertThrows(NullPointerException.class, () -> new SimpleBlock(COLOR, null));
    }

    @Test
    void blocksWithTheSamePropertiesShouldNotAlwaysBeEqual() {
        // given
        Block block1 = new SimpleBlock(COLOR, MATERIAL);
        Block block2 = new SimpleBlock(COLOR, MATERIAL);

        // then
        assertNotEquals(block1, block2);
    }

}
