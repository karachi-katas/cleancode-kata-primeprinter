package com.cleancode.knuth;

import java.util.ArrayList;
import java.util.List;

public class PrimeGenerator {

    List<Integer> squares = new ArrayList<>();
    List<Integer> primes = new ArrayList<>();

    PrimeGenerator(int numberOfPrimes) {
        primes = getPrimesNumbers(numberOfPrimes);
    }

    public List<Integer> getPrimes() {
        return primes;
    }

    private List<Integer> getPrimesNumbers(int numberOfPrimes) {
        addPrimeNumber(primes, 2);

        int candidatePrimeNumber = 1;
        int square = 9;

        while (primes.size() - 1 < numberOfPrimes) {
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

    private boolean checkIfPrime(List<Integer> primes, int candidatePrimeNumber) {
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

    private int getSquare(int squareCounter) {
        return squares.get(squareCounter - 2);
    }

    private int getNextSquare(List<Integer> primes, int candidatePrimeNumber) {
        squares.add(candidatePrimeNumber);

        return getPrimeNumber(primes, getNumberOfSquares()) * getPrimeNumber(primes, getNumberOfSquares());
    }

    private int getPrimeNumber(List<Integer> primes, int position) {
        return primes.get(position - 1);
    }

    private void addPrimeNumber(List<Integer> primes, int prime) {
        primes.add(prime);
    }

    private int getNumberOfSquares() {
        return squares.size() + 2;
    }
}
