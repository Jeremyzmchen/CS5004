/*
Difference with python:
1. Assert datatype: java requires assert the datatype of a variable
2. Class: java requires asserting a class to instantiation and a main class as an entrance
 */

public class Power {
    public static void main(String[] args) {
        long ans = (long)Math.pow(2, 31);
        System.out.print(ans);
    }
}