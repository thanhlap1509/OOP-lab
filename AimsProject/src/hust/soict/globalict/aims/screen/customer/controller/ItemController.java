package AimsProject.src.hust.soict.globalict.aims.screen.customer.controller;
import AimsProject.src.hust.soict.globalict.aims.Media.Media;
import AimsProject.src.hust.soict.globalict.aims.Playable.Playable;
import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

public class ItemController {
    private Media media;
    public void setData(Media media){
        this.media = media;
        lblTitle.setText(media.getTitle());
        lblCost.setText(media.getCost() + " $ ");
        if (media instanceof Playable){
            btnPlay.setVisible(true);
        }else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart, new Insets(0, 0, 0, 60));
        }
    }
    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblCost;

    @FXML
    private Label lblTitle;

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        ViewStoreController.addToCart(media);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) {
        Dialog<String> dialog = new Dialog<>();
        DialogPane dialogPane = new DialogPane();
        dialogPane.setContentText(((Playable) media).toString());
        dialogPane.setHeaderText("Playing Media");
        dialog.setDialogPane(dialogPane);
        ButtonType closeButton = new ButtonType("Confirm");
        dialog.getDialogPane().getButtonTypes().add(closeButton);

        Button closeButtonNode = (Button) dialog.getDialogPane().lookupButton(closeButton);
        closeButtonNode.setOnAction(e -> dialog.close());
        dialog.showAndWait();
    }

}
