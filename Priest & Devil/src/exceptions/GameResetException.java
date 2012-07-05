package exceptions;

/**
 * 
 * ��Ϸ����
 * 
 * @author lzlstyle
 * 
 */
public class GameResetException extends GameException {
	public GameResetException() {
		this("\t\"Game is reSeted.\"");
	}

	public GameResetException(String paramString) {
		super(paramString);
	}
}
