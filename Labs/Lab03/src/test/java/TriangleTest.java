import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test triangle class
 */
public class TriangleTest {
  private Triangle triangle;
  private final double EP = 0.001;

  @BeforeEach
  public void setUp() {
    triangle = new Triangle(0, 0, 3, 0, 0, 4);
  }

  @Test
  public void testConstructorException() {
    Point2D t1 = new Point2D(1, 1);
    Point2D t2 = new Point2D(3, 0);

    assertThrows(IllegalArgumentException.class,
        () -> new Triangle(null, t1, t2));

    assertThrows(IllegalArgumentException.class,
        () -> new Triangle(1, 1, 1, 1, 2, 2));
  }

  @Test
  public void testPerimeter() {
    assertEquals(12.0, triangle.perimeter(), EP);
  }

  @Test
  public void testArea() {
    assertEquals(6.0, triangle.area(), EP);
    Triangle line = new Triangle(0, 0, 1, 1, 2, 2);
    assertEquals(0.0, line.area(), EP);
  }

  @Test
  public void testResize() {
    Shape scaled = triangle.resize(9.0);
    assertEquals(54.0, scaled.area(), EP);
    assertEquals(36.0, scaled.perimeter(), EP);
  }

  @Test
  public void testToString() {
    String str = "Triangle: vertex_1:(0.000, 0.000)"
        + "vertex_2:(3.000, 0.000) vertex_3:(0.000, 4.000)";
    assertEquals(str, triangle.toString());
  }
}
