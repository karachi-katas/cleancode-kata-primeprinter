package com.cleancode.knuth;



public class PrimePrinter {
    static final int PRIME_NUMBERS_PER_PAGE = 1000;
    static final int TOTAL_PRIME_NUMBERS = 1000;
    static final int OUTPUT_ROWS = 50;
    static final int OUTPUT_COLUMNS = 4;
    static final int ORDMAX = 30;

    public static void main(String[] args) {

        int P[] = new int[TOTAL_PRIME_NUMBERS +1];
        P[1] = 2;

        int J = 1;
        int K = 1;
        boolean JPRIME;
        int ORD = 2;
        int SQUARE = 9;
        int N=0;
        int MULT[] = new int[ORDMAX+1];


        while (K < TOTAL_PRIME_NUMBERS) {
            do {
                J += 2;
                if( J == SQUARE) {
                    ORD++;
                    SQUARE=P[ORD]*P[ORD];
                    MULT[ORD-1]=J;
                }
                N=2;
                JPRIME=true;
                while (N < ORD && JPRIME) {
                    while (MULT[N]<J)
                        MULT[N] += P[N] + P[N];
                    if (MULT[N] == J)
                        JPRIME=false;
                    N++;
                }
            } while (!JPRIME);
            K++;
            P[K]=J;
        }
        print(P);
    }

    private static void print(int[] p) {
        int ROWOFFSET;

        int PAGENUMBER = 1;
        int PAGEOFFSET = 1;
        while (PAGEOFFSET <= PRIME_NUMBERS_PER_PAGE) {
            System.out.print("The First ");
            System.out.print(PRIME_NUMBERS_PER_PAGE);
            System.out.print(" Prime Numbers === Page ");
            System.out.print(PAGENUMBER);
            System.out.println("\n");
            for (ROWOFFSET=PAGEOFFSET; ROWOFFSET <= PAGEOFFSET+ OUTPUT_ROWS -1; ROWOFFSET++) {
                for (int C = 0; C <= OUTPUT_COLUMNS - 1; C++)
                    if (ROWOFFSET + C * OUTPUT_ROWS <= PRIME_NUMBERS_PER_PAGE)
                        System.out.printf("%10d", p[ROWOFFSET + C * OUTPUT_ROWS]);
                System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += OUTPUT_ROWS * OUTPUT_COLUMNS;

        }
    }
}
