//Author: Caleb Mugisha
package sudoku.BLogic;

import sudoku.Storage.LocalStorageImp;
import sudoku.SudokuLogic.GameLogic;
import sudoku.UI.UIContract;
import sudoku.controlLogic.ControlLogic;

import sudoku.problemdomain.IStorage;
import sudoku.problemdomain.SudokuGame;

import java.io.IOException;

public class GameBuildLogic {

    public static void build(UIContract.View userInterface) throws IOException {
        SudokuGame initialState;
        IStorage storage = new LocalStorageImp();

        try {
            //will throw if no game data is found in local storage

            initialState = storage.getGameData();
        } catch (IOException e) {

            initialState = GameLogic.getNewGame();
            //this method below will also throw an IOException
            //if we cannot update the game data. At this point
            //the application is considered unrecoverable
            storage.updateGameData(initialState);
        }

        UIContract.EventListener uiLogic = new ControlLogic(storage, userInterface);
        userInterface.setListener(uiLogic);
        userInterface.updateBoard(initialState);
    }
}
