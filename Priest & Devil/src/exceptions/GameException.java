package exceptions;

/**
 * 
 * ��Ϸ���쳣�� ͨ���׳��쳣����ʽ��������û������������쳣
 * �������û�����ʾ�ǿ���ͨ��log����м�¼������ģ����������������ƿ��ܲ���þ��ں�����⼸�� �����иĳ��쳣�׳�-�����������ʽ���?
 * 
 * @author lzlstyle
 * 
 */
public class GameException extends Exception {

	public GameException() {
		this("\t\"Game general error.\"");
	}

	public GameException(String paramString) {
		super(paramString);
	}
}
