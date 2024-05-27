package GUIProject.hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PaintController {

    @FXML
    private Pane drawingAreaPane;
    @FXML
    private ToggleGroup identical;
    @FXML
    void clearButtonPressed(ActionEvent event) {
    drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {
        String radioButtonText = ((RadioButton) identical.getSelectedToggle()).getText();
        Color paintColor = null;
        if (radioButtonText.equals("Pen")){
            paintColor = Color.BLACK;
        } else paintColor = Color.WHITE;
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, paintColor);
        if (drawingAreaPane.getBoundsInParent().contains(event.getX(), event.getY())){
            drawingAreaPane.getChildren().add(newCircle);
        }

    }

}
