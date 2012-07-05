package controller;

import view.GameGUI;
import view.component.TimeCalculateGUI;
import model.role.GameStatu;
import exceptions.*;

/**
 * �����û������룬����ݲ�ͬ�������ȡ���õĴ�ʩ,�����д���ӿ�
 * 
 * @author lzlstyle
 * 
 */
public class CMDAnalysis {

	/**
	 * �����û������벢ִ����Ӧ�Ķ���
	 * 
	 * @param str
	 * 
	 */
	public static void analysis(String str) throws GameException {

		PlayGameImpl player = PlayGameImpl.getInstance();

		str = str.trim().replace(" ", "").toLowerCase();

		if (str.compareTo("") == 0)
			throw new NoneInputException();

		if (player.getGameStatu() == GameStatu.end
				&& str.compareTo("echo") != 0 && str.compareTo("replay") != 0
				&& str.compareTo("reset") != 0 && str.compareTo("exit") != 0
				&& str.compareTo("h") != 0 && str.compareTo("help") != 0
				&& str.compareTo("play") != 0) {
			throw new GameIsOverException();

		}

		if (player.getGameStatu() == GameStatu.ready
				&& str.compareTo("exit") != 0 && str.compareTo("h") != 0
				&& str.compareTo("help") != 0 && str.compareTo("play") != 0) {
			throw new GameReadyException();
		}

		boolean flag = false;
		// ȥ���ո�,��ȫ��ת��Сд
		boolean exitGame = false;

		if (str.compareTo("go") == 0) {
			flag = player.go();
			if (flag == true && player.gameIsOver() == true) {
				player.setGameStatu(GameStatu.end);
				GameGUI.getObservableImpl().Notify();
				throw new EchoGameStatuException(player.echoStep(1) + "\n"
						+ player.echo() + "\n"
						+ (new GameIsOverException()).getMessage());
			}
			flag = false;

			if (player.gameIsOver()) {
				throw new GameIsOverException();
			}

			GameGUI.getObservableImpl().Notify();
			return;
		}

		if (str.compareTo("echo") == 0) {
			if (player.getGameStatu() == GameStatu.end) {
				throw new GameIsOverException();
			}
		}

		if (str.indexOf("board") != -1) {
			// board����ļ�������Ĵ���
			// Ĭ�ϲ������
			if (str.length() == 5) {
				flag = player.board();
				GameGUI.getObservableImpl().Notify();
				return;
			} else {
				if (str.length() == 6
						&& Character.isDigit(str.charAt(5)) == true) {
					int position = Integer.parseInt("" + str.charAt(5));
					// System.out.println(position);
					flag = player.board(position);
					GameGUI.getObservableImpl().Notify();
					return;
				} else
					throw new IlleagalCommandException();
			}
		}

		if (str.indexOf("disembark") != -1) {
			// disembark����ļ�������Ĵ���
			// Ĭ�ϲ������
			if (str.length() == 9) {
				flag = player.disembark();
				if (player.gameIsSuccess() == true) {
					player.setGameStatu(GameStatu.end);
				}
				GameGUI.getObservableImpl().Notify();
				return;
			} else {
				if (str.length() == 10
						&& Character.isDigit(str.charAt(9)) == true) {
					int position = Integer.parseInt("" + str.charAt(9));
					flag = player.disembark(position);
					if (player.gameIsSuccess() == true) {
						player.setGameStatu(GameStatu.end);
					}
					GameGUI.getObservableImpl().Notify();
					return;
				} else
					throw new IlleagalCommandException();
			}

		}

		if (str.compareTo("play") == 0) {

			if (player.getGameStatu() == GameStatu.playing) {
				flag = false;

				throw new GameIsPlayingException();
			} else if (player.getGameStatu() == GameStatu.ready) {
				player.play();
				player.setGameStatu(GameStatu.playing);
				GameGUI.getObservableImpl().Notify();
				return;
			}
		}

		if (str.compareTo("replay") == 0) {
			player.rePlay();
			flag = true;
			TimeCalculateGUI.setStart(false);
			GameGUI.getObservableImpl().Notify();
			return;
		}

		if (str.compareTo("reset") == 0) {
			if (player.getGameStatu() != GameStatu.playing)
				throw new GameIsOverException();
			player.reSet();
			flag = true;
			TimeCalculateGUI.setStart(false);
			GameGUI.getObservableImpl().Notify();
			return;
		}

		if (str.compareTo("help") == 0 || str.compareTo("h") == 0)
			throw new HelpTipsException();

		if (str.compareTo("exit") == 0) {
			player.init();
			throw new GameExitException();
		}

		if (str.compareTo("introduciotn") == 0 || str.compareTo("intro") == 0)
			throw new GameIntroException();
		else
			throw new IlleagalCommandException();
		// return exitGame;
	}
}
