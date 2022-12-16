module fff.rpghg {
    requires javafx.controls;
    requires javafx.fxml;


    opens fff.rpghg to javafx.fxml;
    exports fff.rpghg;
}