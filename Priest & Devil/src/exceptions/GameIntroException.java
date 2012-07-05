package exceptions;

/**
 * 
 * ��Ϸ������ʾ
 * 
 * @author lzlstyle
 * 
 */
public class GameIntroException extends GameException {
	public GameIntroException() {
		this(
				"\n\t**************************************IntrductionTips*******************************************"
						+ "\n\t\tThe program is A tricky puzzle game.\n"
						+ "\tYou have to get all the priests and devils to the other\n"
						+ "\tside of the lake, but the number of devils cannot out \n"
						+ "\tnumber the number of priests on either side or else the devil\n"
						+ "\twill kill the priest and the boat cannot travel empty.\n\n"
						+ "\tMore cmd for Game with HELP");
	}

	public GameIntroException(String paramString) {
		super(paramString);
	}
}
