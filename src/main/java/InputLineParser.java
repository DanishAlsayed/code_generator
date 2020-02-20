package main.java;

import java.util.*;

import static main.java.CheckerUtils.checkString;

public class InputLineParser extends InputParser {
    private final char DELIM = ',';
    private final char ATT_DELIM = ':';
    private final String inputLine;

    //One line represents one class
    public InputLineParser(String inputLine) {
        checkString(inputLine, "inputLine");
        this.inputLine = inputLine;
    }

    public Class inputClass() {
        String[] parsedInput = inputLine.split(String.valueOf(DELIM));
        String className = parsedInput[0];
        checkClassName(className);
        List<Attribute> attributes = new ArrayList<>();
        for (int i = 1; i < parsedInput.length; i++) {
            String[] splitted = parsedInput[i].split(String.valueOf(ATT_DELIM));
            attributes.add(new Attribute(splitted[0], inputToType(splitted[1])));
        }
        return new Class(className, attributes);
    }

    private void checkClassName(final String name) {
        checkString(name, "className");
        if (name.contains(String.valueOf(ATT_DELIM))) {
            throw new IllegalArgumentException("Unable to fine class name in input");
        }
    }
}