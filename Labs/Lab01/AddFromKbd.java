import java.util.Scanner;

public class AddFromKbd {
    public static void main(String[] args) {
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