package rekrutacja;

import java.util.List;

/** Walidator dla klasy {@link CompositeBlock}. */
final class CompositeBlockValidator {

    private CompositeBlockValidator() {}

    /**
     * Sprawdza, czy podane bloki spełniają warunki do utworzenia obiektu klasy {@link CompositeBlock}:
     * <ul>
     *     <li>podana lista bloków nie jest pusta
     *     <li>wszystkie bloki mają ten sam kolor
     *     <li>wszystkie bloki są z tego samego materiału
     * </ul>
     */
    static void validateBlocks(List<Block> blocks) {
        validateAtLeastOneBlock(blocks);
        validateAllBlockAreSameColor(blocks);
        validateAllBlockSameAreMaterial(blocks);
    }

    private static void validateAtLeastOneBlock(List<Block> blocks) {
        if (blocks == null || blocks.isEmpty()) {
            throw new IllegalArgumentException("Composite block must contain at least one block");
        }
    }

    private static void validateAllBlockSameAreMaterial(List<Block> blocks) {
        if (blocks.stream().map(Block::getMaterial).distinct().count() > 1) {
            throw new IllegalArgumentException("All blocks must have the same material");
        }
    }

    private static void validateAllBlockAreSameColor(List<Block> blocks) {
        if (blocks.stream().map(Block::getColor).distinct().count() > 1) {
            throw new IllegalArgumentException("All blocks must have the same color");
        }
    }

}
