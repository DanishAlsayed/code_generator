package test.java;

import main.java.*;
import main.java.Class;
import org.junit.Test;

import java.util.List;

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
        InputXMLParser parser = new InputXMLParser("C:\\Users\\Danish Ibrahim\\Desktop\\Msc Big Data Technology\\code_generator\\src\\test\\resources\\classes.xml"/*new File(requireNonNull(getClass().getClassLoader().getResource("classes.xml")).getFile()).getCanonicalPath()*/);
        List<Class> classes = parser.inputClasses();
        ClassWriter writer = new ClassWriter();
        classes.forEach(clss -> {
            List<String> result = writer.write(clss, true);
            checker.check(result.get(CLASS_NAME_INDX));
        });
    }
}
