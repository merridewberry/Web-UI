package Lesson04;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TriangleTests {
    Triangle triangle;
    private static Logger logger = (Logger) LoggerFactory.getLogger(TriangleTests.class);

    @BeforeEach
    public void start() {logger.info("Test started");}

    @AfterAll
    static void finish() {
        logger.info("Testing finished");
    }

    @Test
    @DisplayName("Triangle can be created")
    void initTest() {
        triangle = new Triangle(1, 1, 1);
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 1, 0.433", "2, 3, 4, 2.904", "3, 4, 5, 6.000"})
    @DisplayName("Can calculate area for valid triangles")
    void validTriangleTest(int a, int b, int c, double result) {
        triangle = new Triangle(a, b, c);
        double area = Triangle.getArea(triangle);
        Assertions.assertEquals(area, result);
    }

    @ParameterizedTest
    @CsvSource({"1, 1, 0", "1, 0, 1", "0, 1, 1"})
    @DisplayName("Can't calculate area, if one of the sides is equal to zero")
    void zeroSideTest(int a, int b, int c) {
        triangle = new Triangle(a, b, c);
        double area = Triangle.getArea(triangle);
        Assertions.assertEquals(area, 0.0);
    }

    @ParameterizedTest
    @CsvSource({"1, 1, -1", "1, -1, 1", "-1, 1, 1"})
    @DisplayName("Can't calculate area, if one of the sides is negative")
    void negativeSideTest(int a, int b, int c) {
        triangle = new Triangle(a, b, c);
        double area = Triangle.getArea(triangle);
        Assertions.assertEquals(area, 0.0);
    }

    @Test
    @DisplayName("Can't calculate area, if one of the sides is longer than the sum of two other sides")
    void notTriangleTest() {
        triangle = new Triangle(1, 2, 4);
        double area = Triangle.getArea(triangle);
        Assertions.assertEquals(area, 0.0);
    }

    @Test
    @DisplayName("Can't calculate area, if one of the sides is the same length as the sum of two other sides")
    void itsActuallyAStraightLineTest() {
        triangle = new Triangle(1, 2, 3);
        double area = Triangle.getArea(triangle);
        Assertions.assertEquals(area, 0.0);
    }

    @Disabled("Because of reasons")
    @ParameterizedTest
    @CsvSource({"1, 1, 1, 0.0", "1, -1, 1, 0.433", "1, 2, 3, 1.333"})
    @DisplayName("Some tests to show that logging is working")
    void destinedToFail(int a, int b, int c, double result) {
        triangle = new Triangle(a, b, c);
        double area = Triangle.getArea(triangle);
        Assertions.assertEquals(area, result);
    }

}
