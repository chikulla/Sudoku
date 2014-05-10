package sudoku;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

import java.awt.Point;

/**
 * Created by che on 2014/04/25.
 * TODO:remove TextField & Create custom component.
 */
public class NumberInputField extends AnchorPane {
    private final Point point;
    private final TextField textField;
    //constructor:TRUE, setNumber:FALSE
    private boolean initialValue = false;

    public NumberInputField(int x, int y) {
        this.point = new Point(x, y);
        this.textField = validatedTextField();
        registerTextField();
        setId(new StringBuilder().append(x).append(":").append(y).toString());
        initialValue = true;
    }

    public int getNumber() {
        if (textField.getText().equals("")||textField.getText().equals(" ")){
            return 0;
        }
        //TODO:fix it
        return Integer.valueOf(textField.getText());
    }

    public void setNumber(int i) {
        this.textField.setText(Integer.valueOf(i).toString());
    }

    public void clear(){
        this.textField.setText("");
    }

    private void registerTextField() {
        double d = 0.0;
        AnchorPane.setRightAnchor(textField, d);
        AnchorPane.setLeftAnchor(textField, d);
        AnchorPane.setTopAnchor(textField, d);
        AnchorPane.setBottomAnchor(textField, d);
        this.getChildren().add(textField);
    }

    /**
     * @see http://fxexperience.com/2012/02/restricting-input-on-a-textfield/
     *
     * @return
     */
    private TextField validatedTextField() {
        TextField obj = new TextField() {
            @Override
            public void replaceText(int start, int end, String text) {
                // If the replaced text would end up being invalid, then simply
                // ignore this call!
                if (text.matches("[1-9]|\\s")) {
                    super.setText(text);
                }
            }
        };
        return obj;
    }

    public void setEnvetHandler(EventHandler<KeyEvent> handler) {
        this.textField.addEventHandler(KeyEvent.KEY_PRESSED, handler);
    }

    public boolean isInitialValue(){
        return initialValue;
    }
}
