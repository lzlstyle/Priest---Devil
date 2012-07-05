package exceptions;

/**
 * ���ϵ�roleΪ���쳣
 * 
 * ���ϵ�roleΪ0�����ܽ���go����
 * 
 * @author lzlstyle
 * 
 */
public class BoatIsEmptyException extends GameException {

	public BoatIsEmptyException() {
		this("\t\"No people on boat!\"");
	}

	public BoatIsEmptyException(String paramString) {
		super(paramString);
	}
}
