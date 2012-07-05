package controller.command;

import controller.*;
import exceptions.*;

/**
 * �ϴ�����
 * 
 * @author lzlstyle
 * 
 */
public class BoardCommand extends AbstractCommand {

	private int functionParam;
	private boolean hasParam;
	
	/**
	 * ����ѡ��Ĭ�϶����ϴ���������� 
	 */
	public BoardCommand() {

		this.functionParam = 0;
		this.hasParam = false;
	}

	/**
	 * ����ѡ���param��������ϴ����������
	 * @param param
	 */
	public BoardCommand(int param) {

		this.functionParam = param;
		this.hasParam = true;
	}

	@Override
	public void execute() throws GameException {
		// TODO Auto-generated method stub
		if (hasParam == false)
			PlayGameImpl.getInstance().board();
		else
			PlayGameImpl.getInstance().board(functionParam);
	}

}
