package controller.command;

import controller.*;
import exceptions.*;

/**
 * go ����
 * 
 * @author lzlstyle
 * 
 */
public class GoCommand extends AbstractCommand {

	@Override
	public void execute() throws GameException {
		// TODO Auto-generated method stub
		PlayGameImpl.getInstance().go();
	}

}
