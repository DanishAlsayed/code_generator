package main.java;

import java.util.Objects;

import static main.java.CheckerUtils.checkString;

public class Attribute {
    private final String name;
    private final DataType type;

    public Attribute(final String name, final DataType type) {
        checkString(name, "Attribute name");
        this.name = name.trim();
        this.type = type;
    }

    public String name() {
        return this.name;
    }

    public DataType type() {
        return this.type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Attribute)) return false;
        Attribute attribute = (Attribute) o;
        return name.equals(attribute.name) &&
                type == attribute.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
