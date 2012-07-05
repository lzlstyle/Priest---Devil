package exceptions;

/**
 * 
 * ����������
 * 
 * @author lzlstyle
 * 
 */
public class ParamOutOfRangeException extends GameException {
	public ParamOutOfRangeException() {
		this("\t\"param is out of Range.\"");
	}

	public ParamOutOfRangeException(String paramString) {
		super(paramString);
	}
}
