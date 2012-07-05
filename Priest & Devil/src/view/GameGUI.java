package view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.*;

import javax.swing.*;

import view.component.AudioPlayer;
import view.component.BackGroundGUI;
import view.component.BoatGUI;
import view.component.CmdArea;
import view.component.CmdGUI;
import view.component.Location;
import view.component.RoleGUI;
import view.component.TimeCalculateGUI;

import controller.CMDAnalysis;
import controller.PlayGameImpl;

import model.observer.ObservableImpl;
import model.role.*;
import controller.command.*;

/**
 * 
 * P&D��Ϸ��GUI����
 * 
 * @author lzlstyle
 * 
 */

public class GameGUI extends JFrame {

	/**
	 * priest��������
	 */
	private RoleGUI[] pLabel;

	/**
	 * devil��������
	 */
	private RoleGUI[] dLabel;

	/**
	 * ��
	 */
	private BoatGUI boatLabel;

	/**
	 * play
	 */
	private CmdGUI playLabel;

	/**
	 * go
	 */
	private CmdGUI goLabel;

	/**
	 * console��
	 */
	private static CmdArea cmdInputArea;

	public static void addInfo(String echo) {
		cmdInputArea.setText(cmdInputArea.getText() + "\n" + echo + "\n");
	}

	private TimeCalculateGUI timeRestLabel;

	public void setCmdOutputInfo(String info) {
		if (cmdInputArea.getText().length() == 0)
			cmdInputArea.setText("");
		this.cmdInputArea.setText(this.cmdInputArea.getText() + "\n" + info);
	}

	/**
	 * ����ͼ
	 */
	private BackGroundGUI backgroundImg;

	/**
	 * replay
	 */
	private CmdGUI replayLabel;

	/**
	 * over
	 */
	private CmdGUI overLabel;

	private AudioPlayer audioPlayer;

	private JPanel aboveJpanel;

	private JScrollPane jsp;

	// private JLabel cmdInputLine;
	/**
	 * �۲���ģ��
	 */
	private static ObservableImpl observableImpl = new ObservableImpl();

	public static ObservableImpl getObservableImpl() {
		return observableImpl;
	}

