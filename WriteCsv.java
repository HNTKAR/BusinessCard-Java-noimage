package application;

import java.io.*;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class WriteCsv {
	String csvPath = ".\\src\\resource\\list.csv";
	String csvTempPath = ".\\src\\resource\\list.txt";
	String[] ReadData;
	int nums;
	int readlong = 2;

	void SetData(String[] CardData) throws IOException {
		if ((CardData[0] != null) && (CardData[1] != null)) {
			String CardDatax = CardData[0] + CardData[1];
			File copyfile = new File(csvTempPath);
			File truefile = new File(csvPath);
			ReadCsv Rcsv = new ReadCsv();
			copyfile.createNewFile();
			PrintWriter Write = new PrintWriter(new BufferedWriter(new FileWriter(csvTempPath, true)));
			Write.println(Integer.parseInt(CardData[11]) + 1);
			nums = Integer.parseInt(CardData[11]) + 1;
			Write.close();
			int line = Rcsv.FindSort(CardDatax);
			int comx = (line / readlong);
			int comy = comx;
			CardDatax = CardData[0] + "," + CardData[1] + "," + CardData[2] + "," + CardData[3] + "," + CardData[4]
					+ "," + CardData[5] + "," + CardData[6] + "," + CardData[7] + "," + CardData[8] + "," + CardData[9]
					+ "," + CardData[10];
			if (line > 0) {
				while (comx > 0) {
					CardData = Rcsv.ReadSumLines(((comy - comx) * readlong), ((comy - comx + 1) * readlong));
					PrintWriter Writes = new PrintWriter(new BufferedWriter(new FileWriter(csvTempPath, true)));
					for (int x = 0; x < readlong; x++) {
						Writes.println(CardData[x]);
					}
					Writes.close();
					comx = comx - 1;
				}
				CardData = Rcsv.ReadSumLines((comy * readlong), line);
				PrintWriter Writes = new PrintWriter(new BufferedWriter(new FileWriter(csvTempPath, true)));
				for (int x = 0; x < (line % readlong); x++) {
					Writes.println(CardData[x]);
				}
				Writes.println(CardDatax);
				Writes.close();
			}
			for (int i = 0; i < ((nums - line) / readlong); i++) {
				CardData = Rcsv.ReadSumLines((line + readlong * i), (line + readlong * (i + 1)));
				PrintWriter Writes = new PrintWriter(new BufferedWriter(new FileWriter(csvTempPath, true)));
				for (int x = 0; x < readlong; x++) {
					Writes.println(CardData[x]);
				}
				Writes.close();
			}
			for (int i = 0; i < (((nums - line) % readlong) - 1); i++) {
				CardData = Rcsv.ReadSumLines((((nums - line) / readlong) * readlong), nums);
				PrintWriter Writes = new PrintWriter(new BufferedWriter(new FileWriter(csvTempPath, true)));
				for (int x = 0; x < ((nums - line) % readlong); x++) {
					Writes.println(CardData[x]);
				}
				Writes.close();
			}
			truefile.delete();
			copyfile.renameTo(truefile);
		} else {
			Alert alrt = new Alert(AlertType.ERROR);
			alrt.setTitle("メッセージ");
			alrt.setHeaderText("名前を設定してください");
			alrt.showAndWait();
		}
	}

}