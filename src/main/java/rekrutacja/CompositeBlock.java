package rekrutacja;

import java.util.List;

/** Reprezentacja bloku składającego się z innych bloków. */
public interface CompositeBlock extends Block {

    /** Zwraca listę bloków składających się na ten blok. */
    List<Block> getBlocks();

}