	public GameGUI(String name) {
		super(name);

		pLabel = new RoleGUI[3];
		dLabel = new RoleGUI[3];

		pLabel[0] = new RoleGUI("P1", 0, Location.Right_Bank_Role_1,
				new ImageIcon("src/view/img/rightPriests.png"), new ImageIcon(
						"src/view/img/leftPriests.png"));

		pLabel[1] = new RoleGUI("P2", 1, Location.Right_Bank_Role_2,
				new ImageIcon("src/view/img/rightPriests.png"), new ImageIcon(
						"src/view/img/leftPriests.png"));

		pLabel[2] = new RoleGUI("P3", 2, Location.Right_Bank_Role_3,
				new ImageIcon("src/view/img/rightPriests.png"), new ImageIcon(
						"src/view/img/leftPriests.png"));

		dLabel[0] = new RoleGUI("d1", 3, Location.Right_Bank_Role_4,
				new ImageIcon("src/view/img/rightDevils.png"), new ImageIcon(
						"src/view/img/leftDevils.png"));

		dLabel[1] = new RoleGUI("d2", 4, Location.Right_Bank_Role_5,
				new ImageIcon("src/view/img/rightDevils.png"), new ImageIcon(
						"src/view/img/leftDevils.png"));

		dLabel[2] = new RoleGUI("d3", 5, Location.Right_Bank_Role_6,
				new ImageIcon("src/view/img/rightDevils.png"), new ImageIcon(
						"src/view/img/leftDevils.png"));

		boatLabel = new BoatGUI("boat", new ImageIcon("src/view/img/boat.png"));

		playLabel = new CmdGUI("play", "play", new ImageIcon(
				"src/view/img/play.png"), new ImageIcon("src/view/img/go.png"));
		playLabel.setLocation(600, 350);
		playLabel.setSize(85, 85);

		goLabel = new CmdGUI("go", "go", new ImageIcon("src/view/img/go.png"),
				new ImageIcon("src/view/img/go.png"));
		goLabel.setLocation(350, 30);
		goLabel.setSize(85, 85);

		replayLabel = new CmdGUI("replay", "replay", new ImageIcon(
				"src/view/img/replay.png"), new ImageIcon(
				"src/view/img/replay.png"));
		replayLabel.setSize(85, 85);
		replayLabel.setLocation(350, 30);

		overLabel = new CmdGUI("over", "over", new ImageIcon(
				"src/view/img/gamefail.png"), new ImageIcon(
				"src/view/img/gamesuccess.png"));
		overLabel.setSize(340, 80);
		overLabel.setLocation(280, 140);

		// cmdInputLine = new JLabel();
		// cmdInputLine.setLocation(766,670);

		backgroundImg = new BackGroundGUI(new ImageIcon(
				"src/view/img/startWaiting.png"), new ImageIcon(
				"src/view/img/background.png"));

		backgroundImg.setSize(766, 460);
		// backgroundImg.setLocation(0,0);
		cmdInputArea = new CmdArea();

		cmdInputArea.setSize(730, 500);
		// cmdInputArea.setLocation(0, 500);
		// ��ֹˮƽ������
		cmdInputArea.setLineWrap(false);
		cmdInputArea.setAutoscrolls(true);
		// cmdInputArea.setEditable(false);

		jsp = new JScrollPane(cmdInputArea);
		jsp.setSize(770, 200);
		jsp.setLocation(0, 460);

		// jsp.setHorizontalScrollBarPolicy(
		// JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// jsp.setVerticalScrollBarPolicy(
		// JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		aboveJpanel = new JPanel();
		aboveJpanel.setSize(766, 460);
		aboveJpanel.setLocation(0, 0);

		timeRestLabel = new TimeCalculateGUI();
		timeRestLabel.setLocation(500, 30);
		timeRestLabel.setSize(200, 40);

		audioPlayer = new AudioPlayer();
		// timeRestLabel.setVisible(true);
		// timeRestLabel.setIcon(new ImageIcon("src/view/img/gamefail.png"));
		// ************************
		this.setSize(782, 700);

		this.setMaximizedBounds(new Rectangle(0, 0, 766, 500));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// *****************

		for (RoleGUI rb : pLabel) {
			this.getContentPane().add(rb);
			rb.setVisible(false);
		}

		for (RoleGUI rb : dLabel) {
			this.getContentPane().add(rb);
			rb.setVisible(false);
		}

		this.getContentPane().add(playLabel);
		this.getContentPane().add(goLabel);
		this.getContentPane().add(boatLabel);
		this.getContentPane().add(replayLabel);
		this.getContentPane().add(overLabel);
		this.getContentPane().add(jsp);
		this.getContentPane().add(timeRestLabel);
		aboveJpanel.add(backgroundImg);
		this.getContentPane().add(aboveJpanel);
		// this.getContentPane().add(cmdInputLine);
		// this.getContentPane().add(backgroundImg);
		this.setLayout(null);

		// ****************

		// ****************
		for (int i = 0; i < 3; i++) {
			this.observableImpl.Attach(pLabel[i]);
			this.observableImpl.Attach(dLabel[i]);
		}

		this.observableImpl.Attach(boatLabel);
		this.observableImpl.Attach(goLabel);
		this.observableImpl.Attach(overLabel);
		this.observableImpl.Attach(playLabel);
		this.observableImpl.Attach(replayLabel);
		this.observableImpl.Attach(timeRestLabel);
		this.observableImpl.Attach(backgroundImg);
		this.observableImpl.Attach(audioPlayer);
		this.observableImpl.Attach(cmdInputArea);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GameGUI("Priest VS Devil").setVisible(true);
		observableImpl.Notify();
	}

}
