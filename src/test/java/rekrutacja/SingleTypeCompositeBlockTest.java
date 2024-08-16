package rekrutacja;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SingleTypeCompositeBlockTest extends BaseUnitTest {

    @Test
    void shouldCreateCompositeBlock() {
        // given
        Block block1 = new SimpleBlock(COLOR, MATERIAL);
        Block block2 = new SimpleBlock(COLOR, MATERIAL);

        // when
        CompositeBlock compositeBlock = new SingleTypeCompositeBlock(List.of(block1, block2));

        // then
        assertEquals(COLOR, compositeBlock.getColor());
        assertEquals(MATERIAL, compositeBlock.getMaterial());
        assertIterableEquals(List.of(block1, block2), compositeBlock.getBlocks());
    }

    @Test
    void shouldThrowExceptionIfListOfBlocksIsNullOrEmpty() {
        // expect
        assertThrows(IllegalArgumentException.class, () -> new SingleTypeCompositeBlock(null));
        assertThrows(IllegalArgumentException.class, () -> new SingleTypeCompositeBlock(List.of()));
    }

    @Test
    void shouldThrowExceptionIfBlocksHaveDifferentColor() {
        // given
        Block block1 = new SimpleBlock(COLOR, MATERIAL);
        Block block2 = new SimpleBlock(COLOR_ANOTHER, MATERIAL);

        // expect
        assertThrows(IllegalArgumentException.class, () -> new SingleTypeCompositeBlock(List.of(block1, block2)));
    }

    @Test
    void shouldThrowExceptionIfBlocksHaveDifferentMaterial() {
        // given
        Block block1 = new SimpleBlock(COLOR, MATERIAL);
        Block block2 = new SimpleBlock(COLOR, MATERIAL_ANOTHER);

        // expect
        assertThrows(IllegalArgumentException.class, () -> new SingleTypeCompositeBlock(List.of(block1, block2)));
    }

}
