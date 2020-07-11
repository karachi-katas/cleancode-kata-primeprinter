package com.cleancode.knuth;



public class PrimePrinter {
    static final int PRIME_NUMEBRS_PER_PAGE = 1000;
    static final int RR = 50;
    static final int CC = 4;
    static final int ORDMAX = 30;

    public static void main(String[] args) {

        int P[] = new int[PRIME_NUMEBRS_PER_PAGE +1];
        int J;
        int K;
        boolean JPRIME;
        int ORD;
        int SQUARE;
        int N=0;
        int MULT[] = new int[ORDMAX+1];

        J=1;
        K=1;
        P[1] = 2;
        ORD = 2;
        SQUARE = 9;

        while (K < PRIME_NUMEBRS_PER_PAGE) {
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
        while (PAGEOFFSET <= PRIME_NUMEBRS_PER_PAGE) {
            System.out.print("The First ");
            System.out.print(PRIME_NUMEBRS_PER_PAGE);
            System.out.print(" Prime Numbers === Page ");
            System.out.print(PAGENUMBER);
            System.out.println("\n");
            for (ROWOFFSET=PAGEOFFSET; ROWOFFSET <= PAGEOFFSET+RR-1; ROWOFFSET++) {
                for (int C = 0; C <= CC - 1; C++)
                    if (ROWOFFSET + C * RR <= PRIME_NUMEBRS_PER_PAGE)
                        System.out.printf("%10d", p[ROWOFFSET + C * RR]);
                System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += RR*CC;

        }
    }
}
