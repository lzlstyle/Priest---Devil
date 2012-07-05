package model.role;

/**
 * ��Ϸ��ݽṹ
 * 
 * @author lzlstyle
 * 
 */
public class Game {
	/** �����ͼ�¼��Ϸ��״̬ */
	private GameStatu gameStatu;

	private Bank leftBank, /** �� */
	rightBank;
	/** �Ұ� */

	/** ��Ϸ�е�boat */
	private Boat boat = null;

	/**
	 * ��ȡ��Ϸ״̬
	 * 
	 * @return
	 */
	public GameStatu getGameStatu() {
		return gameStatu;
	}

	/**
	 * ��ȡ��Ϸ�е�����Ϣ
	 * 
	 * @return
	 */
	public Bank getLeftBank() {
		return leftBank;
	}

	/**
	 * ��ȡ��Ϸ�е��Ұ���Ϣ
	 * 
	 * @return
	 */
	public Bank getRightBank() {
		return rightBank;
	}

	/**
	 * ��ȡ��Ϸ�е�boat��Ϣ
	 * 
	 * @return
	 */
	public Boat getBoat() {
		return boat;
	}

	/**
	 * ����gameStatu
	 * 
	 * @param gameStatu
	 */
	public void setGameStatu(GameStatu gameStatu) {
		this.gameStatu = gameStatu;
	}

	/**
	 * �����󰶵���Ϣ
	 * 
	 * @param leftBank
	 */
	public void setLeftBank(Bank leftBank) {
		this.leftBank = leftBank;
	}

	/**
	 * �����Ұ�����Ϣ
	 * 
	 * @param rightBank
	 */
	public void setRightBank(Bank rightBank) {
		this.rightBank = rightBank;
	}

	/**
	 * ���ô���Ϣ
	 * 
	 * @param boat
	 */
	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	/**
	 * 
	 * ʵ�����
	 * 
	 * @param gameStatu
	 * @param leftBank
	 * @param rightBank
	 * @param boat
	 */
	public Game(GameStatu gameStatu, Bank leftBank, Bank rightBank, Boat boat) {
		this.gameStatu = gameStatu;
		this.leftBank = leftBank;
		this.rightBank = rightBank;
		this.boat = boat;
	}
}
