package sudoku;


/**
 * Created by che on 2014/05/07.
 */
public class InitialValidator {
    private final GridPaneAccessor accessor;
    public InitialValidator(GridPaneAccessor accessor){
        this.accessor = accessor;
    }

    public boolean validate() {
        return true;
    }
}
