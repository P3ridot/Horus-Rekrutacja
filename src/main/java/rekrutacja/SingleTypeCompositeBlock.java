package rekrutacja;

import java.util.List;

/**
 * Ta implementacja {@link CompositeBlock} jest przede wszystkim kompozytem, który przechowuje listę bloków.
 * Zaletą kompozycji nad dziedziczeniem jest to, że łatwiej jest nam utrzymać przejrzystość kodu, a także
 * możemy łatwo zmieniać zachowanie obiektu, dodając nowe bloki, bez konieczności głębokiej zmiany kodu.
 * <p>
 * Przykładowo: Zaszłaby potrzeba dodania metody {@code Block#break} - używając kompozycji, zaimplementowalibyśmy tę
 * metodę w klasie {@link SimpleBlock}, a nasza klasa {@link SingleTypeCompositeBlock} mogłaby przykładowo iterować
 * po wszystkich blokach "w sobie", wywołując na nich {@code Block#break()}. Nasza implementacja byłaby wtedy
 * bardziej elastyczna. Ewentualna zmiana działania metody {@code Block#break()}, wymagałaby tylko zmiany w klasie
 * {@link SimpleBlock}, a nie w całej hierarchii dziedziczenia.
 * <p>
 * Dodatkowo moja implementacja {@link CompositeBlock} pozwala na przechowywanie listy bloków, które są jednolite pod
 * względem koloru i materiału, ponieważ niezbyt jest inny sposób, aby trzymać wiele różnych bloków, zwracając przy tym
 * pojedyncze wartości w {@link #getColor()} i {@link #getMaterial()}.
 * <p>
 * W prawdziwym projekcie może wartość koloru/materiału ustalałoby się inaczej. Przykładowo bezpośrednio podając kolor i
 * materiał w konstruktorze, pobierając kolor/materiał z 1. elementu z listy (czyli właściwie aktualna implementacja,
 * bez dodatkowej walidacji), lub może nawet zmieniając strukturę `Block` i zwracając List<String> zamiast pojedynczych
 * Stringów, w bazowych metodach {@link Block#getColor()} i {@link Block#getMaterial()}.
 */
public class SingleTypeCompositeBlock implements CompositeBlock {

    private final List<Block> blocks;

    private final String color;
    private final String material;

    SingleTypeCompositeBlock(List<Block> blocks) {
        CompositeBlockValidator.validateBlocks(blocks);
        this.blocks = List.copyOf(blocks); // Kopia listy, żeby nigdy nie modyfikować przekazanej do konstruktora listy

        // Wyliczenie wartości od razu pozwoli na mniej obliczeń przy pobieraniu
        this.color = blocks.get(0).getColor();
        this.material = blocks.get(0).getMaterial();
    }

    @Override
    public List<Block> getBlocks() {
        return this.blocks;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getMaterial() {
        return this.material;
    }

}
