package com.cleancode.knuth;


import java.util.List;

public class PrimePrinter {
    static final int TOTAL_PRIME_NUMBERS = 1000;
    static final int OUTPUT_ROWS = 50;
    static final int OUTPUT_COLUMNS = 4;

    public static void main(String[] args) {

        List<Integer> primes = PrimeGenerator.getPrimesNumbers();
        print(primes);
    }

    private static void print(List<Integer> primes) {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= TOTAL_PRIME_NUMBERS) {
            printHeader(pageNumber);
            printRows(primes, pageOffset);
            printLineBreak();
            pageNumber++;
            pageOffset += OUTPUT_ROWS * OUTPUT_COLUMNS;

        }
    }

    private static void printLineBreak() {
        System.out.println("\f");
    }

    private static void printRows(List<Integer> primes, int pageOffset) {
        for (int row=pageOffset; row <= pageOffset+ OUTPUT_ROWS -1; row++) {
            printRow(primes, row);
            System.out.println();
        }
    }

    private static void printHeader(int pageNumber) {
        System.out.print("The First ");
        System.out.print(TOTAL_PRIME_NUMBERS);
        System.out.print(" Prime Numbers === Page ");
        System.out.print(pageNumber);
        System.out.println("\n");
    }

    private static void printRow(List<Integer> primes, int row) {
        for (int column = 0; column <= OUTPUT_COLUMNS - 1; column++)
            if (row + column * OUTPUT_ROWS <= TOTAL_PRIME_NUMBERS)
                System.out.printf("%10d", primes.get(row + column * OUTPUT_ROWS - 1));
    }
}
