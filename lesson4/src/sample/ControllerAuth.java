package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerAuth {

    @FXML
    TextField textAuth;


    public void sendNick() throws IOException {
        String text = textAuth.getText();
        if(text == null || text.length() == 0)
            return;

        Stage stage = (Stage) textAuth.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("../sample/sample.fxml"));
        Parent root = loader.load();
        stage.setScene(new Scene(root, 600, 300));
        stage.setTitle(text + " chat");
        Controller controller = loader.<Controller>getController();
        controller.setUserNickName(text);
    }


}
