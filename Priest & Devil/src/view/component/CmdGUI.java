package view.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import view.GameGUI;

import model.observer.Observer;

import controller.CMDAnalysis;
import controller.PlayGameImpl;
import controller.command.GoCommand;
import controller.command.PlayCommand;
import model.role.*;

/**
 * 
 * ����CmdGUI�࣬���ڽ�������ʵ�֣��۲���;�����Ҫ��Ϊ�˸�һ�������ռ�ͳһʹ��
 * 
 * @author lzlstyle
 * 
 */
public class CmdGUI extends JLabel implements MouseListener, Observer {
	private String cmd;
	private ImageIcon nomalImg;
	private ImageIcon pressImg;

	public CmdGUI(String name, String cmd, ImageIcon nomalImg,
			ImageIcon pressImg) {
		super(name);
		this.setSize(40, 80);
		this.cmd = cmd;
		this.setBorder(null);
		this.addMouseListener(this);
		this.nomalImg = nomalImg;
		this.pressImg = pressImg;
		this.setIcon(nomalImg);

	}

	@Override
	public void mouseEntered(MouseEvent e) {

		// this.setIcon(pressImg);

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// this.setIcon(nomalImg);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// this.setIcon(pressImg);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (cmd.compareToIgnoreCase("play") == 0) {

			try {
				CMDAnalysis.analysis("play");
				GameGUI.addInfo(PlayGameImpl.getInstance().echo());
				// (new PlayCommand()).execute();
			} catch (Exception e1) {
				GameGUI.addInfo(e1.getMessage());
			}
			return;
		}

		if (cmd.compareToIgnoreCase("go") == 0) {
			try {
				CMDAnalysis.analysis("go");
				// (new GoCommand()).execute();
				GameGUI.addInfo(PlayGameImpl.getInstance().echo());
				// GameGUI.getObservableImpl().Notify();
			} catch (Exception e1) {
				GameGUI.addInfo(e1.getMessage());
			}
		}

		if (cmd.compareToIgnoreCase("replay") == 0) {
			try {
				CMDAnalysis.analysis("replay");
				// (new GoCommand()).execute();
				TimeCalculateGUI.setStart(false);
				GameGUI.addInfo(PlayGameImpl.getInstance().echo());
				// GameGUI.getObservableImpl().Notify();
			} catch (Exception e1) {
				GameGUI.addInfo(e1.getMessage());
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// this.setIcon(nomalImg);
	}

	@Override
	/*
	 * * ����roleλ�������Ϣ
	 */
	public void update() {

		if (cmd.compareToIgnoreCase("go") == 0) {
			if (PlayGameImpl.getInstance().getGameStatu() == GameStatu.playing)
				this.setVisible(true);
			else
				this.setVisible(false);

			return;
		}

		if (cmd.compareToIgnoreCase("over") == 0) {
			if (PlayGameImpl.getInstance().getGameStatu() == GameStatu.end) {
				this.setVisible(true);
				if (PlayGameImpl.getInstance().gameIsSuccess() == true) {
					this.setIcon(pressImg);
				} else
					this.setIcon(nomalImg);
			} else
				this.setVisible(false);

			return;
		}

		if (cmd.compareToIgnoreCase("play") == 0) {
			if (PlayGameImpl.getInstance().getGameStatu() == GameStatu.ready)
				this.setVisible(true);
			else
				this.setVisible(false);

			return;
		}

		if (cmd.compareToIgnoreCase("replay") == 0) {
			if (PlayGameImpl.getInstance().getGameStatu() == GameStatu.end)
				this.setVisible(true);
			else
				this.setVisible(false);

			return;
		}

	}
}
