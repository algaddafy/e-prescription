package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.io.IOException;
import java.sql.*;


public class LoginController {

    public static String session;
    public static String pkey;
    @FXML
    private Circle btnclose;

    @FXML
    private Label labeltitle;

    @FXML
    private Label labelslogan;

    @FXML
    private Pane pnsignin2;

    @FXML
    private TextField tfpid;

    @FXML
    private Button Btnsignin2;

    @FXML
    private Label labelforgot1;

    @FXML
    private Label signin1;

    @FXML
    private Button btnptnsigin;

    @FXML
    private Pane pnsignup;

    @FXML
    private Label labelsignup;

    @FXML
    private TextField tfname1;

    @FXML
    private TextField tfpassword2;

    @FXML
    private TextField tfname2;

    @FXML
    private TextField tfemail2;

    @FXML
    private ImageView btnback;

    @FXML
    private Pane pnsignin;

    @FXML
    private PasswordField tfpass;

    @FXML
    private TextField tfemail;

    @FXML
    private Button btnsignin;

    @FXML
    private Button btnsignup;

    @FXML
    private Label labelforgot;

    @FXML
    private Label signin;

    @FXML
    private Button btnsignin2;
    @FXML
    private Button Btnsignin21;





    @FXML
    private void handleButtonAction(ActionEvent event)
    {
        if(event.getSource().equals(btnsignup))
        {
            pnsignup.toFront();
        }
        if(event.getSource().equals(Btnsignin2))
        {
            Connection con= null;
            PreparedStatement ps = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/preskibo", "root", "");
                String sql = "INSERT INTO doctor (Name, Designation, Password, Email) VALUES(?,?,?,?)";

                ps= con.prepareStatement(sql);

                ps.setString(1, tfname1.getText());
                ps.setString(2, tfname2.getText());
                ps.setString(3, tfpassword2.getText());
                ps.setString(4, tfemail2.getText());

                int i = ps.executeUpdate();
                if(i>0){
                    pnsignin.toFront();
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Account Created");
                    a.setHeaderText(" Account Created Successfully");
                    a.setContentText("Your Account is created Successfully");
                    a.showAndWait();
                }
            }
            catch (Exception e){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Error in Login Account");
                a.setContentText("Your Account is not created Because of Technical Issue"+e.getMessage());
                a.showAndWait();
            }
        }
        if(event.getSource().equals(Btnsignin21))
        {
            pnsignin.toFront();
        }
        if(event.getSource().equals(btnsignin2))
        {
            pnsignin2.toFront();
        }
        if(event.getSource().equals(btnsignin))
        {
            Connection con= null;
            PreparedStatement ps = null;
            ResultSet rs= null;
            try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con= DriverManager.getConnection("jdbc:mysql://localhost:3306/preskibo", "root", "");
                    String sql = "Select * from doctor where Email=? and Password=?";
                    ps= con.prepareStatement(sql);

                    ps.setString(1, tfemail.getText());
                    ps.setString(2, tfpass.getText());
                    rs= ps.executeQuery();

                    session=tfemail.getText();

                    if(rs.next()){
                        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                        Scene dashboard = new Scene(root);
                        Main.mainStage.setScene(dashboard);
                        Alert a = new Alert(Alert.AlertType.INFORMATION);
                        a.setTitle("Welcome");
                        a.setHeaderText("You are Logged In");
                        a.setContentText("You've logged in successfully");
                        a.showAndWait();
                    }
            }catch (Exception e){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Error in Login Account");
                a.setContentText(e.getMessage());
            }
        }

        if(event.getSource().equals(btnptnsigin))
        {
            Connection con= null;
            PreparedStatement ps = null;
            ResultSet rs= null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/preskibo", "root", "");
                String sql = "Select * from patient where ID=?";
                ps= con.prepareStatement(sql);

                ps.setString(1, tfpid.getText());

                rs= ps.executeQuery();

                pkey=tfpid.getText();

                if(rs.next()){
                    Parent root= FXMLLoader.load(getClass().getResource("P_Dasboard.fxml"));
                    Scene p_dashboard = new Scene(root);
                    Main.mainStage.setScene(p_dashboard);
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Welcome");
                    a.setHeaderText("You are Logged In");
                    a.setContentText("You've logged in successfully");
                    a.showAndWait();
                }
            }catch (Exception e){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Error in Login Account");
                a.setContentText(e.getMessage());
            }
        }
    }
    @FXML
    private  void handleMouseEvent(MouseEvent event)
    {
        if(event.getSource()==btnclose)
        {
            System.exit(0);
        }
        if(event.getSource().equals(btnback))
        {
            pnsignin.toFront();
        }
    }
}
