package com.cleancode.knuth;


import java.util.ArrayList;
import java.util.List;

public class PrimePrinter {
    static final int TOTAL_PRIME_NUMBERS = 1000;
    static final int OUTPUT_ROWS = 50;
    static final int OUTPUT_COLUMNS = 4;

    static List<Integer> squares = new ArrayList<>();
    static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {

        addPrimeNumber(2);

        int candidatePrimeNumber = 1;
        int square = 9;

        while (primes.size() - 1 < TOTAL_PRIME_NUMBERS) {
            boolean isCandidateAPrime;
            do {
                candidatePrimeNumber += 2;
                if(candidatePrimeNumber == square) {
                    square = getNextSquare(candidatePrimeNumber);
                }

                isCandidateAPrime=true;
                int squareCounter = 2;
                while (squareCounter < getNumberOfSquares() && isCandidateAPrime) {
                    boolean isCandidateAPrime1 = isCandidateAPrime;
                    while (getSquare(squareCounter) < candidatePrimeNumber) {
                        squares.set(squareCounter - 2, squares.get(squareCounter - 2) + getPrimeNumber(squareCounter) * 2);
                    }
                    if (getSquare(squareCounter) == candidatePrimeNumber)
                        isCandidateAPrime1 =false;
                    isCandidateAPrime = isCandidateAPrime1;
                    squareCounter++;
                }
            } while (!isCandidateAPrime);
            addPrimeNumber(candidatePrimeNumber);
        }
        print(primes);
    }

    private static int getSquare(int squareCounter) {
        return squares.get(squareCounter - 2);
    }

    private static int getNextSquare(int candidatePrimeNumber) {
        squares.add(candidatePrimeNumber);

        return getPrimeNumber(getNumberOfSquares()) * getPrimeNumber(getNumberOfSquares());
    }

    private static int getPrimeNumber(int position) {
        return primes.get(position - 1);
    }

    private static void addPrimeNumber(int prime) {
        primes.add(prime);
    }

    private static int getNumberOfSquares() {
        return squares.size() + 2;
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
