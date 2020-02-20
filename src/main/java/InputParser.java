package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Collections.unmodifiableList;

abstract class InputParser {
    //The following are used to map the potential user inputs to a data type that we support
    private final String STRING = "string";
    private final List<String> INT_LIST = unmodifiableList(
            new ArrayList<String>(Arrays.asList("integer", "int"))
    );
    private final List<String> BOOL_LIST = unmodifiableList(
            new ArrayList<String>(Arrays.asList("bool", "boolean"))
    );
    private final List<String> CHAR_LIST = unmodifiableList(
            new ArrayList<String>(Arrays.asList("character", "char"))
    );

    DataType inputToType(final String input) {
        String lower = input.toLowerCase().trim();
        if (INT_LIST.contains(lower))
            return DataType.INT;
        if (BOOL_LIST.contains(lower))
            return DataType.BOOLEAN;
        if (CHAR_LIST.contains(lower))
            return DataType.CHAR;
        if (lower.equals(STRING))
            return DataType.STRING;
            /*
            else we expect the user to have entered the data type with the correct spelling as there aren't common
            alternatives for the other data types once the spelling is converted to lower
            */
        else
            return DataType.valueOf(lower.toUpperCase());
    }
}
