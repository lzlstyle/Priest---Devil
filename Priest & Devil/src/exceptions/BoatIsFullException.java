package exceptions;

/**
 * 
 * ���Ѿ������ٽ����ϴ�����
 * 
 * @author lzlstyle
 * 
 */
public class BoatIsFullException extends GameException {

	public BoatIsFullException() {
		this("\t\"Boat is full!\"");
	}

	public BoatIsFullException(String paramString) {
		super(paramString);
	}
}
