package application;

import java.io.*;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class WriteCsv {
	String csvPath = ".\\src\\resource\\list.csv";
	String readcsvline,substr;
	String[] ReadData;
	Integer i;

	void SetData(String[] CardData) throws IOException {
		substr="";
		if ((CardData[0] != null) && (CardData[1] != null)) {
			String CardDatax = CardData[0] + CardData[1];
			File Writefile = new File(csvPath);
			BufferedReader br = new BufferedReader(new FileReader(Writefile));
			String str;
			long loni;
			i = 0;
			str = br.readLine();
			while ((str = br.readLine()) != null) {
				ReadData = str.split(",");
				String ReadDatax = ReadData[0] + ReadData[1];
				System.out.println(CardDatax + " and " + ReadDatax + "->" + ReadDatax.compareTo(CardDatax));
				if (ReadDatax.compareTo(CardDatax) > 0) {
					System.out.println("1");
						System.out.println("2");
						substr=str;
						System.out.println("3");
						System.out.println(str);
					br.close();
					break;
				}
				i++;
			}
			System.out.println("i="+i);
			i = i + 1;
			RandomAccessFile RAF = new RandomAccessFile(Writefile, "rw");
			
			while (i > 0) {
				str = RAF.readLine();
				i = i - 1;
			}
			loni = RAF.getFilePointer();
			System.out.println(loni);
			RAF.seek(loni);
			substr="\n"+"\n"+substr;
			byte[] bytes = substr.getBytes();
			RAF.write(bytes);
			RAF.seek(loni);
			str =  CardData[0] + "," + CardData[1] + "," + CardData[2] + "," + CardData[3] + "," + CardData[4]
					+ "," + CardData[5] + "," + CardData[6] + "," + CardData[7] + "," + CardData[8] + "," + CardData[9]
					+ "," + CardData[10] + ",";
			System.out.println(str);
			bytes = str.getBytes();
			RAF.write(bytes);
			RAF.seek(0);
			str =String.valueOf(Integer.parseInt(CardData[11])+1);
			bytes = str.getBytes();
			RAF.write(bytes);
			
			RAF.close();
		} else {
			Alert alrt = new Alert(AlertType.ERROR);
			alrt.setTitle("メッセージ");
			alrt.setHeaderText("名前を設定してください");
			alrt.showAndWait();
		}
	}
}