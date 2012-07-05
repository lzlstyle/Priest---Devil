package exceptions;

/**
 * �Ƿ������쳣
 * 
 * @author lzlstyle
 * 
 */
public class IlleagalCommandException extends GameException {

	public IlleagalCommandException() {
		this("\t\"Illeagal Command.\"");
	}

	public IlleagalCommandException(String paramString) {
		super(paramString);
	}
}
