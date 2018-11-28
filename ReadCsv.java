package application;

import java.io.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;

public class ReadCsv {

	int i = 0;
	String TarNumS;
	String[] ReadData;
	String csvPath=".\\src\\resource\\list.csv";
	ReadCsv() {
		File file = new File(csvPath);
		if (file.exists()) {
		} else {
			File nofile = new File(csvPath);
			try {
				nofile.createNewFile();
			} catch (IOException e) {
				Alert alrt = new Alert(AlertType.ERROR);
				alrt.setTitle("メッセージ");
				alrt.setHeaderText("ファイルに対する権限がありません");
				alrt.showAndWait();
			}
		}
	}//constructor

	String[] CsvData(Integer raw) throws IOException {
		File file = new File(csvPath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str;
		i = 0;
		while (((str = br.readLine()) != null) && (i <= raw)) {
			ReadData = str.split(",");
			i++;
		}
		br.close();
		return ReadData;
	}

	String SetLabel() throws IOException {
		File file = new File(csvPath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String str;
		str = br.readLine();
		br.close();
		return str;
	}
	
}
