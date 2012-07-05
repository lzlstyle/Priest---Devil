package controller;

import model.role.Bank;
import model.role.Boat;
import model.role.BoatStatu;
import model.role.Role;
import exceptions.*;

/**
 * ��Ҫ�������Ϸ�Ĺ��򣬲�ͨ����������Ϸ����
 * 
 * @author lzlstyle
 * 
 */
public class GameRule {
	/** ���������Ϸ�ĳ�ʼ״̬��Ϣ */

	/** ��Ϸ��ɫ�еĿ�ʼĬ��״̬ */
	// public static RoleStatu g_RoleStatu = RoleStatu.rightBank;
	/** ��Ϸ�д��Ŀ�ʼĬ��״̬ */
	public static BoatStatu g_BoatStatu = BoatStatu.onRight;

	/**
	 * ��������Ϸ�е�go����Ĺ���,��������role������ƶ�
	 * 
	 * @param boat
	 * @param leftBank
	 * @param rightBank
	 * @return ��boat����role������Կ���������ture�����򷵻�false
	 * @throws GameException
	 */
	public static boolean goCmdRule(Boat boat, Bank leftBank, Bank rightBank)
			throws GameException {
		boolean success = false;
		if (boat.getRolesNumber() > 0) {
			if (boat.getBoatStatu() == BoatStatu.onLeft) {
				boat.setBoatStatu(BoatStatu.onRight);
				int count = 0;
				for (Role r : boat.getRolesAtBoat()) {
					if (r != null) {
						success = true;
					}
					count++;
				}
				if (success == false)
					throw new RoleNotExistException();// Log.boardFailTips(); //
														// ��Ӧλ���ϵĵ�roleΪ��
			} else {
				boat.setBoatStatu(BoatStatu.onLeft);
				int count = 0;
				for (Role r : boat.getRolesAtBoat()) {
					if (r != null) {
						success = true;
					}
					count++;
				}
				if (success == false)
					throw new RoleNotExistException(); // Log.boardFailTips();
														// // ��Ӧλ���ϵĵ�roleΪ��
			}
		} else
			throw new BoatIsEmptyException();// /Log.boatIsEmptyTips(); //������ʾ

		return success;
	}

	/**
	 * ������Ϸ������״̬����Ϣ
	 * 
	 * @param leftBank
	 * @param rightBank
	 * @param boat
	 * @throws GameException
	 */
	public static void reSetCmdRule(Bank leftBank, Bank rightBank, Boat boat)
			throws GameException {
		leftBank.reSet();
		rightBank.reSet();
		boat.reSet();
	}

	/**
	 * ���¿�ʼ��Ϸ
	 * 
	 * @param leftBank
	 * @param rightBank
	 * @param boat
	 * @throws GameException
	 */
	public static void rePlayCmdRule(Bank leftBank, Bank rightBank, Boat boat)
			throws GameException {
		reSetCmdRule(leftBank, rightBank, boat);
	}

	/**
	 * * ������ϴ��Ĺ���,
	 * 
	 * @param boat
	 * @param nearBank
	 * @param chosePosition
	 * @return ���������ϴ�����ɹ�������false�����������Ӧ�Ĵ���󷵻�ture
	 * @throws GameException
	 */
	public static boolean boardCmdRule(Boat boat, Bank nearBank,
			int chosePosition) throws GameException {
		if (chosePosition > 5 || chosePosition < 0)
			throw new ParamOutOfRangeException();
		boolean success = false;
		// ���ߵ���Ӧλ�ò�Ϊ��
		if (nearBank.getRoleAtBankAt(chosePosition) != null) {
			// �������п�λ�ã�����λ�ô��밶������λ�ÿ�ʼ
			int count = boat.getRolesAtBoat().size();
			// �����󰶱ߵ����
			if (boat.getBoatStatu() == BoatStatu.onLeft) {
				for (int start = 0; start < count; start++) {
					// ��λ��Ϊ�գ�����д���
					if (boat.getRoleAtBoatAt(start) == null) {

						boat.setRoleAtBoatAt(start, nearBank
								.getRoleAtBankAt(chosePosition));

						nearBank.setRoleAtBankAt(chosePosition, null);
						success = true;
						break;
					}
				}
				if (success == false)
					throw new BoatIsFullException();// Log.boatIsFullTips(); //
													// ����
			} else {
				for (int start = count - 1; start >= 0; start--) {
					// ��λ��Ϊ�գ�����д���
					if (boat.getRoleAtBoatAt(start) == null) {

						boat.setRoleAtBoatAt(start, nearBank
								.getRoleAtBankAt(chosePosition));

						nearBank.setRoleAtBankAt(chosePosition, null);
						success = true;
						break;
					}
				}
				if (success == false)
					throw new BoatIsFullException();// Log.boatIsFullTips(); //
													// ����
			}
		} else
			throw new RoleNotExistException();// Log.boardFailTips();
												// //���ϵ���Ӧλ���ϵ�roleΪ��
		return success;
	}

