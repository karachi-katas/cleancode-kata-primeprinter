package com.cleancode.knuth;

import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator {

    static List<Integer> squares = new ArrayList<>();

    static List<Integer> getPrimesNumbers() {
        List<Integer> primes = new ArrayList<>();
        addPrimeNumber(primes, 2);

        int candidatePrimeNumber = 1;
        int square = 9;

        while (primes.size() - 1 < PrimePrinter.TOTAL_PRIME_NUMBERS) {
            do {
                candidatePrimeNumber += 2;
                if(candidatePrimeNumber == square) {
                    square = getNextSquare(primes, candidatePrimeNumber);
                }

            } while (!checkIfPrime(primes, candidatePrimeNumber));
            addPrimeNumber(primes, candidatePrimeNumber);
        }
        return primes;
    }

    private static boolean checkIfPrime(List<Integer> primes, int candidatePrimeNumber) {
        int squareCounter = 2;
        while (squareCounter < getNumberOfSquares()) {
            while (getSquare(squareCounter) < candidatePrimeNumber) {
                squares.set(squareCounter - 2, squares.get(squareCounter - 2) + getPrimeNumber(primes,
                        squareCounter) * 2);
            }
            if (getSquare(squareCounter) == candidatePrimeNumber)
                return false;
            squareCounter++;
        }
        return true;
    }

    private static int getSquare(int squareCounter) {
        return squares.get(squareCounter - 2);
    }

    private static int getNextSquare(List<Integer> primes, int candidatePrimeNumber) {
        squares.add(candidatePrimeNumber);

        return getPrimeNumber(primes, getNumberOfSquares()) * getPrimeNumber(primes, getNumberOfSquares());
    }

    private static int getPrimeNumber(List<Integer> primes, int position) {
        return primes.get(position - 1);
    }

    private static void addPrimeNumber(List<Integer> primes, int prime) {
        primes.add(prime);
    }

    private static int getNumberOfSquares() {
        return squares.size() + 2;
    }
}
