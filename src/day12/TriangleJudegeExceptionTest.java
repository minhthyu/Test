package day12;

public class TriangleJudegeExceptionTest {
    public static void main(String[] args) {
        try {
            float a = 1f, b = 1f, c = 1f;
            Triangle triangle = new Triangle(a, b, c);
            System.out.println("三角形周长为：" + triangle.circumference(a, b, c) + "  面积为：" + triangle.area(a, b, c));
        } catch (TriangleJudegeException e) {
//            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}

class TriangleJudegeException extends Exception {
    public TriangleJudegeException() {
        super();
    }

    public TriangleJudegeException(String message) {
        super(message);
    }
}

interface Shape {
    float area(float ... parms);
    float circumference(float ... parms);
}

class Triangle implements Shape {
    private float a;
    private float b;
    private float c;

    public Triangle(float a, float b, float c) throws TriangleJudegeException {
        if (a + b <= c || a + c <= b || b + c <= a)
            throw new TriangleJudegeException("构不成三角形");
        else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    @Override
    public float area(float... parms) {
        float s = circumference(parms) / 2;
        float are = s;
        for (float parm : parms) {
            are *= (s - parm);
        }
        return are;
    }

    @Override
    public float circumference(float... parms) {
        float cir = 0f;
        for (float parm : parms) {
            cir += parm;
        }
        return cir;
    }
}
