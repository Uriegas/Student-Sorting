package com.uriegas;

import static org.junit.Assert.assertEquals;
import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized; 
/**
 * Test read and write of the file
 */
@RunWith(Parameterized.class)
public class ReaderTest {
    String path;//The path to read
    List<Inscription> expected;

    public ReaderTest(String path, List<Inscription> expected) {
        this.path = path;
        this.expected = expected;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> getTestData() {
        return Arrays.asList(new Object[][] {
            { "/test.xlsx",
                Arrays.asList(new Inscription("Guillermo", "Prado", "Padilla", 1403187, "Análisis y Diseño de Sistemas", "ADS006", 96, 68.0),
                              new Inscription("MIRIAM", "Tena", "Pont", 1201095, "Análisis y Diseño de Sistemas", "ADS006", 80, 82.333),
                              new Inscription("URANIA", "Checa", "Nebot", 1403187, "Análisis y Diseño de Sistemas", "ADS006", 89, 78.333),
                              new Inscription("ELSA", "Ibáñez", "Alba", 1403187, "Análisis y Diseño de Sistemas", "ADS006", 84, 87.0))
            }
        });
    }
    @Test
    public void testRead() {
        List<Inscription> actual = new ArrayList<Inscription>();
        try {
            actual = Reader.read(new File(path));
            assertEquals(expected, actual);
        }catch(Exception e){
            System.out.println(e.getMessage());
            Assert.fail();
        }
        assertEquals(expected, actual);
    }
    // @Test
    // public void testWrite() {
    //     try{
    //         Reader.write(new File(path), expected);
    //     }catch(Exception e){
    //         System.out.println(e.getMessage());
    //         Assert.fail();
    //     }
    // }

}
