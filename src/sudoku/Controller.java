package sudoku;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;


public class Controller implements EventHandler<KeyEvent> {
    @FXML
    private MappedGridPane gridPane;

    public MappedGridPane getGridPane() {
        return this.gridPane;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)){

            System.out.println("Start");
            solve();
        }
    }
    private void solve(){
        InitialValidator validator = new InitialValidator(gridPane);
        boolean result = validator.validate();
        if(!result){
            System.out.println("Illegal Argument");
            return;
        }
        Solver solver = new Solver(gridPane);
        solver.solve();
        System.out.println("Finished");
    }
}
