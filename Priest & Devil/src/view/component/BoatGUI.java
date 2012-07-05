package view.component;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import javax.swing.JLabel;

import model.observer.Observer;
import model.role.BoatStatu;
import model.role.GameStatu;

import controller.PlayGameImpl;

/**
 * 
 * ����BoatButton�࣬���ڽ�������ʵ�֣��۲���
 * 
 * @author lzlstyle
 * 
 */
public class BoatGUI extends JLabel implements MouseListener, Observer {

	private ImageIcon nomalImg;

	public BoatGUI(String name, ImageIcon nomalImg) {
		super(name);
		this.setSize(138, 40);
		this.setLocation(Location.Boat_On_Right);
		this.setBorder(null);
		this.addMouseListener(this);
		this.nomalImg = nomalImg;
		this.setIcon(nomalImg);
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
	/*
	 * * ����roleλ�������Ϣ
	 */
	public void update() {
		PlayGameImpl player = PlayGameImpl.getInstance();

		if (PlayGameImpl.getInstance().getGameStatu() == GameStatu.ready) {
			this.setVisible(false);
			return;
		} else
			this.setVisible(true);

		if (player.getBoat().getBoatStatu() == BoatStatu.onLeft) {
			this.setLocation(Location.Boat_On_Left);
			return;
		} else {
			if (player.getBoat().getBoatStatu() == BoatStatu.onRight) {
				this.setLocation(Location.Boat_On_Right);
				return;
			}
		}
		if (PlayGameImpl.getInstance().getGameStatu() == GameStatu.end)
			return;
	}
}
