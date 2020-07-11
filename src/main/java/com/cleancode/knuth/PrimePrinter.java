package com.cleancode.knuth;

public class PrimePrinter {

    final int totalNumberOfPrimesToBePrinted = 1000;
    int primes[] = new int[this.totalNumberOfPrimesToBePrinted +1];

    public static void main(String[] args) {

        PrimePrinter primePrinter = new PrimePrinter();
        primePrinter.calculatePrimes();
        primePrinter.printPrimes();

    }

    private void calculatePrimes() {

        final int ORDMAX = 30;
        int multiplesOfOddNumbers[] = new int[ORDMAX+1];

        primes[1] = 2;

        int currentPrimeCount = 1;
        int currentNumberToCheck = 1;
        int currentSquare = 9;
        int lastPerfectOddNumberSquareIndex = 2;

        while (currentPrimeCount < this.totalNumberOfPrimesToBePrinted) {
            boolean isCurrentNumberPrime;

            do {
                currentNumberToCheck += 2;
                if( currentNumberToCheck == currentSquare) {
                    lastPerfectOddNumberSquareIndex++;
                    currentSquare=primes[lastPerfectOddNumberSquareIndex]*primes[lastPerfectOddNumberSquareIndex];
                    multiplesOfOddNumbers[lastPerfectOddNumberSquareIndex-1]=currentNumberToCheck;
                }
                int currentIndex = 2;
                isCurrentNumberPrime=true;
                while (currentIndex < lastPerfectOddNumberSquareIndex && isCurrentNumberPrime) {
                    while (multiplesOfOddNumbers[currentIndex]<currentNumberToCheck)
                        multiplesOfOddNumbers[currentIndex] += primes[currentIndex] + primes[currentIndex];
                    if (multiplesOfOddNumbers[currentIndex] == currentNumberToCheck)
                        isCurrentNumberPrime=false;
                    currentIndex++;
                }
            } while (!isCurrentNumberPrime);
            currentPrimeCount++;
            primes[currentPrimeCount]=currentNumberToCheck;
        }
    }

    private void printPrimes() {
        int currentPageNumber = 1;
        int currentPageOffset = 1;
        int currentRowOffset;

        final int totalRowsPerPage = 50;
        final int totalColumnsPerPage = 4;

        int C;
        while (currentPageOffset <= this.totalNumberOfPrimesToBePrinted) {
            System.out.println(String.format("The First %d Prime Numbers === Page %d\n", this.totalNumberOfPrimesToBePrinted, currentPageNumber));
            
            for (currentRowOffset=currentPageOffset; currentRowOffset <= currentPageOffset+totalRowsPerPage-1; currentRowOffset++) {
                for (C = 0; C <= totalColumnsPerPage - 1; C++)
                    if (currentRowOffset + C * totalRowsPerPage <= this.totalNumberOfPrimesToBePrinted)
                        System.out.printf("%10d", primes[currentRowOffset + C * totalRowsPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            currentPageNumber++;
            currentPageOffset += totalRowsPerPage*totalColumnsPerPage;

        }
    }
}
