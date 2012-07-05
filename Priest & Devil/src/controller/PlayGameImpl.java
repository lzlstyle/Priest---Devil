package controller;

import java.util.ArrayList;

import model.role.Bank;
import model.role.Boat;
import model.role.BoatStatu;
import model.role.Devil;
import model.role.GameStatu;
import model.role.Priest;
import model.role.Role;
import exceptions.*;

/**
 * ��Ϸ����ʵ����
 * 
 * @author lzlstyle
 * 
 */
public class PlayGameImpl {

	private static PlayGameImpl instance = null;

	/** �����ͼ�¼��Ϸ��״̬ */
	private GameStatu gameStatu;

	private Bank leftBank, /** �� */
	rightBank;
	/** �Ұ� */

	/** ��Ϸ�е�boat */
	private Boat boat;

	public Bank getLeftBank() {
		return leftBank;
	}

	public void setLeftBank(Bank leftBank) {
		this.leftBank = leftBank;
	}

	public Bank getRightBank() {
		return rightBank;
	}

	public void setRightBank(Bank rightBank) {
		this.rightBank = rightBank;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	public GameStatu getGameStatu() {
		return gameStatu;
	}

	public void setGameStatu(GameStatu gameStatu) {
		this.gameStatu = gameStatu;
	}

	/**
	 * ��ֹ������
	 */
	private PlayGameImpl() {
		init();
	}

	/**
	 * ���ܣ���ʼ��Ϸ
	 * 
	 */
	public void play() {
		gameStatu = GameStatu.playing;
	}

	/**
	 * ����boat����Ϣ
	 * 
	 * @return
	 */
	public Boat getBoat() {
		return this.boat;
	}

	/**
	 * ���ܣ����³�ʼ����Ϸ״̬
	 * 
	 * @throws GameException
	 */
	public void reSet() throws GameException {
		init();
		gameStatu = GameStatu.playing;
		// throw new GameResetException();
	}

	/**
	 * ���ܣ�������Ϸ
	 * 
	 * @throws GameException
	 */
	public void rePlay() throws GameException {
		init();
		gameStatu = GameStatu.playing;
		// throw new GameRePlayException();
	}

	/**
	 * ���ܣ�ѡ��λ�ڰ���positionλ���ϵ�role�밶�Ǵ�
	 * 
	 * @param position
	 *            int���ͣ�position belong to [1-6]
	 * @return boolean ����role��¼�ɹ����������Ӧ�Ĳ���������true�����򷵻�false
	 * @throws GameException
	 */
	public boolean board(int position) throws GameException {
		boolean success = false;
		if (boat.getBoatStatu() == BoatStatu.onLeft)
			success = GameRule.boardCmdRule(boat, leftBank, position - 1);
		else
			success = GameRule.boardCmdRule(boat, rightBank, position - 1);

		return success;
	}

	/**
	 * ���ܣ�Ĭ������£�������Ӧ��role�밶�Ǵ�
	 * 
	 * @return boolean ����role��¼�ɹ����������Ӧ�Ĳ���������true�����򷵻�false
	 * @throws GameException
	 */
	public boolean board() throws GameException {
		boolean success = false;
		if (boat.getBoatStatu() == BoatStatu.onLeft)
			success = GameRule.boardCmdRule(boat, leftBank);
		else
			success = GameRule.boardCmdRule(boat, rightBank);
		return success;
	}

	/**
	 * ���ܣ�ѡ��λ�ڴ�positionλ�õ�role�´��ϰ�
	 * 
	 * @param position
	 *            int���ͣ�position belong to [1-4]
	 * @return boolean ����role�´��ɹ����������Ӧ�Ĳ���������true�����򷵻�false
	 * @throws GameException
	 */
	public boolean disembark(int position) throws GameException {
		boolean success = false;
		if (boat.getBoatStatu() == BoatStatu.onLeft)
			success = GameRule.disembarkCmdRule(boat, leftBank, position - 1);
		else
			success = GameRule.disembarkCmdRule(boat, rightBank, position - 1);

		return success;
	}

	/**
	 * ���ܣ�Ĭ������£�������Ӧ��role�´��ϰ�
	 * 
	 * @return boolean ����role�´��ɹ����������Ӧ�Ĳ���������true�����򷵻�false
	 * @throws GameException
	 */
	public boolean disembark() throws GameException {
		boolean success = false;
		if (boat.getBoatStatu() == BoatStatu.onLeft)
			success = GameRule.disembarkCmdRule(boat, leftBank);
		else
			success = GameRule.disembarkCmdRule(boat, rightBank);
		return success;
	}

	/**
	 * ���ܣ�����
	 * 
	 * @return boolean ��������Ͽ�������������false;����ִ����Ӧ�Ĳ���������true
	 * @throws GameException
	 */
	public boolean go() throws GameException {
		boolean success = false;
		success = GameRule.goCmdRule(boat, leftBank, rightBank);
		return success;
	}

	/**
	 * ���ܣ�������Ϸ��ǰ��״̬
	 * 
	 * @return string -��ʾ״̬����Ϣ
	 * @throws GameException
	 */
	public String echo() {
		StringBuffer result = new StringBuffer();
		for (Role r : leftBank.getRolesAtBank()) {
			if (r instanceof Priest) {
				result.append('P');
			} else {
				if (r instanceof Devil) {
					result.append('D');
				} else
					result.append('O');
			}
		}
		if (boat.getBoatStatu() == BoatStatu.onLeft)
			result.append("|");
		else
			result.append("\\");

		for (Role r : boat.getRolesAtBoat()) {
			if (r instanceof Priest) {
				result.append('P');
			} else {
				if (r instanceof Devil) {
					result.append('D');
				} else
					result.append('O');
			}
		}

		if (boat.getBoatStatu() == BoatStatu.onRight)
			result.append("|");
		else
			result.append("/");

		for (Role r : rightBank.getRolesAtBank()) {
			if (r instanceof Priest) {
				result.append('P');
			} else {
				if (r instanceof Devil) {
					result.append('D');
				} else
					result.append('O');
			}
		}

		if (boat.getBoatStatu() == BoatStatu.onLeft)
			result.insert(9, "OO");
		else
			result.insert(7, "OO");
		return new String("\t\"" + result + "\"");
	}

	/**
	 * ���ܣ���ȡ����һ��һ���ƶ���״̬
	 * 
	 * @param step
	 *            ��Χ1-2����ʾnum��ʾ�ƶ��ĵڼ���
	 * @return string -��ʾ״̬����Ϣ,���������null
	 * @throws GameException
	 */
	public String echoStep(int step) {
		if (step > 2 || step < 1)
			return null;

		StringBuffer result = new StringBuffer();
		for (Role r : leftBank.getRolesAtBank()) {
			if (r instanceof Priest) {
				result.append('P');
			} else {
				if (r instanceof Devil) {
					result.append('D');
				} else
					result.append('O');
			}
		}
		if (boat.getBoatStatu() == BoatStatu.onLeft)
			result.append("|");
		else
			result.append("\\");

		for (Role r : boat.getRolesAtBoat()) {
			if (r instanceof Priest) {
				result.append('P');
			} else {
				if (r instanceof Devil) {
					result.append('D');
				} else
					result.append('O');
			}
		}

		if (boat.getBoatStatu() == BoatStatu.onRight)
			result.append("|");
		else
			result.append("/");

		for (Role r : rightBank.getRolesAtBank()) {
			if (r instanceof Priest) {
				result.append('P');
			} else {
				if (r instanceof Devil) {
					result.append('D');
				} else
					result.append('O');
			}
		}
		if (step == 2) {
			if (boat.getBoatStatu() == BoatStatu.onLeft)
				result.insert(9, "OO");
			else
				result.insert(7, "OO");
		} else {
			result.insert(7, "O");
			result.insert(10, "O");
		}
		return new String("\t\"" + result + "\"");
	}

	/**
	 * �����ʼ��������
	 */
	public void init() {

		this.gameStatu = GameStatu.ready;
		// ����bank�ϵ�Ҫʹ�õ�role����,���Priest�����Devil
		ArrayList<Role> rolesAtRightBank = new ArrayList<Role>();
		rolesAtRightBank.add(new Priest(0));
		rolesAtRightBank.add(new Priest(1));
		rolesAtRightBank.add(new Priest(2));
		rolesAtRightBank.add(new Devil(3));
		rolesAtRightBank.add(new Devil(4));
		rolesAtRightBank.add(new Devil(5));

		this.rightBank = new Bank(rolesAtRightBank);

		ArrayList<Role> rolesAtleftBank = new ArrayList<Role>();
		rolesAtleftBank.add(null);
		rolesAtleftBank.add(null);
		rolesAtleftBank.add(null);
		rolesAtleftBank.add(null);
		rolesAtleftBank.add(null);
		rolesAtleftBank.add(null);

		this.leftBank = new Bank(rolesAtleftBank);

		ArrayList<Role> rolesAtBoat = new ArrayList<Role>();
		rolesAtBoat.add(null);
		rolesAtBoat.add(null);

		this.boat = new Boat(rolesAtBoat);
	}

	/**
	 * �ж���Ϸ�Ƿ����
	 * 
	 * @return �����򷵻�true�����򷵻�false
	 */
	public boolean gameIsOver() {
		boolean isOver = false;
		int pcount = 0;
		int dcount = 0;
		for (Role r : this.leftBank.getRolesAtBank()) {
			if (r instanceof Priest) {
				pcount++;
			} else {
				if (r instanceof Devil) {
					dcount++;
				}
			}
		}
		if (this.boat.getBoatStatu() == BoatStatu.onLeft) {
			for (Role r : boat.getRolesAtBoat()) {
				if (r instanceof Priest) {
					pcount++;
				} else {
					if (r instanceof Devil) {
						dcount++;
					}
				}
			}
		}

		if (pcount < dcount && pcount >= 1) {
			this.gameStatu = GameStatu.end;
			return true;
		}

		pcount = 0;
		dcount = 0;
		for (Role r : this.rightBank.getRolesAtBank()) {
			if (r instanceof Priest) {
				pcount++;
			} else {
				if (r instanceof Devil) {
					dcount++;
				}
			}
		}
		if (this.boat.getBoatStatu() == BoatStatu.onRight) {
			for (Role r : boat.getRolesAtBoat()) {
				if (r instanceof Priest) {
					pcount++;
				} else {
					if (r instanceof Devil) {
						dcount++;
					}
				}
			}
		}
		if (pcount < dcount && pcount >= 1) {
			this.gameStatu = GameStatu.end;
			return true;
		}

		return isOver;
	}

	/**
	 * �ж���Ϸ�Ƿ�Ӯ
	 * 
	 * @return �����򷵻�true�����򷵻�false
	 */
	public boolean gameIsSuccess() {
		boolean isSuccess = false;
		int pcount = 0;
		int dcount = 0;
		for (Role r : this.leftBank.getRolesAtBank()) {
			if (r instanceof Priest) {
				pcount++;
			} else {
				if (r instanceof Devil) {
					dcount++;
				}
			}
		}
		if (pcount + dcount == 6)
			isSuccess = true;
		return isSuccess;
	}

	/**
	 * @throws GameException
	 */
	public static PlayGameImpl getInstance() {
		if (instance == null) {
			instance = new PlayGameImpl();
		}

		return instance;
	}
}
