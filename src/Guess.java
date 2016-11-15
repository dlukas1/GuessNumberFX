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

        //Создаем сцену
        StackPane stack = new StackPane();
        Scene scene = new Scene(stack, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Guess Number"); //Название
        primaryStage.setResizable(false); //Постоянный размен

        //Поле ввода текста
        TextField field1 = new TextField("Sisesta number 1 - 100:");
        stack.getChildren().add(field1);

        //Создаем кнопку
        Button btn = new Button();
        btn.setText("Go!");
        stack.getChildren().add(btn);//добавим на поле
        btn.setTranslateY(50);

        //Кнопка "Играть еще"
        Button btn1 = new Button();
        btn1.setText("Play again");
        btn1.setTranslateY(50);
        btn1.setTranslateX(100);

        //Инструкция над полем ввода (Удалить после начала игры)
        Label l = new Label("Proovi välja arvata number 1st 100ni! Sul on 5 katset!");
        stack.getChildren().add(l);
        l.setTranslateY(-70);


       //Комментарии внизу - больше, меньше, угадал, проиграл
        final Text actiontarget = new Text();
        stack.getChildren().add(actiontarget);
        actiontarget.setTranslateY(80);



        //Кнопка перезапускает игру после проигрыша
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){}
            //dodelat'


        });

        //Начинем игру
        btn.setOnAction(new EventHandler<ActionEvent>() {

            int i = 0; //0 попыток использовано
            Engine engineObject = new Engine();

            @Override
            public void handle(ActionEvent event) {

                int sisNum;
                int tryNumber = 4;
                btn.setText("Go");
                stack.getChildren().remove(l);//удаляем инструкцию после начала игры





                //при проигрыше, если больше 5 попыток:
                if(i >= tryNumber){
                    actiontarget.setFill(Color.RED);
                    actiontarget.setText("You lost the game! Correct answer was " + engineObject.rndNum);
                    btn.setText("Start again");
                    engineObject.GenerateNumber();
                    i = 0;
                    //поменять текст на НАЧАТЬ ЗАНОВО и
                    // stack.getChildren().remove(btn);
                    //stack.getChildren().add(btn1);
                    //knopka start new game



                } else {
                    //proverka
                    boolean isNumber= engineObject.kasNumber(field1.getText());
                    if(isNumber == false){
                        actiontarget.setText("See ei ole number, sisesta number!");
                    } else{
                        sisNum = Integer.parseInt(field1.getText());

                        if(sisNum>100) {
                            actiontarget.setText("Number ei saa olla suurem kui 100!");
                        } else{
                            i++;
                            String answer = engineObject.Check(sisNum);

                            //Если угадал
                            if(answer == "Võit!"){
                                actiontarget.setFill(Color.RED);
                                actiontarget.setText("Yoy won! Congratulations!");
                                //stack.getChildren().remove(btn);

                                //если не угадал
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