package Lesson04;

import java.text.DecimalFormat;

public class Triangle {

    private int a;
    private int b;
    private int c;
    private double p;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static double getArea(Triangle tr) {
        tr.p = (tr.a + tr.b + tr.c) / 2.0;
        if (
                tr.a <= 0 || tr.b <= 0 || tr.c <= 0 ||
                        tr.a >= tr.p || tr.b >= tr.p || tr.c >= tr.p
        ) {
            return 0.0;
        }

        double area = Math.sqrt(tr.p * (tr.p - tr.a) * (tr.p - tr.b) * (tr.p - tr.c) * 1.0);
        return Math.floor(area * 1000) / 1000;

    }
}
