package rekrutacja;

import java.util.List;
import java.util.Optional;

/** Reprezentacja struktury składającej się z bloków. */
public interface Structure {

    /** Zwraca pierwszy blok o podanym kolorze. */
    Optional<Block> findBlockByColor(String color);

    /** Zwraca wszystkie bloki z danego materiału. */
    List<Block> findBlocksByMaterial(String material);

    /** Zwraca liczbę wszystkich bloków tworzących strukturę. */
    int count();

}