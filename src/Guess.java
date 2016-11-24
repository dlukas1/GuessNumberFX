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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;


public class Guess extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        //Create scene
        StackPane stack = new StackPane();
        Scene scene = new Scene(stack, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("-Guess Number-"); //Title
        primaryStage.setResizable(false); //Window not resizable

        //make a bet before start
        TextField betField = new TextField("Sinu panus:");
        stack. getChildren().add(betField);



        //Text field
        TextField field1 = new TextField("Sisesta number 1 - 100 : ");
        stack.getChildren().add(field1);


        //Create button GO
        Button btn = new Button();
        btn.setText("Go!");
        stack.getChildren().add(btn);//Add to stack
        btn.setTranslateY(50);

        //Directions how to play(remove after game started)
        Label l = new Label("Proovi välja arvata number 1st 100ni! Sul on 5 katset!");
        stack.getChildren().add(l);
        l.setTranslateY(-70);

        Label copyrights = new Label("Dmitri Lukas © 2016");
        stack.getChildren().add(copyrights);
        copyrights.setTranslateY(95);
        copyrights.setTranslateX(140);

       //Text bellow - less, more, won
        final Text actiontarget = new Text();
        stack.getChildren().add(actiontarget);
        actiontarget.setTranslateY(80);

        //Start game

        btn.setOnAction(new EventHandler<ActionEvent>() {

            int i = 0; //0 tries used
            Engine engineObject = new Engine();

            @Override
            public void handle(ActionEvent event) {

                int sisNum;
                int tryNumber = 5;

                btn.setText("Go");
                //remove directions
                stack.getChildren().remove(l);

                //loose if more then 5 tries
                if(i >= tryNumber){
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("You lost the game! Correct answer was " + engineObject.rndNum);
                    btn.setText("Sisesta number ja mängi uuesti"); //convert button GO to PLAY AGAIN
                    field1.clear();
                    engineObject.GenerateNumber();
                    i = 0;

                } else
                    {
                    //check entered number
                    boolean isNumber= engineObject.kasNumber(field1.getText());
                    if(isNumber == false){
                        actiontarget.setText("See ei ole number, sisesta number!"); //if not a number
                    } else{
                        sisNum = Integer.parseInt(field1.getText()); //if number - convert to int

                        if(sisNum>100 || sisNum <0) {
                            actiontarget.setText("Number peab olla vahemikus 0 - 100 !"); //
                        } else{
                            i++;
                            String answer = engineObject.Check(sisNum);

                            //if guessed
                            if(answer == "Võit!"){
                                actiontarget.setFill(Color.RED);
                                actiontarget.setText("Yoy won! Congratulations!");
                                btn.setText("Sisesta number ja mängi uuesti"); //convert button GO to PLAY AGAIN
                                field1.clear();
                                engineObject.GenerateNumber();
                                i = 0;

                                //if not guessed number
                            }
                            else {
                                actiontarget.setFill(Color.BLUE);
                                actiontarget.setText(answer + ", left " + (tryNumber - i+1) + " tries!");//
                            }
                        }

                    }
                }
            }
        });
        primaryStage.show();
    }
}