package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SampleController {
	String[] data = new String[12];

	@FXML
	private TextField HFname;
	@FXML
	private TextField KFname;
	@FXML
	private TextField HLname;
	@FXML
	private TextField KLname;
	@FXML
	private TextField Belongs;
	@FXML
	private TextField Position;
	@FXML
	private TextField Address;
	@FXML
	private TextField Email;
	@FXML
	private TextField Tell;
	@FXML
	private TextField Url;
	@FXML
	private TextField SearchCard;
	@FXML
	private TextArea Remarks;
	@FXML
	private Button BackButton;
	@FXML
	private Button SearchButton;
	@FXML
	private Button NextButton;
	@FXML
	private Button SetButton;
	@FXML
	private Button StartButton;
	@FXML
	private Button NewButton;
	@FXML
	private Button DeleteButton;
	@FXML
	private Label AllCards;
	@FXML
	private Label StartLabel;

	@FXML
	protected void Set(ActionEvent evt) throws IOException {
		String txtArea = Remarks.getText();
		if (txtArea != null) {
			txtArea = txtArea.replace("\n", "\\n");
		}
		String[] newData = { HLname.getText(), HFname.getText(), KLname.getText(), KFname.getText(), Belongs.getText(),
				Position.getText(), Address.getText(), Email.getText(), Tell.getText(), Url.getText(), txtArea,
				AllCards.getText(), SearchCard.getText() };
		WriteC wdata = new WriteC();
		wdata.SetData(newData);
	}

	@FXML
	protected void New(ActionEvent evt) {
		String[] newData = { null, null, null, null, null, null, null, null, null, "http://www.", null };
		this.SetText(newData);
		SearchCard.setText("0");
		SetButton.setText("Regist");
	}

	@FXML
	protected void search(ActionEvent evt) throws IOException {
		this.snb(0);
	}

	@FXML
	protected void Next(ActionEvent evt) throws IOException {
		this.snb(1);
	}

	@FXML
	protected void Back(ActionEvent evt) throws IOException {
		this.snb(2);
	}

	@FXML
	protected void Start(ActionEvent evt) throws IOException {
		this.snb(0);
		StartButton.setVisible(false);
		StartLabel.setVisible(false);
	}

	@FXML
	protected void Delete(ActionEvent evt) throws IOException  {
		WriteC wdata = new WriteC();
		wdata.DelData(SearchCard.getText(),AllCards.getText());
	}

	private void SetText(String[] setdata) {
		if (setdata[10] != null) {
			setdata[10] = setdata[10].replace("\\n", "\n");
			for (int i = 0; i <= 10; i++) {
				setdata[i] = setdata[i].replace("null", "");
			}
		}
		HLname.setText(setdata[0]);
		HFname.setText(setdata[1]);
		KLname.setText(setdata[2]);
		KFname.setText(setdata[3]);
		Belongs.setText(setdata[4]);
		Position.setText(setdata[5]);
		Address.setText(setdata[6]);
		Email.setText(setdata[7]);
		Tell.setText(setdata[8]);
		Url.setText(setdata[9]);
		Remarks.setText(setdata[10]);
	}

	private void snb(int x) throws IOException {
		int CardNo = 0;
		ReadC read = new ReadC();
		AllCards.setText(read.read(0)[0]);
		Check c = new Check();
		CardNo = c.CheckNum(SearchCard.getText(), AllCards.getText(), x);
		if (CardNo != 0) {
			data = read.read(CardNo);
			SearchCard.setText(String.valueOf(CardNo));
			this.SetText(data);
			SetButton.setText("Edit");
		}
	}

}
