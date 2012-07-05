package exceptions;

/**
 * 
 * �׳���Ϸ������ʾ
 * 
 * @author lzlstyle
 * 
 */
public class HelpTipsException extends GameException {
	public HelpTipsException() {
		this(
				"\n\t 1) go:  set boat"
						+ "\n\t 2) echo: output the current status"
						+ "\n\t 3) play: start the game"
						+ "\n\t 4) replay: replay the game"
						+ "\n\t 5) reset: reset the statu of the game"
						+ "\n\t 6) board n/board: (n is a digital from 1 to 6) means chose the No.n role to the board"
						+ "\n\t   or just use commad \"board\" ,it means the nearest role to the boat will be chosed.  "
						+ "\n\t 7) disembark n/board:(n is a digital from 1 to 2)means chose the NO.n role from the boat back to bank"
						+ "\n\t   or just use commad \"disembark\" ,it means the nearest role to the bank will be chosed."
						+ "\n\t 8) help/h: help of the game"
						+ "\n\t 9) introduction/intro: display introduction of the game"
						+ "\n\t 10) exit: end the game"
						+ "\n\n\t *Attention��the command case insensitive.");

	}

	public HelpTipsException(String paramString) {
		super(paramString);
	}
}
