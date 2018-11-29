package application;

import java.io.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.*;

public class ReadCsv {

	int i;
	String str;
	String TarS;
	String[] ReadData;
	String csvPath = ".\\src\\resource\\list.csv";

	ReadCsv() {
		File file = new File(csvPath);
		if (file.exists()) {
		} else {
			try {
				file.createNewFile();
			} catch (IOException e) {
				Alert alrt = new Alert(AlertType.ERROR);
				alrt.setTitle("メッセージ");
				alrt.setHeaderText("ファイルに対する権限がありません");
				alrt.showAndWait();
			}
		}
	}// constructor

	String[] CsvData(Integer raw) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(csvPath)));
		i = 0;
		while (((str = br.readLine()) != null) && (i <= raw)) {
			ReadData = str.split(",");
			i++;
		}
		br.close();
		return ReadData;
	}

	String SetLabel() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(csvPath)));
		str = br.readLine();
		br.close();
		return str;
	}

	Integer FindSort(String searchword) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(csvPath)));
		br.readLine();
		i = 0;
		while ((str = br.readLine()) != null) {
			ReadData = str.split(",");
			TarS = ReadData[0] + ReadData[1];
			if ((searchword.compareTo(TarS)) < 0) {
				break;
			}
			i = i + 1;
		}
		br.close();
		return i;
	}

	String[] ReadSumLines(Integer where, Integer lines) throws IOException {
		int f=lines-where+1;
		i = 0;
		String[] LineData=new String[f];
		BufferedReader br = new BufferedReader(new FileReader(new File(csvPath)));
		while (i <= where) {
			br.readLine();
			i = i + 1;
		}
		while (((str = br.readLine()) != null) && (i <= lines)) {
			LineData[(i-where-1)]= str;
			i=i+1;
		}
		br.close();
		return LineData;
	}

}
