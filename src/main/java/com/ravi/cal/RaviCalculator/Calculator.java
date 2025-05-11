package com.ravi.cal.RaviCalculator;

public class Calculator {

    private long first;
    private long second;

    public Calculator(long first, long second) {
        this.first = first;
        this.second = second;
    }

    public long getFirst() {
        return first;
    }

    public long getSecond() {
        return second;
    }

    public long addFucn(long first, long second) {
        return first + second;
    }

    public long subFucn(long first, long second) {
        return second - first;
    }

    public long mulFucn(long first, long second) {
        return first * second;
    }

    public static void main(String[] args) {
        long first = 0;
        long second = 0;

        // Check if args are provided, if not, use default values
        if (args.length < 2) {
            System.out.println("Error: Please provide two numbers as arguments.");
            System.out.println("Using default values: first = 0, second = 0");
        } else {
            try {
                first = Long.parseLong(args[0]);
                second = Long.parseLong(args[1]);
            } catch (NumberFormatException e) {
                System.out.println("Error: Arguments must be valid numbers.");
                return;
            }
        }

        // Create Calculator instance and calculate results
        Calculator cal = new Calculator(first, second);
        String output = String.format("\n*** Your Results ***\n\nFirst: %d\nSecond: %d\n\nSum : %d\nDifference : %d\nProduct : %d\n\n",
                cal.first, cal.second, cal.addFucn(first, second), cal.subFucn(first, second), cal.mulFucn(first, second));

        System.out.println(output);
    }
}
