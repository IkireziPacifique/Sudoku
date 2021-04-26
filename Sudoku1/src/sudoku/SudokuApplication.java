package sudoku;

import  javafx.application.Application;
import javafx.stage.Stage;
import sudoku.BLogic.GameBuildLogic;
import sudoku.UI.UserInterface;

import java.io.IOException;
/**
This is a root container fo the the primary objects which must run
when the program starts
 */

public class SudokuApplication extends Application {
    private UserInterface uiImpl;

    @Override
    public void start(Stage primaryStage) throws IOException {
        //Get SudokuGame object for a new game
        uiImpl = new UserInterface(primaryStage);

        try {
            GameBuildLogic.build(uiImpl);
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

