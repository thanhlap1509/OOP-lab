module OOPLab {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires java.desktop;
    opens GUIProject.hust.soict.globalict.javafx to javafx.fxml;
    exports GUIProject.hust.soict.globalict.javafx to javafx.graphics;
}