package controller.command;

import controller.*;
import exceptions.*;

/**
 * play����
 * 
 * @author lzlstyle
 * 
 */
public class PlayCommand extends AbstractCommand {

	@Override
	public void execute() throws GameException {
		PlayGameImpl.getInstance().play();
	}
}
