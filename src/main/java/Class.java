package main.java;

import java.util.List;

import static main.java.CheckerUtils.checkList;
import static main.java.CheckerUtils.checkString;

public class Class {
    private final List<Attribute> attributes;
    private final String name;

    public Class(final String name, final List<Attribute> attributes) {
        checkList(attributes, "Class attributes");
        checkString(name, "Class name");
        this.attributes = attributes;
        this.name = name.trim();
    }

    public List<Attribute> attributes() {
        return this.attributes;
    }

    public String name() {
        return this.name;
    }
}
