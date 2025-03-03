module com.tqd.jfxenglishapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.tqd.jfxenglishapp to javafx.fxml;
    exports com.tqd.jfxenglishapp;
    exports com.tqd.pojo;
    exports com.tqd.services;
}
