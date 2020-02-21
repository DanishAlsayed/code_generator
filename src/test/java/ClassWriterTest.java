package test.java;

import main.java.*;
import main.java.Class;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static main.java.ClassWriter.CLASS_CONTENT_INDX;
import static main.java.ClassWriter.CLASS_NAME_INDX;
import static org.junit.Assert.assertEquals;

public class ClassWriterTest {
    private final SyntaxChecker checker = new SyntaxChecker();

    @Test
    public void writeFromLine() {
        InputLineParser parser =
                new InputLineParser("Orders , ID:Int, customerName:String, price:Double, check: Boolean,price2:float,LONG:long,SHORT:short,BYTE:byte,ascii:Char");
        Class inputClass = parser.inputClass();
        ClassWriter writer = new ClassWriter();
        List<String> result = writer.write(inputClass, true);
        System.out.println(result.get(CLASS_CONTENT_INDX));
        List<String> syntaxErrors = checker.check(result.get(CLASS_NAME_INDX));
        if (syntaxErrors.size() > 0) {
            System.out.println(syntaxErrors);
        }
        assertEquals(syntaxErrors.size(), 0);
    }

    @Test
    public void writeFromXML() {
        InputXMLParser parser = new InputXMLParser(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "classes.xml");
        List<Class> classes = parser.inputClasses();
        ClassWriter writer = new ClassWriter();
        classes.forEach(clss -> {
            List<String> result = writer.write(clss, true);
            List<String> syntaxErrors = checker.check(result.get(CLASS_NAME_INDX));
            if (syntaxErrors.size() > 0) {
                System.out.println(syntaxErrors);
            }
            assertEquals(syntaxErrors.size(), 0);
        });
        classTest();
    }

    private void classTest() {
        //Feel free to add things to this function to test
        byte b = 1;
        short s = 1;
        float f = 2;
        Orders orders = new Orders(1, "Danish", 2.0, true, f, 5, s, b, 'c');
        assertEquals("Danish", orders.f("customerName"));
    }
}
