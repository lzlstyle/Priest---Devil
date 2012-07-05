package view.component;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextArea;

import view.GameGUI;

import controller.CMDAnalysis;
import controller.PlayGameImpl;
import exceptions.GameExitException;
import exceptions.NoneInputException;

import model.observer.Observer;

/**
 * ��Ϸ��������۲���
 * 
 * @author lzlstyle
 * 
 */
public class CmdArea extends JTextArea implements MouseListener, Observer {
	private int inputLength;
	private String aheadContent;
	private int lineCount;

	public CmdArea() {
		this
				.setText("*********************Priest & Devil Game CMD Interface**************\n\n"
						+ "Welcome to Priest & Devil Game.\n\thelp/h for help tips.\n\n");
		addKeyListener(new KeyBoardEvent());
		this.inputLength = 0;
		aheadContent = this.getText();
		lineCount = this.getLineCount();
		setCursor();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// setCursor();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// setCursor();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// setCursor();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// setCursor();
	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	private void setCursor() {

		if (this.getLineCount() < lineCount) {
			setText(aheadContent);
		}

		this.setSelectionStart(this.getText().length());
		this.setSelectionEnd(this.getText().length());

	}

	@Override
	public void update() {

	}

	private class KeyBoardEvent implements KeyListener {

		public void keyPressed(KeyEvent event) {
			setCursor();
			if (event.getKeyChar() == 8) {
				setCursor();
				if (inputLength > 0) {
					inputLength--;
					if (inputLength == 0)
						setText(aheadContent);
					setCursor();
				}

				if (getText().length() <= aheadContent.length()) {
					setText(aheadContent);
					setVisible(true);
				}
			} else
				inputLength++;

			if (event.getKeyCode() == KeyEvent.VK_ENTER) {
				String cmd = getText().substring(getText().lastIndexOf("\n"),
						getText().length());
				cmd = getText().substring(getText().lastIndexOf("\n"),
						getText().length());
				inputLength = 0;
				try {
					CMDAnalysis.analysis(cmd);
					setText(getText() + "\n"
							+ PlayGameImpl.getInstance().echo() + "\n");
				} catch (Exception e1) {
					if (e1 instanceof NoneInputException) {

					} else
						setText(getText() + "\n" + e1.getMessage() + "\n");
					if (e1 instanceof GameExitException) {
						GameGUI.getObservableImpl().Notify();
					}
				} finally {
					aheadContent = getText();
					lineCount = getLineCount();
				}

			}

		}

		public void keyTyped(KeyEvent event) {
			setCursor();
			// System.out.println((int)event.getKeyChar());
		}

		public void keyReleased(KeyEvent event) {
			setCursor();
		}

	}

}
