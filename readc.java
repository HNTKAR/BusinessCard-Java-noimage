package application;

import java.io.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;

public class ReadC {

	String str;
	String[] ReadData;
	String csvPath = ".\\src\\resource\\list.csv";

	ReadC() {
		File file = new File(csvPath);
		if (file.exists()) {
		} else {
			Alert alrt = new Alert(AlertType.ERROR);
			alrt.setTitle("メッセージ");
			alrt.setHeaderText("ファイルに対する権限がない、またはファイルが破損しています");
			alrt.showAndWait();
		}
	}// constructor

	String[] read(int raw) throws IOException {
		BufferedReader bread = new BufferedReader(new FileReader(new File(csvPath)));
		for (int i = 0; (((str = bread.readLine()) != null) && (i <= raw)); i++) {
			ReadData = str.split(",");
		}
		bread.close();
		return ReadData;
	}

	int sortnum(String searchword) throws IOException {
		int i = 0;
		BufferedReader bread = new BufferedReader(new FileReader(new File(csvPath)));
		bread.readLine();
		for (; (str = bread.readLine()) != null; i++) {
			ReadData = str.split(",");
			str = ReadData[0] + ReadData[1];
			if ((searchword.compareTo(str)) <= 0) {
				break;
			}
		}
		bread.close();
		return i;
	}

	String[] readstr(int linenum) throws IOException {
		String ReadData[];
		ReadData = new String[linenum];
		BufferedReader bread = new BufferedReader(new FileReader(new File(csvPath)));
		bread.readLine();
		for (int i = 0; i < linenum; i++) {
			ReadData[i] = bread.readLine();
		}
		bread.close();
		return ReadData;
	}
}
