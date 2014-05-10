package sudoku;

import javafx.scene.layout.GridPane;

/**
 * Created by che on 2014/04/20.
 */
public class InputFieldInitializer {
    private final MappedGridPane gridPane;
    private static final double CONS = 0.0;
    private final Controller cntl;

    public InputFieldInitializer(MappedGridPane gridPane, Controller cntl){
        this.gridPane = gridPane;
        this.cntl = cntl;
    }
    public void init(){
        int columnCount = gridPane.getColumnConstraints().size();
        int rowCount = gridPane.getRowConstraints().size();
        for(int x=0;x<columnCount;x++){
            for(int y=0;y<rowCount;y++){
                NumberInputField node = new NumberInputField(x,y);
                node.setEnvetHandler(cntl);
                gridPane.add(node,x,y);
            }
        }
    }
}
