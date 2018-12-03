package application;

import java.io.*;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

public class WriteC {
	String CsvPath = ".\\src\\resource\\list.csv";
	String CsvTempPath = ".\\src\\resource\\list.txt";
	String[] ReadData;
	int A, B, Line;

	void SetData(String[] CardData) throws IOException {
		File copyfile = new File(CsvTempPath);
		File truefile = new File(CsvPath);
		if ((CardData[0] != null) && (CardData[1] != null)) {

			String CardDatax = CardData[0] + CardData[1];
			ReadC read = new ReadC();
			A = read.sortnum(CardDatax);
			B = Integer.parseInt(CardData[12]);
			ReadData = read.readstr(Integer.parseInt(CardData[11]));
			for (int i = 0; i <= 10; i++) {
				if (CardData[i] != null && ((CardData[i]).length()) == 0) {
					System.out.println((CardData[i]).length());
					CardData[i] = CardData[i].replace("", "null");
				}
			}
			CardDatax = CardData[0] + "," + CardData[1] + "," + CardData[2] + "," + CardData[3] + "," + CardData[4]
					+ "," + CardData[5] + "," + CardData[6] + "," + CardData[7] + "," + CardData[8] + "," + CardData[9]
					+ "," + CardData[10] + ",";

			copyfile.createNewFile();

			PrintWriter Write = new PrintWriter(new BufferedWriter(new FileWriter(CsvTempPath, true)));
			Line = Integer.parseInt(CardData[11]);
			if (B == 0) {
				Write.println(Line + 1);
			} else {
				Write.println(Line);
			}
			System.out.println(A);
			System.out.println(B);
			System.out.println(Line);
			System.out.println("");

			for (int i = 0; i < Line; i++) {
				if (B == 0) {
					if (i == A) {
						Write.println(CardDatax);
					}
					Write.println(ReadData[i]);
				} else {
					if (i == A) {
						Write.println(CardDatax);
					}
					if (i == B - 1) {
					} else {
						Write.println(ReadData[i]);
					}
				}
			}
			if (A == Line) {
				Write.println(CardDatax);
			}
			Write.close();
			truefile.delete();
			copyfile.renameTo(truefile);
		} else

		{
			Alert alrt = new Alert(AlertType.ERROR);
			alrt.setTitle("メッセージ");
			alrt.setHeaderText("名前を設定してください");
			alrt.showAndWait();
		}
	}

	public void DelData(String DelLine, String AllCards) throws IOException {
		B = Integer.parseInt(DelLine);
		A = Integer.parseInt(AllCards);
		File copyfile = new File(CsvTempPath);
		File truefile = new File(CsvPath);
		System.out.println(A);
		System.out.println(B);
		if ((B > 0) && (A >= B) && (A >0)) {
			ReadC read = new ReadC();
			ReadData = read.readstr(A);
			ButtonType buttonA = new ButtonType("OK", ButtonData.OK_DONE);
			ButtonType buttonB = new ButtonType("STOP", ButtonData.CANCEL_CLOSE);
			Alert alert = new Alert(AlertType.CONFIRMATION, "本当に削除しますか？", buttonA, buttonB);
			Optional<ButtonType> result = alert.showAndWait();
			System.out.println(result.get().getButtonData());
			copyfile.createNewFile();
			if (result.get() == buttonA) {
				PrintWriter Write = new PrintWriter(new BufferedWriter(new FileWriter(CsvTempPath, true)));
				Write.println(A - 1);
				for (int i = 0; i < A; i++) {
					System.out.println(i);
					if (B != i + 1) {
						Write.println(ReadData[i]);
					}
				}
				Write.close();
				truefile.delete();
				copyfile.renameTo(truefile);
			} else {
			}

		} else {
			Alert alrt = new Alert(AlertType.ERROR);
			alrt.setTitle("ERROR");
			alrt.setHeaderText("その番号のデータは削除できません");
			alrt.showAndWait();
		}
	}

}