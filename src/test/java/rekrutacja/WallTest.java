package rekrutacja;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WallTest extends BaseUnitTest {

    @Test
    void shouldCreateWall() {
        // given
        Block block1 = new SimpleBlock(COLOR, MATERIAL);
        Block block2 = new SimpleBlock(COLOR, MATERIAL);
        Block block3 = new SimpleBlock(COLOR_ANOTHER, MATERIAL_ANOTHER);
        Block block4 = new SingleTypeCompositeBlock(List.of(block1, block2));

        // when
        Structure wall = new Wall(List.of(block1, block2, block3, block4));

        // then
        Optional<Block> blockByColor = wall.findBlockByColor(COLOR);
        assertTrue(blockByColor.isPresent());
        assertEquals(COLOR, blockByColor.get().getColor());

        // and
        Optional<Block> blockByAnotherColor = wall.findBlockByColor(COLOR_ANOTHER);
        assertTrue(blockByAnotherColor.isPresent());
        assertEquals(COLOR_ANOTHER, blockByAnotherColor.get().getColor());

        // and
        List<Block> blocksByMaterial = wall.findBlocksByMaterial(MATERIAL);
        assertEquals(3, blocksByMaterial.size());
        blocksByMaterial.forEach(block -> assertEquals(MATERIAL, block.getMaterial()));

        // and
        List<Block> blocksByAnotherMaterial = wall.findBlocksByMaterial(MATERIAL_ANOTHER);
        assertEquals(1, blocksByAnotherMaterial.size());
        assertEquals(MATERIAL_ANOTHER, blocksByAnotherMaterial.get(0).getMaterial());

        // and
        assertEquals(4, wall.count());
    }

    @Test
    void shouldNotFindBlockByNonexistentColor() {
        // given
        Block block = new SimpleBlock(COLOR, MATERIAL);
        Structure wall = new Wall(List.of(block));

        // then
        Optional<Block> empty = wall.findBlockByColor(COLOR_ANOTHER);
        assertTrue(empty.isEmpty());
    }

    @Test
    void shouldNotFindBlockByNonexistentMaterial() {
        //given
        Block block = new SimpleBlock(COLOR, MATERIAL);
        Structure wall = new Wall(List.of(block));

        //then
        List<Block> empty = wall.findBlocksByMaterial(MATERIAL_ANOTHER);
        assertTrue(empty.isEmpty());
    }

}
