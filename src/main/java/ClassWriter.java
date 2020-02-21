package main.java;

import org.ainslec.picocog.PicoWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.requireNonNull;

public class ClassWriter {
    public static final int CLASS_NAME_INDX = 0;
    public static final int CLASS_CONTENT_INDX = 1;
    private final String SEMI_COLON = ";";
    private final String VAR_NAMES = "varNames";
    private final String PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "java";

    /**
     * Converts Class object to a java class and optionally writes it to file
     *
     * @param clss   Class object to convert
     * @param toFile boolean whether to write it to file or not, sadly java doesn't have a default value parameters
     * @return a list, the first one is the file name (in out case it is the path as well as we are not changing the working directory) and the java class as string
     */
    public List<String> write(final Class clss, boolean toFile) {
        requireNonNull(clss);

        PicoWriter outerWriter = new PicoWriter();
        outerWriter.writeln("package main.java;");
        outerWriter.writeln("import java.util.List;");
        outerWriter.writeln("import java.util.ArrayList;");
        outerWriter.writeln_r("public class " + clss.name() + " {");
        writeAttributes(clss, outerWriter);
        outerWriter.writeln("");
        writeConstructor(clss, outerWriter);
        writeFunctionF(outerWriter, clss.name());
        outerWriter.writeln_l("}");
        String fileName = clss.name() + ".java";
        if (toFile) {
            if (writeFile(outerWriter, PATH + File.separator + fileName)) return null;
        }
        return Arrays.asList(PATH + File.separator + fileName, outerWriter.toString());
    }

    private void writeFunctionF(final PicoWriter outerWriter, final String className) {
        outerWriter.writeln_r("public Object f(String var) {");
        outerWriter.writeln_r("if (var == null || var.isEmpty()) {");
        outerWriter.writeln("return null;");
        outerWriter.writeln_l("}");
        outerWriter.writeln_r("if (" + VAR_NAMES + ".contains(var)) {");
        outerWriter.writeln_r("try {");
        outerWriter.writeln("return " + className + ".class.getField(var).get(this);");
        outerWriter.writeln_l("}");
        outerWriter.writeln_r("catch (Exception e) {");
        outerWriter.writeln("System.out.println(\"Unable to retrieve variable due to the following error:\" + e.getMessage());");
        outerWriter.writeln("return null;");
        outerWriter.writeln_l("}");
        outerWriter.writeln_l("}");
        outerWriter.writeln("return null;");
        outerWriter.writeln_l("}");
    }

    private boolean writeFile(final PicoWriter outerWriter, final String fileName) {
        try {
            Files.write(Paths.get(fileName), outerWriter.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
            return true;
        }
        return false;
    }

    private void writeConstructor(final Class clss, final PicoWriter outerWriter) {
        outerWriter.writeln_r("public " + clss.name() + "(" + attributeString(clss.attributes()) + ") {");
        clss.attributes().forEach(attribute -> {
            outerWriter.writeln("this." + attribute.name() + " = " + attribute.name() + SEMI_COLON);
            outerWriter.writeln("varNames.add(\"" + attribute.name() + "\");");
        });
        outerWriter.writeln_l("}");
    }

    private void writeAttributes(final Class clss, final PicoWriter outerWriter) {
        outerWriter.writeln("private List<String> " + VAR_NAMES + " = new ArrayList<>();");
        clss.attributes().forEach(attribute -> outerWriter.writeln("public " + attribute.type().type() + " " + attribute.name() + SEMI_COLON));
    }

    private String attributeString(final List<Attribute> attributes) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < attributes.size(); i++) {
            Attribute att = attributes.get(i);
            result.append(att.type().type()).append(" ").append(att.name());
            if (i < attributes.size() - 1) {
                result.append(", ");
            }
        }
        return result.toString();
    }

}
