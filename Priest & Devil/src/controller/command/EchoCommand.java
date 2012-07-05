package controller.command;
import controller.*;

/**
 * ״̬�������
 * 
 * @author lzlstyle
 *
 */
public class EchoCommand extends AbstractCommand {

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		PlayGameImpl.getInstance().echo();
	}

}
