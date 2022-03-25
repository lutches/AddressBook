
package addressbook;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import se.chalmers.cse.dat215.lab1.Presenter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class AddressBookController implements Initializable {

    @FXML private MenuBar menuBar;



    @FXML
    protected void openAboutActionPerformed(ActionEvent event) throws IOException{

        ResourceBundle bundle = java.util.ResourceBundle.getBundle("addressbook/resources/AddressBook");
        Parent root = FXMLLoader.load(getClass().getResource("address_book_about.fxml"), bundle);
        Stage aboutStage = new Stage();
        aboutStage.setScene(new Scene(root));
        aboutStage.setTitle(bundle.getString("about.title.text"));
        aboutStage.initModality(Modality.APPLICATION_MODAL);
        aboutStage.setResizable(false);
        aboutStage.showAndWait();
    }

    @FXML
    protected void closeApplicationActionPerformed(ActionEvent event) throws IOException{

        Stage addressBookStage = (Stage) menuBar.getScene().getWindow();
        addressBookStage.hide();
    }

    @FXML private Button newButton;
    @FXML
    protected void newContactActionPerformed (ActionEvent event){
        presenter.newContact();
    }
    @FXML private Button newMenuButton;

    @FXML private Button deleteButton;
    @FXML private TextField deleteMenuButton;
    @FXML private ListView contactsList;

    @FXML private TextField FirstName;

    @FXML private TextField LastName;
    @FXML private TextField Phone;
    @FXML private TextField Email;
    @FXML private TextField Address;
    @FXML private TextField PostCode;
    @FXML private TextField City;

    Presenter presenter;

    public void Presenter(ListView l,
                          TextField ntf,
                          TextField lntf,
                          TextField ptf,
                          TextField etf,
                          TextField atf,
                          TextField pctf,
                          TextField patf){}

    public void init(){}

    public void shutDown(){}

    public void newContact(){}

    public void removeCurrentContact(){}

    public void contactsListChanged(){}

    public void textFieldFocusGained(TextField t){}

    public void textFieldFocusLost(TextField t){}

    public void textFieldActionPerformed(ActionEvent evt){}

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        presenter = new Presenter(
                contactsList,
                FirstName,
                LastName,
                Phone,
                Email,
                Address,
                PostCode,
                City);
        presenter.init();
        contactsList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                presenter.contactsListChanged();
            }

        });

    }
    public void textFieldActionPerformed(){}


}
