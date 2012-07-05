package exceptions;

/**
 * ��Ϸ����
 * 
 * @author lzlstyle
 * 
 */
public class GameIsOverException extends GameException {
	public GameIsOverException() {
		this("\t\"Game is over.\"");
	}

	public GameIsOverException(String paramString) {
		super(paramString);
	}
}
