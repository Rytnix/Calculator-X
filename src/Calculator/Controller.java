package Calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private TextField result_field;

    private long num1 =0;
    private boolean start = true;
    private String operator ="";
    private  Model calculator = new Model();

    @FXML
    void CallAboutPage(ActionEvent event) throws IOException {


        Parent aboutpage = FXMLLoader.load(getClass().getResource("About.fxml"));
        Stage stage = new Stage();
          stage.setScene(new Scene(aboutpage));
          stage.setTitle("About");
          stage.getIcons().add(new Image("Cal.png"));
          stage.setResizable(false);
          stage.show();

    }
    @FXML
    void OnClickC(ActionEvent event){
        result_field.setText("");
        operator = "";
        num1 =0;
    }

    @FXML
    void Number(ActionEvent event) {

        if(start){
            result_field.setText("");
            start = false;
        }
        String number = ((Button)event.getSource()).getText();
        result_field.setText(result_field.getText()+number);

    }
    @FXML
    void Operation(ActionEvent event) {

        String val = ((Button)event.getSource()).getText();

        if(!val.equals("=")) {
            if (!operator.isEmpty())
                return;
            operator = val;
            num1 = Long.parseLong(result_field.getText());
            System.out.println(num1);
            result_field.setText("");
        }
        else{
            if(operator.isEmpty())
                return;
            long num2 = Long.parseLong(result_field.getText());
            System.out.println(num2);
            float output =calculator.calculate(num1,num2,operator);
            System.out.println(output);
            result_field.setText(String.valueOf(output));
              operator = "";
              start = true;
        }
    }

}
