package com.example;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class main_admin {

    public Scene getScene(Stage stage, Scene loginScene) {

        //===================HEADER PANE=========================
        Pane p = new Pane();

        Rectangle rec = new Rectangle(0, 0, 1100, 70);
        rec.setFill(new LinearGradient(0, 1, 1, 0, true, null,
            new javafx.scene.paint.Stop[]{
                new javafx.scene.paint.Stop(0, javafx.scene.paint.Color.web("#bb3f4aff")),
                new javafx.scene.paint.Stop(1, javafx.scene.paint.Color.web("#b6868dff"))
            }
        ));



        //===================PROFILE BUTTON==========================
        Button b1 = new Button("الملف الشخصي");
        b1.setLayoutX(750);
        b1.setLayoutY(20);
        b1.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: white;");
        b1.setScaleX(1.5);
        b1.setScaleY(1.5);





        //==================add doctor BUTTON===================
        Button b2 = new Button("اضافة الطبيب");
        b2.setLayoutX(500);
        b2.setLayoutY(20);
        b2.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: white;");
        b2.setScaleX(1.5);
        b2.setScaleY(1.5);



        //===================MANAGE APPOINTMENTS BUTTON==========================
        Button b3 = new Button("ادارة المواعيد");
        b3.setLayoutX(300);
        b3.setLayoutY(20);
        b3.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: white;");
        b3.setScaleX(1.5);
        b3.setScaleY(1.5);




        //===============LOGOUT BUTTON=================
        Button b4 = new Button("تسجيل خروج");
        b4.setLayoutX(150);
        b4.setLayoutY(20);
        b4.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: white;");
        b4.setScaleX(1.5);
        b4.setScaleY(1.5);

        p.getChildren().addAll(rec, b1,b2,b3, b4);

        //===================MAIN LAYOUT VBOX===============================
        VBox vbox = new VBox(3);
        vbox.getChildren().addAll(p);

        VBox content = new VBox(10);
        content.setAlignment(Pos.CENTER);
        content.setTranslateY(50);
        vbox.getChildren().add(content);
        
        Label welcomeLabel = new Label("Welcome to the admin Page!");
        welcomeLabel.setStyle("-fx-font-size: 30px; -fx-text-fill: #333;");
        content.getChildren().add(welcomeLabel);


        //===================PROFILE BUTTON ACTION=========================
        b1.setOnAction(e -> {
            content.getChildren().clear();
            Label title = new Label("ملف المسؤول");
            title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
            
            Label nameLabel = new Label("الاسم: المسؤول الرئيسي");
            nameLabel.setStyle("-fx-font-size: 18px;");
            Label idLabel = new Label("رقم الهوية: 987654321");
            idLabel.setStyle("-fx-font-size: 18px;");
            Label emailLabel = new Label("البريد الإلكتروني: admin@example.com");
            emailLabel.setStyle("-fx-font-size: 18px;");

            content.getChildren().addAll(title, nameLabel, idLabel, emailLabel);
        });


        //==================ADD DOCTOR BUTTON ACTION===================
        b2.setOnAction(e -> {
            content.getChildren().clear();
            Label addDoctorLabel = new Label("Add Doctor");
            addDoctorLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

            TextField nameField = new TextField();
            nameField.setPromptText("Doctor Name");
            nameField.setStyle("-fx-font-size: 18px;");

            ComboBox<String> specialtyBox = new ComboBox<>();
            specialtyBox.getItems().addAll("Dentist", "ophthalmologists", "dermatologists", "pediatricians", "Interns");
            specialtyBox.setPromptText("Select Specialty");
            specialtyBox.setStyle("-fx-font-size: 18px;");

            Button submitBtn = new Button("Submit");
            submitBtn.setStyle("-fx-font-size: 18px; -fx-padding: 10 20 10 20;");
            
            Label confirmationLabel = new Label();
            
            content.getChildren().addAll(addDoctorLabel, nameField, specialtyBox, submitBtn, confirmationLabel);

            submitBtn.setOnAction(ev -> {
                String name = nameField.getText();
                String specialty = specialtyBox.getValue();

                if (name == null || name.trim().isEmpty() || specialty == null) {
                    confirmationLabel.setText("Please enter all fields.");
                    confirmationLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: red;");
                    return;
                }

                String doctorName = "د. " + name;

                
                if ("Dentist".equals(specialty)) {
                    main_user.dentists.add(doctorName);
                } else if ("dermatologists".equals(specialty)) {
                    main_user.dermatologists.add(doctorName);
                } else if ("pediatricians".equals(specialty)) {
                    main_user.pediatricians.add(doctorName);
                } else if ("Interns".equals(specialty)) {
                    main_user.internists.add(doctorName);
                } else if ("ophthalmologists".equals(specialty)) {
                    main_user.ophthalmologists.add(doctorName);
                }

                confirmationLabel.setText("Doctor " + name + " with specialty " + specialty + " added successfully!");
                confirmationLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: green;");
                
                
                nameField.clear();
                specialtyBox.setValue(null);
            });
        });

        //===================MANAGE APPOINTMENTS BUTTON ACTION==========================
        b3.setOnAction(e -> {
            content.getChildren().clear();


            Label manageLabel = new Label("Manage Appointments");
            manageLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
            content.getChildren().add( manageLabel);


            for(String appointment : main_user.bookedAppointments) {
                Label appointmentLabel = new Label(appointment);
                appointmentLabel.setStyle("-fx-font-size: 18px;");
                content.getChildren().addAll(appointmentLabel);

            }


            Button clearBtn = new Button("Clear All Appointments");
            clearBtn.setStyle("-fx-font-size: 18px; -fx-padding: 10 20 10 20;");
            content.getChildren().add(clearBtn);

           // ================CLEAR BUTTON ACTION=========================
            clearBtn.setOnAction(ev -> {
                main_user.bookedAppointments.clear();
                content.getChildren().clear();
                content.getChildren().add(manageLabel);
            });
            
        });


        //===================LOGOUT BUTTON ACTION=========================
        b4.setOnAction(e -> {
            stage.setScene(loginScene);
        });

        //===================main PANE=========================
        StackPane pane = new StackPane(vbox);
        
        pane.setAlignment(Pos.CENTER);

        return new Scene(pane, 1100, 900);
    }
}
