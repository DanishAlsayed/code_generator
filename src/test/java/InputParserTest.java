package test.java;

import main.java.*;
import main.java.Class;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class InputParserTest {
    @Test
    public void correctLineInput() {
        InputLineParser parser =
                new InputLineParser("Orders , ID:Int, customerName:String, price:Double, check: Boolean,size:float,LONG:long,SHORT:short,BYTE:byte,ascii:Char");
        Class inputClass = parser.inputClass();
        assertEquals(inputClass.name(), "Orders");
        List<Attribute> attributes = inputClass.attributes();
        assertEquals(attributes.size(), 9);
        assertTrue(attributes.contains(new Attribute("ID", DataType.INT)));
        assertTrue(attributes.contains(new Attribute("customerName", DataType.STRING)));
        assertTrue(attributes.contains(new Attribute("price", DataType.DOUBLE)));
        assertTrue(attributes.contains(new Attribute("check", DataType.BOOLEAN)));
        assertTrue(attributes.contains(new Attribute("price2", DataType.FLOAT)));
        assertTrue(attributes.contains(new Attribute("LONG", DataType.LONG)));
        assertTrue(attributes.contains(new Attribute("SHORT", DataType.SHORT)));
        assertTrue(attributes.contains(new Attribute("BYTE", DataType.BYTE)));
        assertTrue(attributes.contains(new Attribute("ascii", DataType.CHAR)));
    }

    @Test
    public void wrongLineInput() {
        try {
            InputLineParser parser = new InputLineParser("Orders , ID:Intx");
        } catch (Exception e) {
            assertEquals(e.getMessage(), "No enum constant main.java.DataType.INTX");
        }
    }

    @Test
    public void correctXMLInput() {
        InputXMLParser parser = new InputXMLParser("C:\\Users\\Danish Ibrahim\\Desktop\\Msc Big Data Technology\\code_generator\\src\\test\\resources\\classes.xml"/*new File(requireNonNull(getClass().getClassLoader().getResource("classes.xml")).getFile()).getCanonicalPath()*/);
        List<Class> classes = parser.inputClasses();
        assertEquals(classes.size(), 2);
        assertEquals(classes.get(0).name(), "Orders");
        assertEquals(classes.get(0).attributes().size(), 9);
        classes.get(0).attributes().forEach(attribute -> {
            String name = attribute.name();
            assertNotEquals('2', name.charAt(name.length() - 1));
        });
        assertEquals(classes.get(1).name(), "Orders2");
        classes.get(1).attributes().forEach(attribute -> {
            String name = attribute.name();
            assertEquals('2', name.charAt(name.length() - 1));
        });
        assertEquals(classes.get(1).attributes().size(), 9);
    }
}
