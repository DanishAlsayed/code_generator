package main.java;

import java.util.List;

class CheckerUtils {
    private static final String NULL_OR_EMPTY = " cannot be null or empty.";

    static void checkString(String value, String name) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException(name + NULL_OR_EMPTY);
        }
    }

    static void checkList(List list, String name) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(name + NULL_OR_EMPTY);
        }
    }
}
