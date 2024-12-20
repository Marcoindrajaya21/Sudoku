package org.example;

import java.util.Random;

public class Puzzle {
    // All variables have package access
    // The numbers on the puzzle
    int[][] numbers = new int[org.example.SudokuConstants.GRID_SIZE][org.example.SudokuConstants.GRID_SIZE];
    // The clues - isGiven (no need to guess) or need to guess
    boolean[][] isGiven = new boolean[org.example.SudokuConstants.GRID_SIZE][org.example.SudokuConstants.GRID_SIZE];

    // Enum for difficulty levels
    public enum Difficulty {
        EASY(36),   // 36 cells given
        MEDIUM(30), // 30 cells given
        HARD(24);   // 24 cells given

        private final int cellsToGuess;

        Difficulty(int cellsToGuess) {
            this.cellsToGuess = cellsToGuess;
        }

        public int getCellsToGuess() {
            return cellsToGuess;
        }
    }

    // Constructor
    public Puzzle() {
        super();
    }

    // Generate a new puzzle given the difficulty level
    public void newPuzzle(int difficulty) {
        // I hardcode a puzzle here for illustration and testing.
        int[][] hardcodedNumbers =
                {{5, 3, 4, 6, 7, 8, 9, 1, 2},
                        {6, 7, 2, 1, 9, 5, 3, 4, 8},
                        {1, 9, 8, 3, 4, 2, 5, 6, 7},
                        {8, 5, 9, 7, 6, 1, 4, 2, 3},
                        {4, 2, 6, 8, 5, 3, 7, 9, 1},
                        {7, 1, 3, 9, 2, 4, 8, 5, 6},
                        {9, 6, 1, 5, 3, 7, 2, 8, 4},
                        {2, 8, 7, 4, 1, 9, 6, 3, 5},
                        {3, 4, 5, 2, 8, 6, 1, 7, 9}};

        // Copy from hardcodedNumbers into the array "numbers"
        for (int row = 0; row < org.example.SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < org.example.SudokuConstants.GRID_SIZE; ++col) {
                numbers[row][col] = hardcodedNumbers[row][col];
            }
        }

        // Initialize all cells as given
        for (int row = 0; row < org.example.SudokuConstants.GRID_SIZE; ++row) {
            for (int col = 0; col < org.example.SudokuConstants.GRID_SIZE; ++col) {
                isGiven[row][col] = true;
            }
        }

        // Get the number of cells to guess based on the difficulty level
        int cellsToGuess = difficulty;
        int cellsToRemove = org.example.SudokuConstants.GRID_SIZE * org.example.SudokuConstants.GRID_SIZE - cellsToGuess;

        // Randomly select cells to be set as not given based on cellsToRemove
        Random random = new Random();

        while (cellsToRemove > 0) {
            int row = random.nextInt(org.example.SudokuConstants.GRID_SIZE);
            int col = random.nextInt(org.example.SudokuConstants.GRID_SIZE);

            // Only remove if it is currently given
            if (isGiven[row][col]) {
                isGiven[row][col] = false;
                cellsToRemove--;
            }
        }
    }
}
