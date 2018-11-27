package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SampleController {
	@FXML private TextField HFname;
	@FXML private TextField KFname;
	@FXML private TextField HLname;
	@FXML private TextField KLname;
	@FXML private TextField Belongs;
	@FXML private TextField Position;
	@FXML private TextField Address;
	@FXML private TextField Email;
	@FXML private TextField Tell;
	@FXML private TextField Url;
	@FXML private TextArea Remarks;
	@FXML private Button BackButton;
	@FXML private Button NextButton;

	@FXML
	protected void Back(ActionEvent evt) {
		System.out.println("BackÅI");
	}
	
	@FXML
	protected void Next(ActionEvent evt) {
		System.out.println("NextÅI");
	}
}
