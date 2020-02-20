package main.java;

public enum DataType {
    /*
    These are the supported data types, primitives only
    This enum class represents a mapping of the data types to a string with the same spelling as java syntax
    */
    STRING("String"),
    CHAR("char"),
    INT("int"),
    LONG("long"),
    SHORT("short"),
    BYTE("byte"),
    DOUBLE("double"),
    FLOAT("float"),
    BOOLEAN("boolean");

    private String type;

    DataType(String type) {
        this.type = type;
    }

    public String type() {
        return type;
    }
}
