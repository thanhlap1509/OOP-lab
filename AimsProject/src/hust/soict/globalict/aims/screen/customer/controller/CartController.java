package AimsProject.src.hust.soict.globalict.aims.screen.customer.controller;

import AimsProject.src.hust.soict.globalict.aims.Media.Media;
import AimsProject.src.hust.soict.globalict.aims.Playable.Playable;
import AimsProject.src.hust.soict.globalict.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartController {
    private Store store;
    public CartController(Store store){
        this.store = store;
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
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private TextField tfFilter;

    @FXML
    void btnPlayPressed(ActionEvent event) {

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        ViewStoreController.removeFromCart(media);
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
        if (ViewStoreController.getCart().getItemsOrdered() != null){
            tblMedia.setItems(ViewStoreController.getCart().getItemsOrdered());
        }
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
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
