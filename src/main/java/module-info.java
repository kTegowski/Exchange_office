module com.view {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.jsoup;


    opens com.view to javafx.fxml;
    exports com.view;
}