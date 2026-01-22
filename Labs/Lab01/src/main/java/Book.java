/**
 * Represents a book with a title, author, and number of pages.
 *
 * @author Zhaoming
 */
public class Book {

  private String title;
  private String author;
  private int pages;

  /**
   * Constructs a Book object.
   *
   * @param title  the title of the book
   * @param author the author of the book
   * @param pages  the number of pages in the book
   */
  public Book(String title, String author, int pages) {
    this.title = title;
    this.author = author;
    this.pages = pages;
  }

  /**
   * Returns the title of this book.
   *
   * @return the title
   */
  public String getTitle() {
    return this.title;
  }

  /**
   * Returns the author of this book.
   *
   * @return the author
   */
  public String getAuthor() {
    return this.author;
  }

  /**
   * Returns the number of pages in this book.
   *
   * @return the number of pages
   */
  public int getPages() {
    return this.pages;
  }
}