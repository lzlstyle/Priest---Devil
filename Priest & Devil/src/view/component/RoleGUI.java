package view.component;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import view.GameGUI;

import controller.CMDAnalysis;
import controller.PlayGameImpl;
import controller.command.BoardCommand;
import controller.command.DisembarkCommand;
import model.role.BoatStatu;
import model.role.Game;
import model.role.GameStatu;
import model.role.Priest;
import model.role.Role;
import model.observer.*;

/**
 * 
 * ����roleButton�࣬���ڽ�������ʵ�֣��۲���
 * 
 * @author lzlstyle
 * 
 */
public class RoleGUI extends JLabel implements MouseListener, Observer {
	private int number;

	private ImageIcon rightImg;
	private ImageIcon leftImg;

	public RoleGUI(String name, int number, Point location, ImageIcon nomalImg,
			ImageIcon pressImg) {
		super(name);

		this.setSize(36, 86);
		this.setLocation(location);

		this.number = number;
		this.setBorder(null);
		this.addMouseListener(this);
		this.rightImg = nomalImg;
		this.leftImg = pressImg;
		this.setIcon(nomalImg);
		this.setVisible(true);

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
		// this.setIcon(pressImg);

		PlayGameImpl player = PlayGameImpl.getInstance();

		for (Role r : player.getRightBank().getRolesAtBank()) {

			if (r != null && r.getPosition() == number) {
				// ��button ��λ���Ƶ��µ�λ��
				try {
					CMDAnalysis.analysis("board" + (number + 1));
					// (new BoardCommand(number+1)).execute();
					GameGUI.addInfo(player.echo());
					// GameGUI.getObservableImpl().Notify();
				} catch (Exception e1) {
					GameGUI.addInfo(e1.getMessage());
				}
				return;
			}
		}

		for (Role r : player.getLeftBank().getRolesAtBank()) {

			if (r != null && r.getPosition() == number) {
				// ��button ��λ���Ƶ��µ�λ��
				try {
					CMDAnalysis.analysis("board" + (number + 1));
					// (new BoardCommand(number+1)).execute();
					GameGUI.addInfo(player.echo());
					// GameGUI.getObservableImpl().Notify();
				} catch (Exception e1) {
					GameGUI.addInfo(e1.getMessage());
				}
				return;
			}
		}

		int start = 1;
		for (Role r : player.getBoat().getRolesAtBoat()) {

			if (r != null && r.getPosition() == number) {
				try {
					CMDAnalysis.analysis("disembark" + (start));
					// (new DisembarkCommand(start)).execute();
					GameGUI.addInfo(player.echo());
					// GameGUI.getObservableImpl().Notify();
				} catch (Exception e1) {
					GameGUI.addInfo(e1.getMessage());
				}
				return;
			}
			start++;
		}

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

		// ****�����Ϸ�������û�п�ʼ������role
		if (player.getGameStatu() == GameStatu.end) {
			if (player.gameIsSuccess() == false) {

				boolean inright = false;

				int pcount = 0, dcount = 0;
				// **********��������
				for (Role r : player.getRightBank().getRolesAtBank()) {
					if (r != null) {
						if (r instanceof Priest) {
							pcount++;
						} else
							dcount++;
					}
				}

				if (player.getBoat().getBoatStatu() == BoatStatu.onRight) {
					for (Role r : player.getBoat().getRolesAtBoat()) {
						if (r != null) {
							if (r instanceof Priest) {
								pcount++;
							} else
								dcount++;
						}
					}
				}

				if (pcount < dcount)
					inright = true;
				if (inright == true) {
					// ***********ִ��
					for (Role r : player.getRightBank().getRolesAtBank()) {
						if (r != null && r.getPosition() == number
								&& (r instanceof Priest)) {
							this.setIcon(new ImageIcon(
									"src/view/img/rightpriestsdie.png"));
							return;
							// break;
						}
					}
				} else {

					for (Role r : player.getLeftBank().getRolesAtBank()) {
						if (r != null && r.getPosition() == number
								&& (r instanceof Priest)) {
							this.setIcon(new ImageIcon(
									"src/view/img/leftpriestsdie.png"));
							return;
							// break;
						}
					}
				}
			}
			// return;
		}
		if (player.getGameStatu() == GameStatu.ready) {
			this.setVisible(false);
			return;
		}
		// else this.setVisible(true);

		// ***����
		for (Role r : player.getRightBank().getRolesAtBank()) {
			if (r != null && r.getPosition() == number) {
				this.setVisible(true);
				this.setIcon(rightImg);
				// ��button ��λ���Ƶ��µ�λ��
				switch (number) {
				case 0:
					this.setLocation(Location.Right_Bank_Role_1);
					return;
				case 1:
					this.setLocation(Location.Right_Bank_Role_2);
					return;
				case 2:
					this.setLocation(Location.Right_Bank_Role_3);
					return;
				case 3:
					this.setLocation(Location.Right_Bank_Role_4);
					return;
				case 4:
					this.setLocation(Location.Right_Bank_Role_5);
					return;
				case 5:
					this.setLocation(Location.Right_Bank_Role_6);
					return;
				default:
					return;
				}
			}
		}

		for (Role r : player.getLeftBank().getRolesAtBank()) {
			if (r != null && r.getPosition() == number) {
				this.setVisible(true);
				this.setIcon(leftImg);
				switch (number) {
				case 0:
					this.setLocation(Location.Left_Bank_Role_1);
					return;
				case 1:
					this.setLocation(Location.Left_Bank_Role_2);
					return;
				case 2:
					this.setLocation(Location.Left_Bank_Role_3);
					return;
				case 3:
					this.setLocation(Location.Left_Bank_Role_4);
					return;
				case 4:
					this.setLocation(Location.Left_Bank_Role_5);
					return;
				case 5:
					this.setLocation(Location.Left_Bank_Role_6);
					return;
				default:
					return;
				}
			}
		}
		int start = 1;
		for (Role r : player.getBoat().getRolesAtBoat()) {
			if (r != null && r.getPosition() == number) {
				this.setVisible(true);
				if (player.getBoat().getBoatStatu() == BoatStatu.onLeft) {
					switch (start) {
					case 1:
						this.setLocation(Location.Boat_On_Left_Role_1);
						return;
					case 2:
						this.setLocation(Location.Boat_On_Left_Role_2);
						return;

					}
				}
				if (player.getBoat().getBoatStatu() == BoatStatu.onRight) {
					this.setVisible(true);
					switch (start) {
					case 1:
						this.setLocation(Location.Boat_On_Right_Role_1);
						return;
					case 2:
						this.setLocation(Location.Boat_On_Right_Role_2);
						return;

					}
				}
			}
			start++;
		}
	}
}
