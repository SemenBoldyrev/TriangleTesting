import java.util.List;

public class Triangle
{
    public static enum TriangleType
    {
        NotATriangle,
        Equilateral,
        Isosceles,
        Scalene
    }

    public int sideA;
    public int sideB;
    public int sideC;

    public Triangle(int a, int b, int c)
    {
        MainValueTest(a);
        MainValueTest(b);
        MainValueTest(c);

        //CalcValueTest(a,b,c);
        //CalcValueTest(c,a,b);
        //CalcValueTest(b,c,a);

        sideA = a;
        sideB = b;
        sideC = c;
    }

    public TriangleType GetTriangleType()
    {
        try
        {
            CalcValueTest(sideA,sideB,sideC);
            CalcValueTest(sideC,sideA,sideB);
            CalcValueTest(sideB,sideC,sideA);
        }
        catch (RuntimeException e)
        {
            return TriangleType.NotATriangle;
        }
        if (sideA == sideB && sideB == sideC)
        {
            return TriangleType.Equilateral;
        }
        else if (sideA == sideB || sideB == sideC || sideC == sideA)
        {
            return TriangleType.Isosceles;
        }
        return TriangleType.Scalene;
    }

    private void MainValueTest(int value)
    {
        List<Integer> borders = List.of(1, 200);
        if (value < borders.get(0) || value > borders.get(1))
        {
            throw new RuntimeException("Argument out of range, '"+String.valueOf(value)+"' must be greater than "+String.valueOf(borders.get(0))+" and lesser than "+String.valueOf(borders.get(1)));
        }
    }

    private void CalcValueTest(int a, int b, int c)
    {
        if (a >= (b + c))
        {
            throw  new RuntimeException("Error with arguments, " + String.valueOf(a) + " >= " + String.valueOf(b) + " + " + String.valueOf(c));
        }
    }
}
