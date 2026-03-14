package com.example;

import java.util.concurrent.ConcurrentHashMap;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class login extends Application {


    main_user mu = new main_user();

    
    @Override
    public void start(Stage ss) {

      
        //================ Image ====================//

        Image logov = new Image(getClass().getResourceAsStream("logo.png"));
        ImageView logo = new ImageView(logov);
        logo.setFitWidth(250);
        logo.setFitHeight(250);

        //================ TextField user =============//

        TextField tf1 = new TextField();
        tf1.setPromptText(" اسم المستخدم ");
        tf1.setPadding(new Insets(10, 10, 10, 10));
        tf1.setStyle(
            "-fx-font-size: 18px; -fx-alignment: center;" +
            "-fx-background-radius: 20;" +
            "-fx-border-radius: 20;" +
            "-fx-border-color: #000000ff;" +
            "-fx-border-width: 1;"
        );


        

        //================ TextField password =========//

        PasswordField pf1 = new PasswordField();
        pf1.setPromptText(" كلمة المرور ");
        pf1.setPadding(new Insets(10, 10, 10, 10));
        pf1.setStyle(
            "-fx-font-size: 18px; -fx-alignment: center;" +
            "-fx-background-radius: 20;" +
            "-fx-border-radius: 20;" +
            "-fx-border-color: #000000ff;" +
            "-fx-border-width: 1;"
        );
        //================ TextField admin number =========//

        TextField tf2 = new TextField();
        tf2.setPromptText(" الرقم الوظيفي");
        tf2.setPadding(new Insets(10, 10, 10, 10));

                tf2.setStyle(
            "-fx-font-size: 18px; -fx-alignment: center;" +
            "-fx-background-radius: 20;" +
            "-fx-border-radius: 20;" +
            "-fx-border-color: #000000ff;" +
            "-fx-border-width: 1;"
        );
        tf2.setVisible(false);
        

    //================ ToggleButtons =============//

    ToggleButton userBtn = new ToggleButton("user");
    ToggleButton adminBtn = new ToggleButton("Admin");

    ToggleGroup group = new ToggleGroup();
        userBtn.setToggleGroup(group);
        adminBtn.setToggleGroup(group);

        userBtn.setSelected(true); 
        

        userBtn.setStyle(
            "-fx-font-size: 16px;" +
            "-fx-background-radius: 20;" +
            "-fx-border-radius: 20;" +
            "-fx-border-color: #775454ff;" +
            "-fx-border-width: 1;" +
            "-fx-padding: 10 20 10 20;"
        );
        adminBtn.setStyle(
            "-fx-font-size: 16px;" +
            "-fx-background-radius: 20;" +
            "-fx-border-radius: 20;" +
            "-fx-border-color: #000000ff;" +
            "-fx-border-width: 1;" +
            "-fx-padding: 10 20 10 20;"
        );
        // Listener to handle toggle button selection

        group.selectedToggleProperty().addListener((obs, oldV, newV) -> {
    if (newV == userBtn) {
        tf2.setVisible(false);
    } else if (newV == adminBtn) {
        tf2.setVisible(true);
    }
});

    //================ Rectangle ===================//
        Rectangle  rec = new Rectangle(740, 700);
        rec.setArcWidth(78);
        rec.setArcHeight(78);
        rec.setStroke(Color.web("#ffffffff"));  // حدّ بسيط
        rec.setStrokeWidth(2);

        rec.setFill(new LinearGradient(1, 0, 0, 1, true, null,
            new javafx.scene.paint.Stop[]{
                new javafx.scene.paint.Stop(0, javafx.scene.paint.Color.web("#d89096ff")),
                new javafx.scene.paint.Stop(1, javafx.scene.paint.Color.web("#f40025ff"))
            }


        ));

        //================ Button =====================//

        Button btn = new Button(" Login ");
        btn.setStyle(
            "-fx-font-size: 20px;" +
            "-fx-background-color: #000000ff;" +
            "-fx-text-fill: #ffffffff;" +
            "-fx-background-radius: 30;" +
            "-fx-border-radius: 30;" +
            "-fx-padding: 10 30 10 30;"
        );
        btn.setOnMouseEntered(e -> btn.setStyle(
            "-fx-font-size: 20px;" +
            "-fx-background-color: #a90404ff;" +
            "-fx-text-fill: #ffffffff;" +
            "-fx-background-radius: 30;" +
            "-fx-border-radius: 30;" +
            "-fx-padding: 10 30 10 30;"
        ));
        btn.setOnMouseExited(e -> btn.setStyle(
            "-fx-font-size: 20px;" +
            "-fx-background-color: #000000ff;" +
            "-fx-text-fill: #ffffffff;" +
            "-fx-background-radius: 30;" +
            "-fx-border-radius: 30;" +
            "-fx-padding: 10 30 10 30;"
        ));
        
        //================ Text =====================//


        Text tt = new Text();
        tt.setText("Welcome to Romana Medical ");
        tt.setStyle("-fx-font-size: 24px; -fx-fill: #ffffffff;");


        DropShadow shadow = new DropShadow();
        shadow.setOffsetX(8);
        shadow.setOffsetY(8);
        shadow.setRadius(10);
        shadow.setColor(Color.BLACK);

        tt.setEffect(shadow);
        
   



    //================ HBox ======================//

        HBox hbox = new HBox(20, adminBtn, userBtn);
        hbox.setAlignment(Pos.CENTER);

        //================= VBox ======================//

        VBox vbox = new VBox(20); 
        vbox.getChildren().addAll(logo,hbox, tf1, pf1,tf2,tt, btn);
        vbox.setAlignment(Pos.CENTER);
        
        vbox.setMargin(btn, new Insets(0 ,0 , 50 , 0 ));

        //================ StackPane ==================//
        StackPane stackpane1 = new StackPane(rec,vbox);
        stackpane1.setPadding(new Insets(50, 111, 50, 111));

            //================ Button Action =============//


        btn.setOnMouseClicked(e -> {
            if (userBtn.isSelected()) {
                
                if (tf1.getText().equals("1") && pf1.getText().equals("1")) {
                    
                       
                    main_user userPage = new main_user();   
                    ss.setScene(userPage.getScene(ss, ss.getScene()));       
                    

                    
                     
                } else {
                    tt.setText("Invalid user ID or password");
                }

            } else if (adminBtn.isSelected()) {
                

                if (tf1.getText().equals("1") && pf1.getText().equals("1") && tf2.getText().equals("1")) {
                    
                    main_admin adminpage=new main_admin();
                    ss.setScene(adminpage.getScene(ss, ss.getScene()));
                    
                } else {
                    tt.setText("Invalid user ID or password ......");
                }

            }
        });

        

        
        //================ Scene + Stage ==============//
        
        Scene scene = new Scene(stackpane1, 800, 750);
        ss.setScene(scene);
        ss.setTitle("مجمع رمانةالطبي");
        ss.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
