package controller.command;

import controller.*;
import exceptions.*;

/**
 * ���������
 * 
 * ����������ģʽ�����Ǹ���ƣ�
 * 
 * @author lzlstyle
 * 
 */
public abstract class AbstractCommand {

	/**
	 * ִ��
	 */
	public abstract void execute() throws GameException;
}
