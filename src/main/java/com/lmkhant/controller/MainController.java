package com.lmkhant.controller;


import com.lmkhant.pdf.RentPDF;
import com.lmkhant.utils.LocalDateUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    /*@FXML
    public TextField print_date;*/
    @FXML
    public TextField excel_path;
    @FXML
    public Button export_pdf;

    public MainController() {
    }

    public Parent getParent() {
        Parent scene = null;

        try {
            scene = FXMLLoader.load(this.getClass().getResource("/xml/main.fxml"));
        } catch (IOException var3) {
            var3.printStackTrace();
        }

        return scene;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.excel_path.setOnMouseClicked((actionEvent) -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Excel Files", "*.xlsx"), new ExtensionFilter("All Files", "*.*"));
            Stage stage = new Stage();
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                this.excel_path.setText(selectedFile.getAbsolutePath());
            }

        });
        String workingDir = null;

        try {
            workingDir = (new File(MainController.class.getProtectionDomain().getCodeSource().getLocation().toURI())).getParentFile().getPath();
        } catch (URISyntaxException var5) {
            var5.printStackTrace();
        }
        System.getProperty("os.name");
        String DIR = String.format("%s/export/", workingDir);
        //this.excel_path.setText(DIR);
        StringBuilder errorCode = new StringBuilder();
        this.export_pdf.setOnMouseClicked((mouseEvent) -> {
            try {
                if (this.excel_path.getText().isBlank()) {
                    throw new FileNotFoundException("excel path is empty");
                }
                if (!new File(DIR).exists()) {
                    new File(DIR).mkdir();
                }
                LocalDateUtil gen = new LocalDateUtil();
                String rentRoom = String.format("%s/%s_rent_receipt.pdf", DIR, gen.dirByDate());
                String excelPath = this.excel_path.getText();

                RentPDF r = new RentPDF();
                r.createPdf(getPathOSIndependent(rentRoom), excelPath);
                //System.out.println(String.format("ExcelPath: %s", excelPath + "\n"));
            } catch (IOException | InvalidFormatException e) {
                errorCode.replace(0, errorCode.length(), e.toString());

            } finally {
                if (!errorCode.toString().isEmpty()) {
                    ButtonType close = new ButtonType("Close", ButtonData.OK_DONE);
                    Dialog<String> dialog = new Dialog<>();
                    dialog.getDialogPane().getButtonTypes().add(close);
                    dialog.setContentText(String.format("Error \n %s", errorCode));
                    dialog.show();
                } else {
                    ButtonType close = new ButtonType("Close", ButtonData.OK_DONE);
                    Dialog<String> dialog = new Dialog<>();
                    dialog.getDialogPane().getButtonTypes().add(close);
                    dialog.setContentText("Export Completed.");
                    dialog.show();

                }
            }
        });
    }

    public static String getPathOSIndependent(String path) {
        if (System.getProperty("os.name").toLowerCase().equals("windows"))
        return path.replaceAll("/", "\\\\");
        else return path.replaceAll("\\\\", "/");
    }
}

