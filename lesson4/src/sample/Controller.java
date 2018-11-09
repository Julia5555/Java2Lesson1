package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    private String nickName = "";

    public void sendMsg() {
        String text = textField.getText();
        if(text == null || text.length() == 0)return;
        textArea.appendText(nickName +": "+textField.getText() + "\n");
        textField.clear();
        textField.requestFocus();
    }

    public void setUserNickName(String nickName){
     this.nickName = nickName;
    }


}