	/**
	 * * ������ϴ��Ĺ���,����Ϊ���ǣ�Ĭ�ϴ��봬����λ�ÿ�ʼ
	 * 
	 * @param boat
	 * @param nearBank
	 * @return ���������ϴ�����ɹ�������false�����������Ӧ�Ĵ���󷵻�ture
	 * @throws GameException
	 */
	public static boolean boardCmdRule(Boat boat, Bank nearBank)
			throws GameException {
		boolean success = false;
		int count = nearBank.getRolesAtBank().size();
		int num = boat.getRolesAtBoat().size();
		int start = 0;
		// �������п�λ��
		if (boat.getRolesNumber() != boat.getRolesAtBoat().size()) {
			// ������
			if (boat.getBoatStatu() == BoatStatu.onLeft) {
				for (start = count - 1; start >= 0; start--) {
					if (nearBank.getRoleAtBankAt(start) != null) {
						for (int startBoat = 0; startBoat < num; startBoat++) {
							if (boat.getRoleAtBoatAt(startBoat) == null) {

								boat.setRoleAtBoatAt(startBoat, nearBank
										.getRoleAtBankAt(start));
								nearBank.setRoleAtBankAt(start, null);
								success = true;
								return success;
							}
						}
					}
				}
				if (success == false)
					throw new BoatIsFullException();// Log.boatIsFullTips(); //
													// ����
			} else { // �����Ұ�
				for (start = 0; start < count; start++) {
					if (nearBank.getRoleAtBankAt(start) != null) {
						for (int startBoat = num - 1; startBoat >= 0; startBoat--) {
							if (boat.getRoleAtBoatAt(startBoat) == null) {
								boat.setRoleAtBoatAt(startBoat, nearBank
										.getRoleAtBankAt(start));
								nearBank.setRoleAtBankAt(start, null);
								success = true;
								return success;
							}
						}
					}
				}

				if (success == false)
					throw new BoatIsFullException();// Log.boatIsFullTips(); //
													// ����
			}
		} else
			throw new BoatIsFullException();// Log.boatIsFullTips(); //���Ѿ���

		return success;

	}

	/**
	 * * �����봬�Ĺ���,
	 * 
	 * @param boat
	 * @param nearBank
	 * @param chosePosition
	 * @return ��ѡ�еĴ��ϵ����Ƿ���������������Ӧ�Ĳ����󷵻�true�����򷵻�false
	 * @throws GameException
	 */
	public static boolean disembarkCmdRule(Boat boat, Bank nearBank,
			int chosePosition) throws GameException {
		boolean success = false;
		if (chosePosition > 1 || chosePosition < 0)
			throw new ParamOutOfRangeException();
		// ��������Ӧ��λ�ò�Ϊ��
		if (boat.getRoleAtBoatAt(chosePosition) != null) {
			Role item = boat.getRoleAtBoatAt(chosePosition);
			// ���role ��λ����Ϣ����role�����´��Ĳ���
			nearBank.setRoleAtBankAt(item.getPosition(), item);
			boat.setRoleAtBoatAt(chosePosition, null);

			success = true;
		} else
			throw new BoatIsEmptyException();// Log.boatIsEmptyTips();//����
		return success;
	}

	/**
	 * * �����봬�Ĺ��򣬲���Ϊ���ǣ�Ĭ�ϴ��밶������λ�ÿ�ʼ
	 * 
	 * @param boat
	 * @param nearBank
	 * @return ��ѡ�еĴ��ϵ����Ƿ���������������Ӧ�Ĳ����󷵻�true�����򷵻�false
	 * @throws GameException
	 */
	public static boolean disembarkCmdRule(Boat boat, Bank nearBank)
			throws GameException {
		boolean success = false;
		if (boat.getBoatStatu() == BoatStatu.onLeft) {
			int count = boat.getRolesAtBoat().size();
			for (int start = 0; start < count; start++) {
				if (boat.getRoleAtBoatAt(start) != null) {

					nearBank.setRoleAtBankAt(boat.getRoleAtBoatAt(start)
							.getPosition(), boat.getRoleAtBoatAt(start));
					boat.setRoleAtBoatAt(start, null);
					success = true;
					break;
				}
			}
		} else {
			int count = boat.getRolesAtBoat().size();
			for (int start = count - 1; start >= 0; start--) {
				if (boat.getRoleAtBoatAt(start) != null) {

					nearBank.setRoleAtBankAt(boat.getRoleAtBoatAt(start)
							.getPosition(), boat.getRoleAtBoatAt(start));
					boat.setRoleAtBoatAt(start, null);
					success = true;
					break;
				}
			}
		}
		if (success == false)
			throw new BoatIsEmptyException();// Log.boatIsEmptyTips();
		return success;
	}

}
