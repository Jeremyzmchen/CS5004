/**
 * Shoes possesses properties: kind, color, brand, size
 */
public class Shoe {

  private final Kind kind;
  private final Color color;
  private final Brand brand;
  private double size;

  /**
   * construct shoes object
   *
   * @param kind  the dress style for shoes
   * @param color the color of the shoes
   * @param brand the brand of the shoes
   * @param size  the size of the shoes
   */
  public Shoe(Kind kind, Color color, Brand brand, double size) {
    if (brand == Brand.NIKE && kind == Kind.DRESS) {
      throw new IllegalArgumentException("No DRESS style of NIKE shoes");
    }
    this.kind = kind;
    this.color = color;
    this.brand = brand;
    this.size = size;
  }

  /**
   * @return the kind of shoes
   */
  public Kind getKind() {
    return kind;
  }

  /**
   * @return the color of shoes
   */
  public Color getColor() {
    return color;
  }

  /**
   * @return the brands of shoes
   */
  public Brand getBrand() {
    return brand;
  }

  /**
   * @return the size of shoes
   */
  public double getSize() {
    return size;
  }

  /**
   * set size of shoes
   *
   * @param size the size of shoes
   */
  public void setSize(double size) {
    this.size = size;
  }

  /**
   * get description of shoes
   *
   * @return description of the shoes
   */
  @Override
  public String toString() {
    String color;
    switch (this.color) {
      case WHITE:
        color = "nice white";
      case BLACK:
        color = "nice black";
      default:
        color = "nice color";
    }

    return String.format("Shoes details are: the color is &s"
            + "for &s style, made by &s, the size is &s",
        color, this.kind, this.brand, this.size);
  }
}
