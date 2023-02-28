package sample;

import com.mysql.cj.Session;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import java.io.IOException;
import java.net.URL;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.ResourceBundle;


public class Dashboard implements Initializable {

    public static String session= LoginController.session;
    @FXML
    private Button btnhome;

    @FXML
    private Button btnpres;

    @FXML
    private Button btnptn;

    @FXML
    private Button btnaddmed;

    @FXML
    private Button btnedit;

    @FXML
    private Button btnsignout;

    @FXML
    private Pane pnMedicine;

    @FXML
    private Circle btnclose1;

    @FXML
    private TextField m_tfname;

    @FXML
    private TextField m_tfgen;

    @FXML
    private Button medsave;

    @FXML
    private Pane pnPatlist;

    @FXML
    private Circle btnclose4;

    @FXML
    private HBox btnaddptn;

    @FXML
    private Pane pnHome;

    @FXML
    private Pane pneditinfo;

    @FXML
    private Circle btnclose21;

    @FXML
    private TextField tfname;

    @FXML
    private TextField tfdepartment;

    @FXML
    private TextField tfemail;

    @FXML
    private Button btnsave;

    @FXML
    private Button btncancel1;

    @FXML
    private TextField tfdes;

    @FXML
    private DatePicker tfdob;

    @FXML
    private ComboBox<String> genCombo;
    @FXML
    private ComboBox<String> genCombo2;

    @FXML
    private Pane pnPrescription;

    @FXML
    private Circle btnclose;

    @FXML
    private HBox btnnewpres;

    @FXML
    private Pane pnNewPres;

    @FXML
    private Label pres_namelabel;

    @FXML
    private Label pres_agelabel;

    @FXML
    private Label pres_genlabel;

    @FXML
    private TextField med_tfstren;

    @FXML
    private ComboBox<String> medicine_combo;

    @FXML
    private TextField med_tfdose;

    @FXML
    private TextField med_tfduration;

    @FXML
    private TextField med_tfad;

    @FXML
    private Circle btnclose3;

    @FXML
    private Button pres_save;

    @FXML
    private Button pres_add;

    @FXML
    private Pane pnPatuent;

    @FXML
    private Circle btnclose2;

    @FXML
    private TextField tfp_name;

    @FXML
    private TextField tf_pphone;

    @FXML
    private TextField tf__pemail;

    @FXML
    private TextField tf_page;

    @FXML
    private Button btnPsave;

    @FXML
    private Button btncancel;

    @FXML
    private DatePicker tf_pdob;

    @FXML
    private ComboBox<String> pn_combo;

    @FXML
    private Label welcomeText;

    @FXML
    private Label home_name;

    @FXML
    private Label home_email;

    @FXML
    private Label home_desig;

    @FXML
    private Label home_dept;

    @FXML
    private TableColumn<Prescription, String> m_tabname;

    @FXML
    private TableColumn<Prescription, String> m_tabstrength;

    @FXML
    private TableColumn<Prescription, String> m_tabdose;

    @FXML
    private TableColumn<Prescription, String> m_tabdur;

    @FXML
    private TableColumn<Prescription, String> m_tabad;

    @FXML
    private TableColumn<Prescription, String> m_tabstat;

    @FXML
    private TableView<Prescription> pres_table;


    @FXML
    private TableView<Patient> plist_tab;

    @FXML
    private TableColumn<Patient, String> p_tabname;

    @FXML
    private TableColumn<Patient, String> p_tabdob;

    @FXML
    private TableColumn<Patient, String> p_tabage;

    @FXML
    private TableColumn<Patient, String> p_tabphone;

    @FXML
    private TableColumn<Patient, String> p_tabgen;

    @FXML
    private TableColumn<Patient, String> p_tabid;

    @FXML
    private Button refresh_pres;


    @FXML
    private TableColumn<Patient, String> pres_tabname;

    @FXML
    private TableColumn<Patient, String> pres_tabid;

    @FXML
    private TableColumn<Patient, String> pres_tabno;

    @FXML
    private  TableView<Patient> pres_tab;

    Prescription p = null;
    Patient pt = null;
    String query= null;
    Connection connection= null;
    ResultSet rset= null;
    PreparedStatement pset = null;

    String pt_name=null;
    String pt_ID=null;




    ObservableList<String> list = FXCollections.observableArrayList("Male","Female", "Other");
    ObservableList<Prescription> preslist= FXCollections.observableArrayList();
    ObservableList<Patient> patientlist= FXCollections.observableArrayList();


    public int generateID(){
        Random rand = new Random();
        int num = rand.nextInt(899999)+10000;
        return num;
    }
    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
        if(event.getSource().equals(btnhome))
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/preskibo", "root", "");
                String sql = "select * from Doctor where Email='"+session+"';";

