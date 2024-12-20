/**
 * ES234317-Algorithm and Data Structures
 * Semester Ganjil, 2024/2025
 * Group Capstone Project
 * Group #6
 * 1 - 5026231019 - Nathaniel Lado Hadi Winata
 * 2 - 5026231031 - Marco Indrajaya
 */
package org.example;

import java.awt.Color;
import java.awt.Font;
import java.io.Serial;
import javax.swing.JTextField;
/**
 * The Cell class model the cells of the Sudoku puzzle, by customizing (subclass)
 * the javax.swing.JTextField to include row/column, puzzle number and status.
 */
public class Cell extends JTextField {
    @Serial
    private static final long serialVersionUID = 1L;  // to prevent serial warning

    // Define named constants for JTextField's colors and fonts
    //  to be chosen based on CellStatus
    public static final Color BG_GIVEN = new Color(30, 30, 30); // Dark Gray for given cells
    public static final Color FG_GIVEN = new Color(255, 255, 255); // White for readability
    public static final Color FG_NOT_GIVEN = new Color(200, 200, 200); // Light Gray for not given cells
    public static final Color BG_TO_GUESS = new Color(50, 50, 150); // Dark Blue for cells to guess
    public static final Color BG_CORRECT_GUESS = new Color(0, 150, 0); // Green for correct guesses
    public static final Color BG_WRONG_GUESS = new Color(255, 0, 0); // Red for wrong guesses
    public static final Font FONT_NUMBERS = new Font("Roboto", Font.BOLD, 24); // Modern Bold Font

    // Define properties (package-visible)
    /** The row and column number [0-8] of this cell */
    int row, col;
    /** The puzzle number [1-9] for this cell */
    int number;
    /** The status of this cell defined in enum CellStatus */
    org.example.CellStatus status;

    /** Constructor */
    public Cell(int row, int col) {
        super();   // JTextField
        this.row = row;
        this.col = col;
        // Inherited from JTextField: Beautify all the cells once for all
        super.setHorizontalAlignment(JTextField.CENTER);
        super.setFont(FONT_NUMBERS);
    }

    /** Reset this cell for a new game, given the puzzle number and isGiven */
    public void newGame(int number, boolean isGiven) {
        this.number = number;
        status = isGiven ? org.example.CellStatus.GIVEN : org.example.CellStatus.TO_GUESS;
        paint();    // paint itself
    }

    /** This Cell (JTextField) paints itself based on its status */
    public void paint() {
        if (status == org.example.CellStatus.GIVEN) {
            // Inherited from JTextField: Set display properties
            super.setText(number + "");
            super.setEditable(false);
            super.setBackground(BG_GIVEN);
            super.setForeground(FG_GIVEN);
        } else if (status == org.example.CellStatus.TO_GUESS) {
            // Inherited from JTextField: Set display properties
            super.setText("");
            super.setEditable(true);
            super.setBackground(BG_TO_GUESS);
            super.setForeground(FG_NOT_GIVEN);
        } else if (status == org.example.CellStatus.CORRECT_GUESS) {  // from TO_GUESS
            super.setBackground(BG_CORRECT_GUESS);
        } else if (status == org.example.CellStatus.WRONG_GUESS) {    // from TO_GUESS
            super.setBackground(BG_WRONG_GUESS);
        }
    }
}
