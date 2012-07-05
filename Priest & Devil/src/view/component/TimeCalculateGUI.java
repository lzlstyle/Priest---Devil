package view.component;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

import view.GameGUI;

import controller.PlayGameImpl;

import model.observer.Observer;
import model.role.GameStatu;

/**
 * ��Ϸ�е���ʱ�۲���
 * 
 * @author lzlstyle
 * 
 */
public class TimeCalculateGUI extends JLabel implements MouseListener, Observer {

	// private int restTime;
	private static int totalTime = 60;
	private Timer t = new Timer();
	private MyTimer tt;
	private static boolean start;

	public static void setStart(boolean start1) {
		start = start1;
	}

	public TimeCalculateGUI() {
		// restTime = totalTime;

		PlayGameImpl player = PlayGameImpl.getInstance();
		// tt = new MyTimer(t,totalTime,this);
		start = false;

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

		if (PlayGameImpl.getInstance().getGameStatu() == GameStatu.ready) {
			this.setVisible(false);
			start = false;
		} else
			this.setVisible(true);

		if (PlayGameImpl.getInstance().getGameStatu() == GameStatu.playing
				&& start == false) {
			try {
				setText("Rest Time: " + 0);
				t.cancel();
			} catch (Exception e) {

			}
			t = new Timer();
			tt = new MyTimer(t, totalTime, this);
			t.scheduleAtFixedRate(tt, 0, 1000);
			this.start = true;
		}

		if (PlayGameImpl.getInstance().getGameStatu() == GameStatu.end) {
			setFont(new Font("Dialog", 1, 24));
			setForeground(Color.white);
			// setText("Rest Time: "+0);
			tt.cancel();
			this.start = false;
		}

	}
	
	/**
	 *  ��ʱ�����ڲ���
	 * 
	 * @author ziliu li
	 *
	 */
	 class MyTimer extends TimerTask {
		private Timer timer;
		private int time;
		private TimeCalculateGUI tcg;

		MyTimer(Timer timer, int time, TimeCalculateGUI tcg) {
			this.time = time;
			this.timer = timer;
			this.tcg = tcg;
		}

		public void run() {
			if (time > 0) {
				if (PlayGameImpl.getInstance().getGameStatu() != GameStatu.ready) {
					time--;
					tcg.setFont(new Font("Dialog", 1, 24));
					tcg.setForeground(Color.white);
					tcg.setText("Rest Time: " + time);
				}

			}

			if (this.time <= 0) {
				PlayGameImpl.getInstance().setGameStatu(GameStatu.end);
				GameGUI.getObservableImpl().Notify();
				tcg.setStart(false);
				this.timer.cancel();
			}

		}
	}

}
