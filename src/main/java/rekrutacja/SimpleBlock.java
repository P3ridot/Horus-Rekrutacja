package rekrutacja;

import java.util.Objects;

/** Prosta reprezentacja pojedynczego bloku. */
public class SimpleBlock implements Block {

    private final String color;
    private final String material;

    public SimpleBlock(String color, String material) {
        this.color = Objects.requireNonNull(color, "Color cannot be null");
        this.material = Objects.requireNonNull(material, "Material cannot be null");
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
