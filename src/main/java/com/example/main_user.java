package com.example;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Rectangle;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class main_user {

    //===================APPOINTMENT DATA =========================
    
    public static ArrayList<String> bookedAppointments = new ArrayList<>();
    public static ArrayList<String> dentists = new ArrayList<>();
    public static ArrayList<String> dermatologists = new ArrayList<>();
    public static ArrayList<String> ophthalmologists = new ArrayList<>();
    public static ArrayList<String> pediatricians = new ArrayList<>();
    public static ArrayList<String> internists = new ArrayList<>();

    public Scene getScene(Stage stage, Scene scene) {

        //===================HEADER PANE=========================
        Pane p = new Pane();

        Rectangle rec = new Rectangle(0, 0, 1100, 70);
        rec.setFill(new LinearGradient(0, 1, 1, 0, true, null,
            new javafx.scene.paint.Stop[]{
                new javafx.scene.paint.Stop(0, javafx.scene.paint.Color.web("#bb3f4aff")),
                new javafx.scene.paint.Stop(1, javafx.scene.paint.Color.web("#b6868dff"))
            }
        ));


        //================ Image ====================//
        Image logov = new Image(getClass().getResourceAsStream("logo.png"));
        ImageView logo = new ImageView(logov);
        logo.setFitWidth(140);
        logo.setFitHeight(75);
        logo.setLayoutX(900);
        logo.setLayoutY(0);
        

        //===================PROFILE BUTTON==========================
        Button b1 = new Button("الملف الشخصي");
        b1.setLayoutX(750);
        b1.setLayoutY(20);
        b1.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: white;");
        b1.setScaleX(1.5);
        b1.setScaleY(1.5);

        

        //===================BOOK APPOINTMENT BUTTON=========================
        Button b2 = new Button("حجز موعد");
        b2.setLayoutX(550);
        b2.setLayoutY(20);
        b2.setStyle("-fx-background-color: transparent; -fx-border-color: transparent; -fx-text-fill: white;");
        b2.setScaleX(1.5);
        b2.setScaleY(1.5);

        //===================MANAGE APPOINTMENTS BUTTON==========================
        Button b3 = new Button("ادارة المواعيد");
        b3.setLayoutX(350);
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

                b4.setOnAction(e -> {
            stage.setScene(scene);
        
        });

        p.getChildren().addAll(rec, b1, b2, b3, b4,logo);

        //===================MAIN LAYOUT VBOX===============================
        VBox vbox = new VBox(3);
        vbox.getChildren().addAll(p);

        VBox content = new VBox(10);
        content.setAlignment(Pos.CENTER);
        content.setTranslateY(50);
        vbox.getChildren().add(content);

        //===================CLINIC AND DOCTOR DATA=========================
        
        HashMap<String, ArrayList<String>> clinics = new HashMap<>();
        
        // ======================= عيادة الأسنان=====================
          
        dentists.add("د. أحمد");
        dentists.add("د. سارة");
        clinics.put("عيادة الأسنان", dentists);

        // ================عيادة الجلدية ===================
        
        dermatologists.add("د. يوسف");
        dermatologists.add("د. ليلى");
        clinics.put("عيادة الجلدية", dermatologists);

        // ================عيادة العيون= ==============
        
        ophthalmologists.add("د. خالد");
        ophthalmologists.add("د. فاطمة");
        clinics.put("عيادة العيون", ophthalmologists);

        // ============ =عيادة الأطفال= ==============
        
        pediatricians.add("د. عمر");
        pediatricians.add("د. مريم");
        clinics.put("عيادة الأطفال", pediatricians);

        // ==================عيادة الباطنية=================
        
        internists.add("د. علي");
        internists.add("د. هند");
        clinics.put("عيادة الباطنية", internists);

        //===================PROFILE BUTTON ACTION=========================
                b1.setOnAction(e -> {

            content.getChildren().clear();
            Label title = new Label("ملف المستخدم");
            title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
            
            Label nameLabel = new Label("الاسم: user ");
            nameLabel.setStyle("-fx-font-size: 18px;");
            Label idLabel = new Label("رقم الهوية: 987654321");
            idLabel.setStyle("-fx-font-size: 18px;");
            Label emailLabel = new Label("البريد الإلكتروني: user@example.com");
            emailLabel.setStyle("-fx-font-size: 18px;");

            content.getChildren().addAll(title, nameLabel, idLabel, emailLabel);
        });
        
        //===================APPOINTMENT BOOKING =========================
        
        b2.setOnAction(e -> {
            showClinics(content, clinics);
        });

        //===================MANAGE APPOINTMENTS =========================
        
        b3.setOnAction(e -> {
            content.getChildren().clear();
            Label title = new Label("المواعيد المحجوزة");
            title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
            
            ListView<String> appointmentsListView = new ListView<>();
            for(String appointment : bookedAppointments) {
                appointmentsListView.getItems().add(appointment);
            }
            appointmentsListView.setMaxWidth(400);
            appointmentsListView.setMaxHeight(300);

            content.getChildren().addAll(title, appointmentsListView);
        });




        //===================ROOT PANE=========================
        StackPane pane = new StackPane(vbox);
        pane.setAlignment(Pos.CENTER);

        return new Scene(pane, 1100, 900);
    }

    //===================METHOD TO SHOW CLINICS=========================
    
    private void showClinics(VBox content, HashMap<String, ArrayList<String>> clinics) {
        content.getChildren().clear();
        Label title = new Label("اختر العيادة");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        content.getChildren().add(title);

        for (String clinicName : clinics.keySet()) {
            Button clinicButton = new Button(clinicName);
            clinicButton.setStyle("-fx-background-color: #bb3f4a; -fx-text-fill: white; -fx-font-size: 16px; -fx-pref-width: 200px;");
            clinicButton.setOnAction(ev -> {
                showDoctors(content, clinicName, clinics.get(clinicName), clinics);
            });
            content.getChildren().add(clinicButton);
        }
    }

    //===================METHOD TO SHOW DOCTORS=========================
    
    private void showDoctors(VBox content, String clinicName, ArrayList<String> doctors, HashMap<String, ArrayList<String>> clinics) {
        content.getChildren().clear();
        Label doctorTitle = new Label("اختر الطبيب في " + clinicName);
        doctorTitle.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        content.getChildren().add(doctorTitle);

        for (String doctorName : doctors) {
            Button doctorButton = new Button(doctorName);
            doctorButton.setStyle("-fx-font-size: 18px; -fx-pref-width: 200px;");
            doctorButton.setOnAction(e -> {
                showDatePicker(content, clinicName, doctorName, clinics);
            });
            content.getChildren().add(doctorButton);
        }

        // ================ Back to clinics button ======================
        Button backButton = new Button("العودة للعيادات");
        backButton.setOnAction(e -> showClinics(content, clinics));
        content.getChildren().add(backButton);
    }

    //===================METHOD TO SHOW DATE PICKER=========================
  
    private void showDatePicker(VBox content, String clinicName, String doctorName, HashMap<String, ArrayList<String>> clinics) {
        content.getChildren().clear();
        Label title = new Label("اختر تاريخ الموعد مع " + doctorName);
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        DatePicker datePicker = new DatePicker();
        datePicker.setPromptText("اختر التاريخ");

        Button confirmButton = new Button("تأكيد الحجز");
        Label confirmationLabel = new Label();
        confirmationLabel.setStyle("-fx-text-fill: green; -fx-font-size: 16px;");

        confirmButton.setOnAction(e -> {
            LocalDate selectedDate = datePicker.getValue();
            if (selectedDate != null) {
                String appointmentDetails = "العيادة: " + clinicName + ", الطبيب: " + doctorName + ", التاريخ: " + selectedDate.toString();
                bookedAppointments.add(appointmentDetails);
                confirmationLabel.setText("تم حجز الموعد بنجاح!");
                
                confirmButton.setDisable(true);
                datePicker.setDisable(true);
            } else {
                confirmationLabel.setText("الرجاء اختيار تاريخ أولاً.");
                confirmationLabel.setStyle("-fx-text-fill: red; -fx-font-size: 16px;");
            }
        });
        
        // ================= Back to doctors button ================
        Button backButton = new Button("العودة للأطباء");
        backButton.setOnAction(e -> showDoctors(content, clinicName, clinics.get(clinicName), clinics));

        content.getChildren().addAll(title, datePicker, confirmButton, confirmationLabel, backButton);
    }
}
