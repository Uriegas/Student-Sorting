package com.uriegas;

import static org.junit.Assert.assertEquals;
import java.io.*;
import java.util.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized; 

@RunWith(Parameterized.class)
public class StudentTest {
    List<Student> actual;
    List<Student> expected;

    public StudentTest(List<Student> actual, List<Student> expected) {
        this.actual = actual;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[][]> data() {
        return new ArrayList<Object[][]>(){
            { Arrays.asList( new Student("Guillermo", 87.0, 2), new Student("Juan", 90.0, 0), new Student("Raul", 80.0, 1) );
              Arrays.asList( new Student("Guillermo", 87.0, 2), new Student("Juan", 90.0, 0), new Student("Raul", 80.0, 1) );
            }
            };
    }
    @Test
    public void test() {
        System.out.println("actual: " + actual);
        System.out.println("expected: " + expected);
        Collections.sort(actual);
        assertEquals(expected, actual);
    }
}
