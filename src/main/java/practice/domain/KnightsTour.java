package practice.domain;

import java.awt.*;

public class KnightsTour {

    private boolean[][] grid;
    private int count, spaces;

    private static final Point[] MOVES = new Point[]{
            new Point(-2, -1),
            new Point(-2, 1),
            new Point(2, -1),
            new Point(2, 1),
            new Point(-1, -2),
            new Point(-1, 2),
            new Point(1, -2),
            new Point(1, 2)
    };

    public KnightsTour(int rows, int cols) {
        grid = new boolean[rows][cols];
        spaces = rows * cols;
        count = 0;
    }

    public boolean tourFrom(int row, int col) {
        grid[row][col] = true;
        count++;

        if (count == spaces)
            return true;

        for (Point p : MOVES) {
            int nextRow = row + p.x;
            int nextCol = col + p.y;

            if (nextRow < 0 || nextRow >= grid.length)
                continue;
            else if (nextCol < 0 || nextCol >= grid.length)
                continue;
            else if (grid[nextRow][nextCol])
                continue;

            if (tourFrom(row + p.x, col + p.y))
                return true;
        }

        printGrid();
        grid[row][col] = false;
        count--;
        return false;
    }

    public void printGrid() {
        System.out.println("Count: " + count);
        for (boolean[] rows : grid) {
            for (boolean b : rows) {
                System.out.println((b) ? "T" : "F");
            }
            System.out.println();
        }
        System.out.println("\n");
    }
}
