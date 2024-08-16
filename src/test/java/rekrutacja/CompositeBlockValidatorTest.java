package rekrutacja;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CompositeBlockValidatorTest extends BaseUnitTest {

    @Test
    public void shouldThrowExceptionWhenBlocksListIsNullOrEmpty() {
        // expect
        assertThrows(IllegalArgumentException.class, () -> CompositeBlockValidator.validateBlocks(null));
        assertThrows(IllegalArgumentException.class, () -> CompositeBlockValidator.validateBlocks(List.of()));
    }

    @Test
    public void shouldThrowExceptionWhenBlocksAreNotAllTheSameColor() {
        // given
        List<Block> blocks = List.of(
                new SimpleBlock(COLOR, MATERIAL),
                new SimpleBlock(COLOR_ANOTHER, MATERIAL)
        );

        // expect
        assertThrows(IllegalArgumentException.class, () -> CompositeBlockValidator.validateBlocks(blocks));
    }

    @Test
    public void shouldThrowExceptionWhenBlocksAreNotAllTheSameMaterial() {
        // given
        List<Block> blocks = List.of(
                new SimpleBlock(COLOR, MATERIAL),
                new SimpleBlock(COLOR, MATERIAL_ANOTHER)
        );

        // expect
        assertThrows(IllegalArgumentException.class, () -> CompositeBlockValidator.validateBlocks(blocks));
    }

}
