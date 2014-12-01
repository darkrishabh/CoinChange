/*
 * Copyright (c) 2014. This Project is the requirement of the course at NYIT-Old Westbury and should not be used in any commercial or personal use unless permitted by the author of the code. This code is the property of Rishabh Mehan and he holds the rights to re-distribute and re-use this code.
 */

import java.util.Scanner;

/**
 * Created by rishabh on 12/1/14.
 */
public class CoinChange {

    // Dynamic programming algorithm to solve change making problem.
    // As a result, the coinsUsed array is filled with the
    // minimum number of coins needed for change from 0 -> maxChange
    // and lastCoin contains one of the coins needed to make the change.
    public static int count( int S[], int m, int n ) {
        int i, j, x, y;

        // We need n+1 rows as the table is consturcted in bottom up manner using
        // the base case 0 value case (n = 0)
        int table[][] = new int[n+1][m];

        // Fill the enteries for 0 value case (n = 0)
        for (i = 0; i < m; i++)
            table[0][i] = 1;

        // Fill rest of the table enteries in bottom up manner
        for (i = 1; i < n + 1; i++) {
            for (j = 0; j < m; j++) {
                // Count of solutions including S[j]
                x = (i - S[j] >= 0) ? table[i - S[j]][j] : 0;

                // Count of solutions excluding S[j]
                y = (j >= 1) ? table[i][j - 1] : 0;

                // total count
                table[i][j] = x + y;
            }
        }
        return table[n][m - 1];
    }

    // Simple test program
    public static void main(String[] args) {
        // The coins and the total amount of change
        int numCoins = 5;
        int[] coins = {1, 5, 10, 21, 25};
        int change = 0;

            System.out.println("Supply a monetary amount on the command line");
            Scanner reader = new Scanner(System.in);
            change = reader.nextInt();

        System.out.println("Number of ways = " + count(coins,numCoins,change));

    }
}


