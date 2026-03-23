import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


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

    @Test
    void InitTest()
    {
        Triangle trg = new Triangle(10,10,10);
        trg.GetTriangleType();
    }

    @Test
    void TypeTest()
    {

    }
}