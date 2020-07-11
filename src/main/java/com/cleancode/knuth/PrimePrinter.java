package com.cleancode.knuth;

import java.util.ArrayList;
import java.util.List;

public class PrimePrinter {

    final int totalNumberOfPrimesToBePrinted = 1000;
    List<Integer> primes = new ArrayList<Integer>(){
        {
            add(0);
        }
    };
    int lastPerfectOddNumberSquareIndex = 2;

    public static void main(String[] args) {

        PrimePrinter primePrinter = new PrimePrinter();
        primePrinter.calculatePrimes();
        primePrinter.printPrimes();

    }

    private void calculatePrimes() {

        final int maximumOddPerfectSquare = 30;
        int multiplesOfOddNumbers[] = new int[maximumOddPerfectSquare + 1];
//        primes.add(0);
        primes.add(2);

        int currentNumberToCheck = 1;
        int currentSquare = 9;

        while (primes.size() <= this.totalNumberOfPrimesToBePrinted) {
            boolean isCurrentNumberPrime;

            do {
                currentNumberToCheck += 2;
                if (currentNumberToCheck == currentSquare) {
                    lastPerfectOddNumberSquareIndex++;
                    currentSquare = getNextOddNumberSquare();
                    multiplesOfOddNumbers[lastPerfectOddNumberSquareIndex - 1] = currentNumberToCheck;
                }
                int currentIndex = 2;
                isCurrentNumberPrime = true;
                while (currentIndex < lastPerfectOddNumberSquareIndex && isCurrentNumberPrime) {
                    while (multiplesOfOddNumbers[currentIndex] < currentNumberToCheck)
                        multiplesOfOddNumbers[currentIndex] += primes.get(currentIndex) + primes.get(currentIndex);
                    if (multiplesOfOddNumbers[currentIndex] == currentNumberToCheck)
                        isCurrentNumberPrime = false;
                    currentIndex++;
                }
            } while (!isCurrentNumberPrime);
            primes.add(currentNumberToCheck);
        }
    }

    private int getNextOddNumberSquare() {
        return primes.get(lastPerfectOddNumberSquareIndex) * primes.get(lastPerfectOddNumberSquareIndex);
    }

    private void printPrimes() {

        final int totalRowsPerPage = 50;
        final int totalColumnsPerPage = 4;
        int currentPage = 1;

        for (int currentPageOffset = 1; currentPageOffset <= this.totalNumberOfPrimesToBePrinted; currentPageOffset += totalRowsPerPage * totalColumnsPerPage) {
            System.out.println(String.format("The First %d Prime Numbers === Page %d\n", this.totalNumberOfPrimesToBePrinted, currentPage));

            for (int currentRow = currentPageOffset; currentRow <= currentPageOffset + totalRowsPerPage - 1; currentRow++) {
                for (int currentColumn = 0; currentColumn <= totalColumnsPerPage - 1; currentColumn++)
                    if (currentRow + currentColumn * totalRowsPerPage <= this.totalNumberOfPrimesToBePrinted)
                        System.out.printf("%10d", primes.get(currentRow + currentColumn * totalRowsPerPage));
                System.out.println();
            }
            System.out.println("\f");
            currentPage++;
        }
    }
}
