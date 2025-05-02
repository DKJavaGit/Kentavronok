package com.example.kentavr;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
    @FXML
    private ChoiceBox<String> type_cb;
    @FXML
    private ChoiceBox<String> language_cb;
    @FXML
    private TextField size_tf;
    @FXML
    private TextField password_tf;
    @FXML
    private ImageView imageView;

    ObservableList<String> listOfTypes = FXCollections.observableArrayList(
            "Слово + цифры", "Цифры + слово", "Символы + цифры",
            "Только цифры", "Только символы", "Только слова", "Разнобой всего");

    ObservableList<String> listOfLanguages = FXCollections.observableArrayList(
            "English", "Русский", "简体中文");

    @FXML
    public void copyOnAction()
    {
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(new StringSelection(password_tf.getText()), null);
    }

    @FXML
    public void genOnAction()
    {
        try {
            PasswordGen password = new PasswordGen(type_cb.getValue(), Integer.parseInt(size_tf.getText()), language_cb.getValue());
            password_tf.setText(password.create());
        } catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Ошибка!");
            alert.setHeaderText("Что-то не так:(");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Заполнение ячеек
        type_cb.setItems(listOfTypes);
        type_cb.getSelectionModel().selectFirst();

        language_cb.setItems(listOfLanguages);
        language_cb.getSelectionModel().selectFirst();

        // Вставка фото
        Image image = new Image(getClass().getResource("1466-logo.png").toExternalForm());
        imageView.setImage(image);
    }
}
