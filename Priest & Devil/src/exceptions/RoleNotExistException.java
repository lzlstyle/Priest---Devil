package exceptions;

/**
 * 
 * ��ʾ��Ӧ��λ����û��role
 * 
 * @author lzlstyle
 * 
 */
public class RoleNotExistException extends GameException {

	public RoleNotExistException() {
		this("\t\"Role do not exist.\"");
	}

	public RoleNotExistException(String paramString) {
		super(paramString);
	}
}
