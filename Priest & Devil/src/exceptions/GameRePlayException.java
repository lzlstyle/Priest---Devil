package exceptions;

/**
 * 
 * ��Ϸ����
 * 
 * @author lzlstyle
 * 
 */
public class GameRePlayException extends GameException {
	public GameRePlayException() {
		this("\t\"Game is rePlayed.\"");
	}

	public GameRePlayException(String paramString) {
		super(paramString);
	}
}
