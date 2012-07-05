package exceptions;

/**
 * ������
 * 
 * @author lzlstyle
 * 
 */
public class NoneInputException extends GameException {
	public NoneInputException() {
		this("\t\"Input is null.\"");
	}

	public NoneInputException(String paramString) {
		super(paramString);
	}
}
