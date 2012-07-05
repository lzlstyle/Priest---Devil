package controller.command;

import controller.*;
import exceptions.*;

/**
 * �´�����
 * 
 * @author lzlstyle
 * 
 */
public class DisembarkCommand extends AbstractCommand {

	private int functionParam;
	private boolean hasParam;

	/**
	 * ����Ĭ���ƶ������´�������
	 */
	public DisembarkCommand() {

		this.functionParam = 0;
		hasParam = false;
	}

	/**
	 * ����Ҫ�ƶ���param�������´�������
	 * @param param
	 */
	public DisembarkCommand(int param) {

		this.functionParam = param;
		hasParam = true;
	}

	@Override
	public void execute() throws GameException {
		// TODO Auto-generated method stub
		if (hasParam == false)
			PlayGameImpl.getInstance().disembark();
		else
			PlayGameImpl.getInstance().disembark(functionParam);
	}

}
