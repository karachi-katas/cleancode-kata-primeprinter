package com.cleancode.knuth;


import java.util.ArrayList;
import java.util.List;

public class PrimePrinter {
    static final int TOTAL_PRIME_NUMBERS = 1000;
    static final int OUTPUT_ROWS = 50;
    static final int OUTPUT_COLUMNS = 4;

    static List<Integer> squareList = new ArrayList<>();

    public static void main(String[] args) {

        int primeNumbers[] = new int[TOTAL_PRIME_NUMBERS +1];
        primeNumbers[1] = 2;

        int candidatePrimeNumber = 1;
        int square = 9;


        int counter = 1;
        while (counter < TOTAL_PRIME_NUMBERS) {
            boolean isCandidateAPrime;
            do {
                candidatePrimeNumber += 2;
                if(candidatePrimeNumber == square) {
                    square = getNextSquare(primeNumbers, candidatePrimeNumber);
                }

                isCandidateAPrime=true;
                int squareCounter = 2;
                while (squareCounter < getNumberOfSquares() && isCandidateAPrime) {
                    boolean isCandidateAPrime1 = isCandidateAPrime;
                    while (getSquare(squareCounter) < candidatePrimeNumber) {
                        squareList.set(squareCounter - 2, squareList.get(squareCounter - 2) + primeNumbers[squareCounter] * 2);
                    }
                    if (getSquare(squareCounter) == candidatePrimeNumber)
                        isCandidateAPrime1 =false;
                    isCandidateAPrime = isCandidateAPrime1;
                    squareCounter++;
                }
            } while (!isCandidateAPrime);
            counter++;
            primeNumbers[counter]=candidatePrimeNumber;
        }
        print(primeNumbers);
    }

    private static int getSquare(int squareCounter) {
        return squareList.get(squareCounter - 2);
    }

    private static int getNextSquare(int[] primeNumbers, int candidatePrimeNumber) {
        squareList.add(candidatePrimeNumber);

        return primeNumbers[getNumberOfSquares()]*primeNumbers[getNumberOfSquares()];
    }

    private static int getNumberOfSquares() {
        return squareList.size() + 2;
    }

    private static void print(int[] primeNumbers) {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= TOTAL_PRIME_NUMBERS) {
            printHeader(pageNumber);
            printRows(primeNumbers, pageOffset);
            printLineBreak();
            pageNumber++;
            pageOffset += OUTPUT_ROWS * OUTPUT_COLUMNS;

        }
    }

    private static void printLineBreak() {
        System.out.println("\f");
    }

    private static void printRows(int[] primeNumbers, int pageOffset) {
        for (int row=pageOffset; row <= pageOffset+ OUTPUT_ROWS -1; row++) {
            printRow(primeNumbers, row);
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

    private static void printRow(int[] primeNumbers, int row) {
        for (int column = 0; column <= OUTPUT_COLUMNS - 1; column++)
            if (row + column * OUTPUT_ROWS <= TOTAL_PRIME_NUMBERS)
                System.out.printf("%10d", primeNumbers[row + column * OUTPUT_ROWS]);
    }
}
