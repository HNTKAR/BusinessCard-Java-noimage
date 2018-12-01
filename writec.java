package application;

import java.io.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class writec {
	String csvPath = ".\\src\\resource\\list.csv";
	String csvTempPath = ".\\src\\resource\\list.txt";
	String[] ReadData;
	int anum, bnum, line, i;

	void SetData(String[] CardData) throws IOException {
		File copyfile = new File(csvTempPath);
		File truefile = new File(csvPath);
		if ((CardData[0] != null) && (CardData[1] != null)) {

			String CardDatax = CardData[0] + CardData[1];
			readc read = new readc();
			anum = read.sortnum(CardDatax);
			bnum = Integer.parseInt(CardData[12]);
			ReadData = read.readstr(Integer.parseInt(CardData[11]));
			CardDatax = CardData[0] + "," + CardData[1] + "," + CardData[2] + "," + CardData[3] + "," + CardData[4]
					+ "," + CardData[5] + "," + CardData[6] + "," + CardData[7] + "," + CardData[8] + "," + CardData[9]
					+ "," + CardData[10];

			copyfile.createNewFile();

			PrintWriter Write = new PrintWriter(new BufferedWriter(new FileWriter(csvTempPath, true)));
			line = Integer.parseInt(CardData[11]);
			if (bnum == 0) {
				Write.println(line + 1);
			} else {
				Write.println(line);
			}
			System.out.println(anum);
			System.out.println(bnum);
			System.out.println(line);
			System.out.println("");

			for (i = 0; i < line; i++) {
				if (bnum == 0) {
					if (i == anum) {
						Write.println(CardDatax);
					}
					Write.println(ReadData[i]);
				} else {
					if (i == anum) {
						Write.println(CardDatax);
					}
					if (i == bnum - 1) {
					} else {
						Write.println(ReadData[i]);
					}
				}
			}
			if (anum == line) {
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

}