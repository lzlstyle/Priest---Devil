package controller.command;

import controller.*;
import exceptions.*;

/**
 * 
 * ������Ϸ����
 * 
 * @author lzlstyle
 * 
 */
public class ReplayCommand extends AbstractCommand {

	@Override
	public void execute() throws GameException {
		// TODO Auto-generated method stub
		PlayGameImpl.getInstance().rePlay();
	}

}
