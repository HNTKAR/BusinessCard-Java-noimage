package application;

public class Check {
	public Boolean CheckNum(String text, Integer label, Integer x) {
//		x=0->search
//		x=1->plus
//		x=2->minus
//		text>label->false
//		text<label->null
//		x=2->minus
		try {
			int CardNo = Integer.parseInt(text);
			if (x == 0) {
			} else if (x == 1) {
				CardNo = CardNo + 1;
			} else {
				CardNo = CardNo - 1;
			}
			if (CardNo <= 0) {
				return null;
			} else if (CardNo > label) {
				return false;
			} else {
				return true;
			}
		} catch (NumberFormatException e) {
			return false;
		}

	}
}
