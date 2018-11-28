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
	private Button Startbutton;
	@FXML
	private Label AllCards;
	@FXML
	private Label StartLabel;

	@FXML
	protected void search(ActionEvent evt) throws IOException {
		int ACards = Integer.valueOf(AllCards.getText());
		int CardNo = 0;
		Check c = new Check();
		Boolean x = c.CheckNum(SearchCard.getText(), ACards, 0);
		if (x == null) {
			CardNo = 1;
		} else if (x) {
			CardNo = Integer.parseInt(SearchCard.getText());
		} else {
			CardNo = ACards;
		}
		ReadCsv csvread = new ReadCsv();
		data = csvread.CsvData(CardNo);
		String SCardNo = String.valueOf(CardNo);
		SearchCard.setText(SCardNo);
		this.SetText(data);
	}

	@FXML
	protected void Set(ActionEvent evt) {
		System.out.println("SETÅI");
	}

	@FXML
	protected void Back(ActionEvent evt) throws IOException {
		int ACards = Integer.valueOf(AllCards.getText());
		int CardNo = 0;
		Check c = new Check();
		Boolean x = c.CheckNum(SearchCard.getText(), ACards, 2);
		if (x == null) {
			CardNo = 1;
		} else if (x) {
			CardNo = Integer.parseInt(SearchCard.getText()) - 1;
		} else {
			CardNo = ACards;
		}
		ReadCsv csvread = new ReadCsv();
		data = csvread.CsvData(CardNo);
		String SCardNo = String.valueOf(CardNo);
		SearchCard.setText(SCardNo);
		this.SetText(data);
	}

	@FXML
	protected void Next(ActionEvent evt) throws IOException {
		int ACards = Integer.valueOf(AllCards.getText());
		int CardNo = 0;
		Check c = new Check();
		Boolean x = c.CheckNum(SearchCard.getText(), ACards, 1);
		if (x == null) {
			CardNo = 1;
		} else if (x) {
			CardNo = Integer.parseInt(SearchCard.getText()) + 1;
		} else {
			CardNo = ACards;
		}
		ReadCsv csvread = new ReadCsv();
		data = csvread.CsvData(CardNo);
		String SCardNo = String.valueOf(CardNo);
		SearchCard.setText(SCardNo);
		this.SetText(data);
	}

	@FXML
	protected void Start(ActionEvent evt) throws IOException {
		ReadCsv csvread = new ReadCsv();
		data = csvread.CsvData(1);
		SearchCard.setText("1");
		this.SetText(data);
		AllCards.setText(csvread.SetLabel());
		Startbutton.setVisible(false);
		StartLabel.setVisible(false);
	}

	private void SetText(String[] setdata) {
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

}
