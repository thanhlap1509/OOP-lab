package AimsProject.src.hust.soict.globalict.aims.screen.customer.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import AimsProject.src.hust.soict.globalict.aims.cart.Cart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;

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
    private TableColumn<?, ?> colMediaCategory;

    @FXML
    private TableColumn<?, ?> colMediaId;

    @FXML
    private TableColumn<?, ?> colMediaTitle;

    @FXML
    private TableColumn<?, ?> colMediaCost;

    @FXML
    private Label costLabel;

    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private TableView<?> tblMedia;

    @FXML
    void btnPlayPressed(ActionEvent event) {

    }

    @FXML
    void btnRemovePressed(ActionEvent event) {

    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {

    }

}
