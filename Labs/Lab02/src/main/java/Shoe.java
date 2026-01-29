/**
 * Represents a shoe with a kind, color, brand, and size.
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
    if (kind == null || color == null || brand == null) {
      throw new IllegalArgumentException("Kind, color, brand cannot be blank");
    }
    if (size <= 0) {
      throw new IllegalArgumentException("Size must be positive");
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
   * get description of shoes
   *
   * @return description of the shoes
   */
  @Override
  public String toString() {
    String brandStr = switch(brand) {
      case NIKE -> "Nike";
      case ADIDAS -> "Adidas";
      case FILA -> "Fila";
      case DIOR -> "Dior";
    };

    String colorStr = switch (color) {
      case RED -> "Red";
      case BLACK -> "Black";
      case GREEN -> "Green";
      case BLUE -> "Blue";
      default -> "Neutral";
    };

    String kindStr = switch (kind) {
      case SPORT -> "Sport";
      case DRESS -> "Dress";
      case BOOT -> "Boot";
      case CASUAL -> "Casual";
    };

    return String.format("Shoes information: %s, %s, %s, %.1f",
        brandStr, colorStr, kindStr, size);
  }
}
