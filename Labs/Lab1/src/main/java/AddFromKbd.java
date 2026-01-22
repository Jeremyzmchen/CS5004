import java.util.Scanner;

/**
 * Sum of two integers input from keyboard
 */

public class AddFromKbd {

  /**
   * Read two integers from keyboard and print sum
   *
   * @param args
   */
  public static void main(String[] args) {
    // Initialize a scanner object to read the user input
    Scanner in = new Scanner(System.in);

    System.out.print("Enter the first integer: ");
    int i = in.nextInt();

    System.out.print("Enter the second integer: ");
    int j = in.nextInt();

    int sum = i + j;
    System.out.println("The sum is: " + sum);

    in.close();
  }
}