                PreparedStatement ps= con.prepareStatement(sql);
                //ps.setString(1,pn_combo.getValue());
                ResultSet rs = ps.executeQuery();


                if(rs.next()) {
                    welcomeText.setText(new String("Hi, " + rs.getString(1)));
                    home_name.setText(new String( rs.getString(1)));
                    home_desig.setText(new String( rs.getString(4)));
                    home_dept.setText(new String( rs.getString(7)));
                    home_email.setText(new String( rs.getString(2)));

                }
            }catch (Exception e){
                e.printStackTrace();
            }

            pnHome.toFront();

        }
        if(event.getSource().equals(btnpres))
        {
            pnPrescription.toFront();
        }
        if(event.getSource().equals(btnptn))
        {
            pnPatlist.toFront();

            //Here goes the patient table

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/preskibo", "root", "");
                PreparedStatement ps;
                ResultSet rs;

                    query="SELECT* From patient where doctor=?";
                    ps=co.prepareStatement(query);

                    ps.setString(1,session);
                    rs=ps.executeQuery();

                    while (rs.next()){
                        patientlist.add(new Patient(
                                rs.getString("Name"),
                                rs.getString("Age"),
                                rs.getString("Phone"),
                                rs.getString("DOB"),
                                rs.getString("Gender"),
                                rs.getString("ID")));
                        plist_tab.setItems(patientlist);


                }

                p_tabname.setCellValueFactory(new PropertyValueFactory<>("name"));
                p_tabdob.setCellValueFactory(new PropertyValueFactory<>("dob"));
                p_tabage.setCellValueFactory(new PropertyValueFactory<>("age"));
                p_tabgen.setCellValueFactory(new PropertyValueFactory<>("gender"));
                p_tabid.setCellValueFactory(new PropertyValueFactory<>("id"));
                p_tabphone.setCellValueFactory(new PropertyValueFactory<>("phone"));





            }catch (Exception e){
                e.printStackTrace();
            }

        }
        if(event.getSource().equals(btnedit))
        {
            pneditinfo.toFront();

            System.out.println(session);
        }
        if(event.getSource().equals(btnaddmed))
        {
            pnMedicine.toFront();
        }


        if(event.getSource().equals(btnsignout))
        {

            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene primaryStage = new Scene(root);
            Main.mainStage.setScene(primaryStage);
        }
        if(event.getSource().equals(btncancel))
        {
            pnHome.toFront();
        }
        if(event.getSource().equals(btnsave))
        {

            Connection con= null;
            PreparedStatement ps = null;

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/preskibo", "root", "");
                String sql = "UPDATE doctor SET Name=?,Email=?,Designation=?,Department=?,Gender=?, DOB=? where Email =?";

                ps= con.prepareStatement(sql);
                ps.setString(1,tfname.getText());
                ps.setString(2,tfemail.getText());
                ps.setString(3,tfdes.getText());
                ps.setString(4,tfdepartment.getText());
                ps.setString(5,genCombo2.getValue());
                ps.setString(6,((TextField)tfdob.getEditor()).getText());
                ps.setString(7,session);

                //ps.setString(1,session);
                int i = ps.executeUpdate();

                if(i>0){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Edit Info");
                    a.setHeaderText(" Information Updated Successfully");
                    a.setContentText("Your new information are now stored in database");
                    a.showAndWait();
                }
            }
            catch (Exception e){
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setTitle("Error");
                a.setHeaderText("Error in Login Account");
                a.setContentText("Your Account is not created Because of Technical Issue\n"+e.getMessage());
                a.showAndWait();
            }
        }
        if(event.getSource().equals(btnPsave))
        {
            Connection con= null;
            PreparedStatement ps = null;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/preskibo", "root", "");
                String sql = "INSERT INTO patient (Name, Age, Phone, Email, DOB, Gender, ID, Doctor) VALUES(?,?,?,?,?,?,?,?)";

                ps= con.prepareStatement(sql);

                ps.setString(1, tfp_name.getText());
                ps.setString(2, tf_page.getText());
                ps.setString(3, tf_pphone.getText());
                ps.setString(4, tf__pemail.getText());
                ps.setString(5, ((TextField)tf_pdob.getEditor()).getText());
                ps.setString(6, genCombo.getValue());
                ps.setString(7, String.valueOf(generateID()));
                ps.setString(8, session);

                int i = ps.executeUpdate();
                if(i>0){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Account Created");
                    a.setHeaderText(" Account Created Successfully");
                    a.setContentText("Your Account is created Successfully");
                    a.showAndWait();
                }


            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        if(event.getSource().equals(pres_add)){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/preskibo", "root", "");
                String sql = "select * from patient where Name=?";

                PreparedStatement ps= con.prepareStatement(sql);
                ps.setString(1,pn_combo.getValue());


                ResultSet rs = ps.executeQuery();






                if(rs.next()) {
                    pres_namelabel.setText(new String("Patient Name: " + rs.getString(2)));
                    pres_agelabel.setText(new String("Patient Age: " + rs.getString(3)));
                    pres_genlabel.setText(new String("Gender: " + rs.getString(7)));
                    pt_ID=rs.getString(1);
                    pt_name=rs.getString(2);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        if(event.getSource().equals(medsave)){
            Connection con= null;
            PreparedStatement ps = null;
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/preskibo", "root", "");
                String sql = "INSERT INTO Medicine (Name, Generic) VALUES(?,?)";

                ps= con.prepareStatement(sql);

                ps.setString(1, m_tfname.getText());
                ps.setString(2, m_tfgen.getText());

                int i = ps.executeUpdate();
                if(i>0){
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    a.setTitle("Medicine Added");
                    a.setHeaderText("Medicine Added Successfully");
                    a.setContentText("Medicine Added to your precription list");
                    a.showAndWait();
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        if(event.getSource().equals(refresh_pres)){
            LoadData();
        }

        if(event.getSource().equals(pres_save)){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/preskibo", "root", "");



                String med_name= medicine_combo.getValue();
                String dose= med_tfdose.getText();
                String strength= med_tfstren.getText();
                String advice= med_tfad.getText();
                String Duration= med_tfduration.getText();

                if ( med_name.isEmpty() || dose.isEmpty() || strength.isEmpty()|| advice.isEmpty()|| Duration.isEmpty()) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setContentText("Please Fill All DATA");
                    alert.showAndWait();
                }
                else{
                   String sql = "INSERT INTO prescription( pt_name, Medicine_name, Dose, Strength, Advice, Duration, pt_ID, doctor) VALUES (?,?,?,?,?,?,?,?)";

                   PreparedStatement ps = con.prepareStatement(sql);
                   ps.setString(1,pt_name);
                   ps.setString(2,medicine_combo.getValue());
                   ps.setString(3,med_tfdose.getText());
                   ps.setString(4,med_tfstren.getText());
                   ps.setString(5,med_tfad.getText());
                   ps.setString(6,med_tfduration.getText());
                   ps.setString(7,pt_ID);
                   ps.setString(8,session);

                   int i = ps.executeUpdate();
                   if (i>0)
                   {
                       Alert a = new Alert(Alert.AlertType.INFORMATION);
                       a.setTitle("Medicine Add list");
                       a.setHeaderText("Medicine Added Successfully");
                       a.setContentText("Medicine Added to your precription list");
                       a.showAndWait();
                   }



                }

            }catch (Exception e){

                e.printStackTrace();

            }

        }

    }

    @FXML
    void handleMouseEvent(MouseEvent event) {
        if(event.getSource()==btnclose||event.getSource()==btnclose1||event.getSource()==btnclose2||event.getSource()==btnclose3||event.getSource()==btnclose4)
        {
            System.exit(0);
        }
        if(event.getSource()==btnnewpres)
        {
            pnNewPres.toFront();
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/preskibo", "root", "");
                ResultSet rs= con.createStatement().executeQuery("select name from patient");
                ResultSet rs2= con.createStatement().executeQuery("select Name from Medicine");
                ObservableList data= FXCollections.observableArrayList();
                ObservableList data2= FXCollections.observableArrayList();
                while(rs.next()){
                    data.add(new String(rs.getString(1)));
                }
                while(rs2.next()){
                    data2.add(new String(rs2.getString(1)));
                }
                pn_combo.setItems(data);
                medicine_combo.setItems(data2);
            }catch (Exception e){
                e.printStackTrace();
            }


        }
        if(event.getSource().equals(btnaddptn))
        {
            pnPatuent.toFront();
        }

    }

    public void initialize(URL url, ResourceBundle rb){
        genCombo.setItems(list);
        genCombo2.setItems(list);

        LoadData();
    }
    public void LoadData(){

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/preskibo", "root", "");

            refresh();

        m_tabname.setCellValueFactory(new PropertyValueFactory<>("Name"));
        m_tabdose.setCellValueFactory(new PropertyValueFactory<>("Dose"));
        m_tabdur.setCellValueFactory(new PropertyValueFactory<>("Duration"));
        m_tabad.setCellValueFactory(new PropertyValueFactory<>("Advice"));
        m_tabstrength.setCellValueFactory(new PropertyValueFactory<>("Strength"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void refresh(){
        try{
            preslist.clear();

            query="SELECT* From Prescription where pt_id=?";
            pset=connection.prepareStatement(query);

            pset.setString(1,pt_ID);
            rset=pset.executeQuery();

            while (rset.next()){
                preslist.add(new Prescription(
                        rset.getString("Medicine_name"),
                        rset.getString("Strength"),
                        rset.getString("Dose"),
                        rset.getString("Duration"),
                        rset.getString("Advice")
                ));
                pres_table.setItems(preslist);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
