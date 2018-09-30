/* In Progress
 * Project Euler Problem 11: Largest Product In A Grid
 * Finds the greatest product of n adjacent numbers in the same direction
 * (up, down, left, right, or diagonally) in the grid.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem11 {
    public static void main(String[] args) throws FileNotFoundException {
        int gridSize = 20;
        int adjacencies = 4;
        String filename = "data/Problem11grid.txt";

        int[][] grid = new int[gridSize][gridSize];
        try {
            Scanner scanner = new Scanner(new File(filename));

            for(int i=0; i<gridSize; i++) {
                for(int j=0; j<gridSize; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw e;
        }

        System.out.println(largestProductGrid(grid, adjacencies));
    }

    public static int largestProductGrid(int[][] grid, int adjacencies) {
//        for(int i=0; i<grid.length; i++) {
//            for(int j=0; j<grid[0].length; j++) {
//                int k = 0, up = i, down = i, left = j, right = j;
//                while(k<adjacencies && up >= 0) {
//
//                }
//            }
//        }
        return largestProductHorizontal(grid, adjacencies);
    }

    public static int largestProductHorizontal(int[][] grid, int adjacencies) {
        int largestP = 0;

        for(int i=0; i<grid.length; i++) {
            int back = 0, front = 0, pad = 0;//, prod = grid[i][back];
            while(front < grid[i].length) {

                if(grid[i][front] == 0) {
                    pad = 0;
                    back = ++front;
//                    prod = grid[i][back];

                } else {
                    front++;
                    if(pad == adjacencies-1) {
                        printList(grid[i], back, front);
                        int newP = multList(Arrays.copyOfRange(grid[i], back, front));
                        if(newP > largestP) largestP = newP;
                        back++;
                    } else {
                        pad++;
//                        prod *= grid[i][front];
                    }
                }
            }
        }
        return largestP;
    }

//    public static int largestProductVertical(int[][] grid, int adjacencies) {
//        int largestP = 0;
//
//        for(int j=0; j<grid[0].length; j++) {
//            int back = 0, front = 0, pad = 0;
//
//            while(front < grid.length) {
//
//                if(grid[front][j] == 0) {
//                    pad = 0;
//                    back = ++front;
//
//                } else {
//                    front++;
//                    if(pad == adjacencies-1) {
//
//                    }
//                }
//            }
//        }
//    }

    public static int multList(int[] list) {
        int product = 1;
        for(int i : list) {
            product *= i;
        }
        return product;
    }

    public static void printList(int[] list, int back, int front) {
        for(int p=back; p<front; p++) {
            System.out.print(list[p] + ", ");
        }
        System.out.println();
    }
}
