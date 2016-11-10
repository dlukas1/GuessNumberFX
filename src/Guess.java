/**
 * Created by Dmitry on 8.11.2016.
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Guess extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane stack = new StackPane();
        Scene scene = new Scene(stack, 400, 200);
        primaryStage.setScene(scene);

        primaryStage.setTitle("Guess Number");
        primaryStage.setResizable(false);

        TextField field1 = new TextField("Sisesta number 1 - 100:");
        stack.getChildren().add(field1);

        Button btn = new Button();
        btn.setText("Start");
        stack.getChildren().add(btn);
        btn.setTranslateY(50);

        Button btn1 = new Button();
        btn1.setText("Play again");
        btn1.setTranslateY(50);

        Label l = new Label("Proovi välja arvata number 1st 100ni! Sul on 5 katset!");
        stack.getChildren().add(l);
        l.setTranslateY(-70);


       final Text actiontarget = new Text();
        stack.getChildren().add(actiontarget);
        actiontarget.setTranslateY(80);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               //dodelat'
            }
        });

        btn.setOnAction(new EventHandler<ActionEvent>() {

            int i = 0;
            Engine engineObject = new Engine();

            @Override
            public void handle(ActionEvent event) {
                int sisNum;
                int tryNumber = 5;

                if(i >= tryNumber){
                    actiontarget.setText("You lost the game! Correct answer was " + engineObject.sisNum);
                    stack.getChildren().remove(btn);
                    stack.getChildren().add(btn1);
                    //knopka start new game

                } else {
                    //proverka
                    i++;
                    //try catch block
                    //ESLI VVEL >100 ILI <1
                    //esli vvel to ze samoe
                    sisNum = Integer.parseInt(field1.getText());
                    String answer = engineObject.Check(sisNum);
                    if(answer == "Võit!"){
                        actiontarget.setFill(Color.BLUE);
                        actiontarget.setText("Yeeee, correct");
                        stack.getChildren().remove(btn);

                    } else {
                        actiontarget.setFill(Color.BLUE);
                        actiontarget.setText(answer + ", left " + (tryNumber - i + 1) + " tries!");

                    }
                }
            }
        });






        primaryStage.show();

    }
}