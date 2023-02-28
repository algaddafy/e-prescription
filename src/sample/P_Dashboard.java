package sample;

import com.pdfjet.*;
import com.pdfjet.Cell;
import com.pdfjet.Page;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class P_Dashboard implements Initializable {

    public static String pkey=LoginController.pkey;

    @FXML
    private Button p_btnhome;

    @FXML
    private Button p_btnpres;

    @FXML
    private Button p_btnedit;

    @FXML
    private Button p_btnsignout;

    @FXML
    private Pane pnPatient;

    @FXML
    private Circle btnclose2;

    @FXML
    private TextField p_tfname;

    @FXML
    private TextField p_tfphone;

    @FXML
    private TextField p_tfemail;

    @FXML
    private Button p_btnsave;

    @FXML
    private Button btncancel;

    @FXML
    private TextField p_tfage;

    @FXML
    private DatePicker p_tfdob;

    @FXML
    private ComboBox<String> genCombo3;

    @FXML
    private Pane pnHome;

    @FXML
    private Label P_welcome;

    @FXML
    private Label p_name;

    @FXML
    private Label p_gender;

    @FXML
    private Label p_phone;

    @FXML
    private Label p_age;

    @FXML
    private Circle btnclose1;

    @FXML
    private Label p_gender1;

    @FXML
    private Label p_gender11;

    @FXML
    private Label p_gender111;

    @FXML
    private Label p_gender1111;

    @FXML
    private Label p_gender2;

    @FXML
    private Pane pnPrescription;

    @FXML
    private Circle btnclose;

    @FXML
    private TableView<Patient_info> pdf_table;

    @FXML
    private TableColumn<Patient_info, String> pdf_id;

    @FXML
    private TableColumn<Patient_info, String> pdf_name;

    @FXML
    private TableColumn<Patient_info, String> pdf_dose;

    @FXML
    private TableColumn<Patient_info, String> pdf_strength;

    @FXML
    private TableColumn<Patient_info, String> pdf_advice;

    @FXML
    private TableColumn<Patient_info, String> pdf_duration;

    @FXML
    private Button pdfBtn;

    ObservableList<String> list = FXCollections.observableArrayList("Male","Female", "Other");
    ObservableList<Patient_info> list2= FXCollections.observableArrayList();

    @FXML
    void handleButtonAction(ActionEvent event) throws Exception {
        if(event.getSource().equals(p_btnhome))
        {
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/preskibo", "root", "");
                String sql = "select * from patient where ID='"+pkey+"';";

                PreparedStatement ps= con.prepareStatement(sql);
                //ps.setString(1,pn_combo.getValue());
                ResultSet rs = ps.executeQuery();


                if(rs.next()) {
                    p_name.setText(new String( rs.getString(2)));
                    p_phone.setText(new String( rs.getString(4)));
                    p_gender2.setText(new String( rs.getString(3)));
                    p_gender.setText(new String( rs.getString(7)));


                }
            }catch (Exception e){
                e.printStackTrace();
            }


            pnHome.toFront();
        }
        if(event.getSource().equals(p_btnpres)) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/preskibo", "root", "");
                PreparedStatement ps;
                ResultSet rs;

                String query = "SELECT* From prescription where Pt_ID=?";
                ps = co.prepareStatement(query);

                ps.setString(1, pkey);
                rs = ps.executeQuery();

                while (rs.next()) {
                    list2.add(new Patient_info(
                            rs.getString("Pt_ID"),
                            rs.getString("Medicine_Name"),
                            rs.getString("Dose"),
                            rs.getString("Advice"),
                            rs.getString("Duration"),
                            rs.getString("Strength")));
                    pdf_table.setItems(list2);
                }

                pdf_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                pdf_name.setCellValueFactory(new PropertyValueFactory<>("med_name"));
                pdf_dose.setCellValueFactory(new PropertyValueFactory<>("dose"));
                pdf_advice.setCellValueFactory(new PropertyValueFactory<>("advice"));
                pdf_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
                pdf_strength.setCellValueFactory(new PropertyValueFactory<>("strength"));

            } catch (Exception e) {
                e.printStackTrace();
            }
            pnPrescription.toFront();
        }

        if(event.getSource().equals(p_btnsignout))
        {
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Scene primaryStage = new Scene(root);
            Main.mainStage.setScene(primaryStage);
        }
        if(event.getSource().equals(btncancel))
        {
            pnHome.toFront();
        }
        if(event.getSource().equals(p_btnedit))
        {
            pnPatient.toFront();
        }

        if(event.getSource().equals(p_btnsave))
        {

            Connection con= null;
            PreparedStatement ps = null;

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/preskibo", "root", "");
                String sql = "UPDATE patient SET Name=?,Email=?,Phone=?,Age=?,Gender=?, DOB=? where ID =?";

                ps= con.prepareStatement(sql);
                ps.setString(1,p_tfname.getText());
                ps.setString(2,p_tfemail.getText());
                ps.setString(3,p_tfphone.getText());
                ps.setString(4,p_tfage.getText());
                ps.setString(5,genCombo3.getValue());
                ps.setString(6,((TextField)p_tfdob.getEditor()).getText());
                ps.setString(7,pkey);


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

        if(event.getSource().equals(pdfBtn)){

            File f= new File("F:\\Preskibo\\sample.pdf");
            FileOutputStream fos =new FileOutputStream(f);
            try {
                PDF pdf= new PDF(fos);

                Page page= new Page(pdf, A4.PORTRAIT);
                Font f1 = new Font(pdf, CoreFont.HELVETICA);

                Font f2 = new Font(pdf, CoreFont.HELVETICA);
                Table table= new Table();

                List<List<Cell>> tableData = new ArrayList<List<Cell>>();

                List<Cell> tablerow = new ArrayList<Cell>();
                Cell cell = new Cell(f1, pdf_id.getText());
                tablerow.add(cell);

                cell = new Cell(f1, pdf_name.getText());
                tablerow.add(cell);

                cell = new Cell(f1, pdf_dose.getText());
                tablerow.add(cell);

                cell = new Cell(f1, pdf_advice.getText());
                tablerow.add(cell);

                cell = new Cell(f1, pdf_duration.getText());
                tablerow.add(cell);

                cell = new Cell(f1, pdf_strength.getText());
                tablerow.add(cell);

                tableData.add(tablerow);
                List<Patient_info> items= pdf_table.getItems();

                for(Patient_info comm: items){
                    Cell PatientID = new Cell(f2, comm.getId());
                    Cell Medicine_Name = new Cell(f2, comm.getMed_name());
                    Cell Dose = new Cell(f2, comm.getDose());
                    Cell Advice = new Cell(f2, comm.getAdvice());
                    Cell Duration = new Cell(f2, comm.getDuration());
                    Cell Strength = new Cell(f2, comm.getStrength());

                    tablerow = new ArrayList<Cell>();
                    tablerow.add(PatientID);
                    tablerow.add(Medicine_Name);
                    tablerow.add(Dose);
                    tablerow.add(Advice);
                    tablerow.add(Duration);
                    tablerow.add(Strength);


//						add row to table
                    tableData.add(tablerow);
                }
                table.setData(tableData);
                table.setPosition(50f,50f);
                table.setColumnWidth(0,80f);
                table.setColumnWidth(1,90f);
                table.setColumnWidth(2,80f);
                table.setColumnWidth(3,80f);
                table.setColumnWidth(4,80f);
                table.setColumnWidth(5,80f);


                while (true){
                    table.drawOn(page);
                    if(!table.hasMoreData()){
                        table.resetRenderedPagesCount();
                        break;
                    }
                    page= new Page(pdf, A4.PORTRAIT);
                }
                pdf.flush();
                fos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }


    }

    @FXML
    void handleMouseEvent(MouseEvent event) {
        if(event.getSource()==btnclose||event.getSource()==btnclose1||event.getSource()==btnclose2)
        {
            System.exit(0);
        }
    }

    public void initialize(URL url, ResourceBundle rb){
        genCombo3.setItems(list);
    }

}