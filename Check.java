package application;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Check {
	int CheckNum(String cardtext, String cardlabel, int x) {
//		x=0->search
//		x=1->plus
//		x=2->minus
//		text>label->false
//		text<label->null
//		x=2->minus
		try {
			int CardNo = Integer.parseInt(cardtext);
			int label = Integer.parseInt(cardlabel);
			if (x == 0) {
			} else if (x == 1) {
				CardNo = CardNo + 1;
			} else {
				CardNo = CardNo - 1;
			}
			if (CardNo <= 0) {
				return 1;
			} else if (CardNo > label) {
				return label;
			} else {
				return CardNo;
			}
		} catch (NumberFormatException e) {
			Alert alrt = new Alert(AlertType.ERROR);
			alrt.setTitle("ERROR");
			alrt.setHeaderText("”’l‚ğ“ü‚ê‚Ä‚­‚¾‚³‚¢");
			alrt.showAndWait();
			return 0;
		}

	}
}
