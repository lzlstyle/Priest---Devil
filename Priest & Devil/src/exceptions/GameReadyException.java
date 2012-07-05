package exceptions;

/**
 * ��Ϸ׼��״̬
 * 
 * @author lzlstyle
 * 
 */
public class GameReadyException extends GameException {
	public GameReadyException() {
		this(
				"\t\"The game is ready ,please use command \" play\" to start playing game.\"");
	}

	public GameReadyException(String paramString) {
		super(paramString);
	}
}
