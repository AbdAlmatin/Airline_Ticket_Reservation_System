package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javafx.scene.image.Image;

import java.awt.*;
import java.io.*;

public class log_in_page_Controller {

    @FXML
    private PasswordField password;

    @FXML
    private TextField user;

    @FXML
    void lang(MouseEvent event) {

    }
    public static JSONArray j;
    public static Image emg=null;
    public static String username=null;
    public  static  JSONObject obj=null;
    public  static  Object[] d;
    @FXML
    void login(ActionEvent event) throws ParseException, IOException ,FileNotFoundException{
        Object o = new JSONParser().parse(new FileReader("userinfo.json"));
        obj = (JSONObject) o;
        username=user.getText();
        j= (JSONArray) obj.get(username);
        File fl=new File((String) j.get(7));
        try{
            emg=new Image(new FileInputStream(fl));
        }
        catch (FileNotFoundException e)
        {

        }

        if(password.getText().equals(j.get(5)))
        {
            Parent n= FXMLLoader.load(getClass().getResource("userpanel.fxml"));
            Scene n1=new Scene(n);
            Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
            window.setTitle("Profile");
            window.setScene(n1);
            //userpanelController.name.setText((String) j.get(0));
            window.show();
          //  System.out.println("hello");
        }



    }

    @FXML
    void sign_up(ActionEvent event) throws IOException, ParseException {
        Object o = new JSONParser().parse(new FileReader("userinfo.json"));
        obj = (JSONObject) o;
        d= obj.keySet().toArray();
        Parent n= FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        Scene n1=new Scene(n);
        Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
        window.setTitle("SignUp");
        window.setScene(n1);
        window.show();

    }

}
