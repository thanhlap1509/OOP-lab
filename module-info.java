module OOPLab {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    opens AimsProject.src.hust.soict.globalict.aims.screen.customer.view to javafx.fxml;
    opens AimsProject.src.hust.soict.globalict.aims.Media to javafx.base;
    opens GUIProject.hust.soict.globalict.javafx to javafx.fxml;
    exports GUIProject.hust.soict.globalict.javafx to javafx.graphics;
    opens AimsProject.src.hust.soict.globalict.test.screen.customer.store to javafx.fxml;
    exports AimsProject.src.hust.soict.globalict.test.screen.customer.store to javafx.graphics;
    opens AimsProject.src.hust.soict.globalict.aims.screen.customer.controller to javafx.fxml;
}