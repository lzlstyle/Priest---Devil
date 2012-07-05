package view.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import model.observer.Observer;
import model.role.GameStatu;

import controller.PlayGameImpl;

/**
 * ��Ϸ�����۲���
 * 
 * @author lzlstyle
 * 
 */
public class BackGroundGUI extends JLabel implements MouseListener, Observer {

	// private int restTime;
	private ImageIcon startWaitingImg;
	private ImageIcon playingImg;

	public BackGroundGUI(ImageIcon waitingImg, ImageIcon playingImg) {
		this.startWaitingImg = waitingImg;
		this.playingImg = playingImg;
		this.setIcon(startWaitingImg);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void update() {
		if (PlayGameImpl.getInstance().getGameStatu() == GameStatu.ready)
			this.setIcon(this.startWaitingImg);
		else
			this.setIcon(this.playingImg);
	}
}