//Author: Caleb Mugisha

package sudoku.UI;

import sudoku.problemdomain.SudokuGame;

public interface UIContract {

    interface EventListener {
        void onSudokuInput(int x, int y, int input);
        void onDialogClick();
    }
    interface View {
        void setListener(UIContract.EventListener listener);
        //update a single square after user input is less expensive than updating the whole game board after every cell update.
        void updateSquare(int x, int y, int input);

        //update the entire board, such as after game completion or initial execution of the program
        void updateBoard(SudokuGame game);
        void showDialog(String message);
        void showError(String message);
    }

}
