/* Project Euler Problem 11: Largest Product In A Grid
 * Finds the greatest product of n adjacent numbers in the same direction
 * (up, down, left, right, or diagonally) in the grid.
 * Karen Lo © 2018
 */

import java.io.File;
import java.io.FileNotFoundException;
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
        int diagLR = largestProdDiagLR(grid, adjacencies);
        int diagRL = largestProdDiagRL(grid, adjacencies);
        int vertical = largestProdVertical(grid, adjacencies);
        int horizontal = largestProdHorizontal(grid, adjacencies);

        System.out.println("Diagonal LR: " + diagLR);
        System.out.println("Diagonal RL: " + diagRL);
        System.out.println("Vertical: " + vertical);
        System.out.println("Horizontal: " + horizontal);

        return Math.max(Math.max(diagLR, diagRL), Math.max(vertical, horizontal));
    }

    public static int largestProdHorizontal(int[][] grid, int adjacencies) {
        int largestP = 0;

        for(int i=0; i<grid.length; i++) {
            int back = 0, front = 0, pad = 0, prod = 1;

            while(front < grid[i].length) {
                if(grid[i][front] == 0) {
                    pad = 0;
                    back = ++front;
                    prod = 1;

                } else {
                    prod *= grid[i][front];
                    front++;
                    if(pad == adjacencies-1) {
                        if(prod > largestP) largestP = prod;
                        prod /= grid[i][back];
                        back++;
                    } else {
                        pad++;
                    }
                }
            }
        }
        return largestP;
    }

    public static int largestProdVertical(int[][] grid, int adjacencies) {
        int largestP = 0;

        for(int j=0; j<grid[0].length; j++) {
            int back = 0, front = 0, pad = 0, prod = 1;

            while(front < grid.length) {
                if(grid[front][j] == 0) {
                    pad = 0;
                    back = ++front;
                    prod = 1;

                } else {
                    prod *= grid[front][j];
                    front++;
                    if(pad == adjacencies-1) {
                        if(prod > largestP) largestP = prod;
                        prod /= grid[back][j];
                        back++;
                    } else {
                        pad++;
                    }
                }
            }
        }
        return largestP;
    }

    public static int largestProdDiagLR(int[][] grid, int adjacencies) {
        int largestP = 0;

        for(int i=0; i<=grid.length-adjacencies; i++) {
            int frontX = 0, frontY = i, backX = 0, backY = i, pad = 0, prod = 1;

            while(frontX < grid[0].length && frontY < grid.length) {
                if(grid[frontX][frontY] == 0) {
                    pad = 0;
                    backX = ++frontX;
                    backY = ++frontY;
                    prod = 1;

                } else {
                    prod *= grid[frontX][frontY];
                    frontX++;
                    frontY++;
                    if(pad == adjacencies-1) {
                        if(prod > largestP) largestP = prod;
                        prod /= grid[backX][backY];
                        backX++;
                        backY++;
                    } else{
                        pad++;
                    }
                }
            }
        }

        for(int j=1; j<=grid[0].length-adjacencies; j++) {
            int frontX = j, frontY = 0, backX = j, backY = 0, pad = 0, prod = 1;

            while(frontX < grid[0].length && frontY < grid.length) {
                if(grid[frontX][frontY] == 0) {
                    pad = 0;
                    backX = ++frontX;
                    backY = ++frontY;
                    prod = 1;

                } else {
                    prod *= grid[frontX][frontY];
                    frontX++;
                    frontY++;
                    if(pad == adjacencies-1) {
                        if(prod > largestP) largestP = prod;
                        prod /= grid[backX][backY];
                        backX++;
                        backY++;
                    } else{
                        pad++;
                    }
                }
            }
        }
        return largestP;
    }

    public static int largestProdDiagRL(int[][] grid, int adjacencies) {
        int largestP = 0;

        for(int i=0; i<grid.length; i++) {
            int frontX = grid[0].length-1, frontY = i, backX = grid[0].length-1, backY = i, pad = 0, prod = 1;

            while(frontX >= 0 && frontY < grid.length) {
                if(grid[frontX][frontY] == 0) {
                    pad = 0;
                    backX = --frontX;
                    backY = ++frontY;
                    prod = 1;

                } else {
                    prod *= grid[frontX][frontY];
                    frontX--;
                    frontY++;
                    if(pad == adjacencies-1) {
                        if(prod > largestP) largestP = prod;
                        prod /= grid[backX][backY];
                        backX--;
                        backY++;
                    } else {
                        pad++;
                    }
                }
            }
        }

        for(int j=grid[0].length-2; j>= adjacencies-1; j--) {
            int frontX = j, frontY = 0, backX = j, backY = 0, pad = 0, prod = 1;

            while(frontX >= 0 && frontY < grid.length) {
                if(grid[frontX][frontY] == 0) {
                    pad = 0;
                    backX = --frontX;
                    backY = ++frontY;
                    prod = 1;

                } else {
                    prod *= grid[frontX][frontY];
                    frontX--;
                    frontY++;
                    if(pad == adjacencies-1) {
                        if(prod > largestP) largestP = prod;
                        prod /= grid[backX][backY];
                        backX--;
                        backY++;
                    } else {
                        pad++;
                    }
                }
            }
        }
        return largestP;
    }
}
