package exceptions;

import controller.PlayGameImpl;

/**
 * ��Ϸ״̬
 * 
 * @author lzlstyle
 * 
 */
public class EchoGameStatuException extends GameException {
	public EchoGameStatuException() {
		this(PlayGameImpl.getInstance().echo());
	}

	public EchoGameStatuException(String paramString) {
		super(paramString);
	}
}
