package AimsProject.src.hust.soict.globalict.aims.screen.customer.controller;

import AimsProject.src.hust.soict.globalict.aims.Media.Media;
import AimsProject.src.hust.soict.globalict.aims.Playable.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController {
    private Cart cart;
    public CartController(Cart cart){
        this.cart = cart;
    }
    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    void btnPlayPressed(ActionEvent event) {

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {

    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {

    }
    @FXML
    public void initialize(){
        colMediaId.setCellValueFactory(new PropertyValueFactory<Media, Integer>("id"));
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media,String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        if (cart.getItemsOrdered() != null){
            tblMedia.setItems(cart.getItemsOrdered());
        }
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValud, Media newValue) {
                updateButtonBar(newValue);
            }
        });
    }
    void updateButtonBar(Media media){
        if (media == null){
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }else {
            btnRemove.setVisible(true);
            if (media instanceof Playable){
                btnPlay.setVisible(true);
            }else {
                btnPlay.setVisible(false);
            }
        }
    }
}
