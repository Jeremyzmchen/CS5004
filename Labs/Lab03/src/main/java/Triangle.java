/**
 * This class represents a triangle.
 * It extends AbstractShape class which has a reference point and a compareTo method.
 * It offers area, perimeter, resize methods implemented from Shape interface.
 *
 * @author github.com/Jeremyzmchen
 */
public class Triangle extends AbstractShape {

  /**
   * the second vertex of triangle
   */
  private Point2D v2;

  /**
   * the third vertex of triangle
   */
  private Point2D v3;

  /**
   * construct triangle through 6 coordinates
   * @param x1 x of first vertex
   * @param y1 y of first vertex
   * @param x2 x of second vertex
   * @param y2 y of second vertex
   * @param x3 x of third vertex
   * @param y3 y of third vertex
   */
  public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
    this(new Point2D(x1, y1), new Point2D(x2, y2), new Point2D(x3, y3));
  }

  /**
   * construct triangle through 3 Point2D objects
   * @param v1 first vertex
   * @param v2 second vertex
   * @param v3 third vertex
   */
  public Triangle(Point2D v1, Point2D v2, Point2D v3) {
    super(v1);
    validateVertices(v1, v2, v3);
    this.v2 = v2;
    this.v3 = v3;
  }

  /**
   * validate vertices(isNotBlank, isUnique)
   * @param v1 the first vertex
   * @param v2 the second vertex
   * @param v3 the third vertex
   */
  private void validateVertices(Point2D v1, Point2D v2, Point2D v3) {
    if (v1 == null || v2 == null || v3 == null) {
      throw new IllegalArgumentException("Vertex cannot be blank");
    }

    if (isEqual(v1, v2) || v1.equals(v3) || v2.equals(v3)) {
      throw new IllegalArgumentException("Vertex must be unique");
    }
  }

  /**
   * validate double variables are equal
   * @param p the first variable
   * @param q the second variable
   * @return boolean value true if they are difference within EP
   */
  private static boolean isEqual(Point2D p, Point2D q) {
    double EP = 0.001;
    return Math.abs(p.getX() - q.getX()) < EP &&
        Math.abs(p.getY() - q.getY()) < EP;
  }

  /**
   * calculate the perimeter of triangle
   *
   * @return the perimeter of triangle
   */
  @Override
  public double perimeter() {
    double a = getDist(reference, v2);
    double b = getDist(v2, v3);
    double c = getDist(v3, reference);
    return a + b + c;
  }

  /**
   * calculate the area of the triangle
   *
   * @return the area of the triangle
   */
  @Override
  public double area() {
    double a = getDist(reference, v2);
    double b = getDist(v2, v3);
    double c = getDist(v3, reference);
    double s = (a + b + c) / 2.0;
    return Math.sqrt(Math.max(0, s * (s - a) * (s - b) * (s - c)));
  }

  /**
   * Scale the triangle
   *
   * @param factor factor of resizing
   * @return the new triangle object
   */
  @Override
  public Shape resize(double factor) {
    double scale = Math.sqrt(factor);

    double newX2 = reference.getX() + scale * (v2.getX() - reference.getX());
    double newY2 = reference.getY() + scale * (v2.getY() - reference.getY());
    double newX3 = reference.getX() + scale * (v3.getX() - reference.getX());
    double newY3 = reference.getY() + scale * (v3.getY() - reference.getY());

    return new Triangle(reference.getX(), reference.getY(),
        newX2, newY2, newX3, newY3);
  }

  /**
   * Returns a string representation of this triangle.
   *
   * @return three vertex coordinates
   */
  @Override
  public String toString() {
    return String.format("Triangle: vertex_1:(%.3f, %.3f)"
        + "vertex_2:(%.3f, %.3f) vertex_3:(%.3f, %.3f)",
        reference.getX(), reference.getY(),
        v2.getX(), v2.getY(), v3.getX(), v3.getY());
  }

  /**
   * calculate the side length
   *
   * @return each side length
   */
  private double getDist(Point2D a, Point2D b) {
    double x = a.getX() - b.getX();
    double y = a.getY() - b.getY();
    return Math.sqrt(x * x + y * y);
  }
}