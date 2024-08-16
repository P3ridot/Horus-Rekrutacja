package rekrutacja;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Bardzo podstawowa implementacja {@link Structure}, z użyciem {@code Java Stream API}. Aktualnie {@link
 * #findBlockByColor(String)} oraz {@link #findBlocksByMaterial(String)} przeliczane są przy każdym wywołaniu metody.
 * W prawdziwym projekcie może by te dane można przeliczać raz, może trzeba by je cacheować itp. - w szczególności,
 * gdyby metody te byłyby wykonywane często.
 */
public class Wall implements Structure {

    private final List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = List.copyOf(blocks); // Kopia listy, żeby nigdy nie modyfikować przekazanej do konstruktora listy
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return this.blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        /**
         * Uznałem, że zwracane będzie tutaj zawsze trzymana implementacji `Block` niezależnie od tego, czy byłby to
         * pojedynczy Block (SimpleBlock), czy np. CompositeBlock. Gdyby potrzeba było otrzymywać zawsze pojedyncze
         * bloki ("najniżej w hierarchii") to prawdopodobnie stworzyłbym dodatkową metodę `findBlockByMaterialFlatten`,
         * która by przechodziła po kolei przez bloki, zwracając pojedyncze blok (gdyby takie były trzymane) lub
         * zwracała bloki wewnętrzne (w przypadku CompositeBlock) o danym materiale.
         */
        return this.blocks.stream()
                .filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public int count() {
        return this.blocks.size();
    }

}