import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class TriangleTest {

    private static int n = 0;

    @BeforeEach
    void setUp()
    {
        System.out.println("----Starting test " + String.valueOf(n));
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("----ending test " + String.valueOf(n));
        n++;
    }

    static Stream<Arguments> TypeTestData()
    {
        return Stream.of(
            Arguments.of(10,10,10,Triangle.TriangleType.Equilateral),
                Arguments.of(10,10,5, Triangle.TriangleType.Isosceles),
                Arguments.of(5,10,10, Triangle.TriangleType.Isosceles),
                Arguments.of(10,5,10, Triangle.TriangleType.Isosceles),
                Arguments.of(10,5,7, Triangle.TriangleType.Scalene),
                Arguments.of(10,5,3, Triangle.TriangleType.NotATriangle),
                Arguments.of(10,3,5, Triangle.TriangleType.NotATriangle),
                Arguments.of(3,5,10, Triangle.TriangleType.NotATriangle)
        );
    }

    static Stream<Arguments> BoundaryTestData()
    {
        return Stream.of(
                Arguments.of(200,200,200, true),
                Arguments.of(201,201,201, false),
                Arguments.of(300,300,300, false),

                Arguments.of(1,1,1, true),
                Arguments.of(0,0,0, false),
                Arguments.of(-10,-10,-10, false)
        );
    }


    @Test
    void InitTest()
    {
        Triangle trg = new Triangle(10,9,8);
        trg.GetTriangleType();

        assertEquals(10, trg.sideA);
        System.out.println("Triangle side 'A' tested!");

        assertEquals(9, trg.sideB);
        System.out.println("Triangle side 'B' tested!");

        assertEquals(8, trg.sideC);
        System.out.println("Triangle side 'C' tested!");
    }

    @ParameterizedTest
    @MethodSource("TypeTestData")
    void TypeTest(int a,int b, int c, Triangle.TriangleType expected)
    {
        Triangle trg = new Triangle(a,b,c);
        assertEquals(expected, trg.GetTriangleType());
        System.out.println("Triangle type '" + trg.GetTriangleType().toString() + "' \nwith values '" + String.valueOf(a) + ", " + String.valueOf(b) + ", " + String.valueOf(c) + "' tested!");
    }

    @ParameterizedTest
    @MethodSource("BoundaryTestData")
    void BoundaryTest(int a, int b, int c, boolean expected)
    {
        try
        {
            Triangle trg = new Triangle(a,b,c);
            assertTrue(expected);
            System.out.println("Triangle successfully created with parameters '" + String.valueOf(a) + ", " + String.valueOf(b) + ", " + String.valueOf(c) + "'!");
        } catch (Exception e) {
            assertFalse(expected);
            System.out.println("Triangle successfully failed with parameters '" + String.valueOf(a) + ", " + String.valueOf(b) + ", " + String.valueOf(c) + "'\nand exception '" + e.toString() + "'!");
        }
    }
}