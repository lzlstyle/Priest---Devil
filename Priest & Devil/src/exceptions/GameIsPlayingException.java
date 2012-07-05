package exceptions;

/**
 * 
 * ��Ϸ���ڽ�����
 * 
 * @author lzlstyle
 * 
 */
public class GameIsPlayingException extends GameException {
	public GameIsPlayingException() {
		this("\t\"Game is playing.\"");
	}

	public GameIsPlayingException(String paramString) {
		super(paramString);
	}
}
