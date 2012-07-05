package exceptions;

/**
 * ��Ϸ�˳�
 * 
 * @author lzlstyle
 * 
 */
public class GameExitException extends GameException {
	public GameExitException() {
		this("\t\"you had exit the Game. Good Bye!\"");
	}

	public GameExitException(String paramString) {
		super(paramString);
	}
}
