package model.role;

import java.util.ArrayList;

/**
 * ���尶�ߵ��࣬��Ҫ�а��ߵĶ������Ϣ��������rolesAtBank
 */
public class Bank {
	private ArrayList<Role> rolesAtBank;

	/**
	 * ����Bank���󲢳�ʼ��
	 */
	public Bank(ArrayList<Role> rolesAtBank) {
		this.rolesAtBank = rolesAtBank;
	}

	/**
	 * ��ȡ���������ж������Ϣ����������
	 * 
	 * @return ArrayList<Role>���͵�role��Ϣ
	 */
	public ArrayList<Role> getRolesAtBank() {
		return this.rolesAtBank;
	}

	/**
	 * ����positionλ���ϵĶ�����Ϣ��
	 * 
	 * @param position
	 * @return ��positionԽ�磬�򷵻�null�����򷵻���Ӧ�Ķ���
	 */
	public Role getRoleAtBankAt(int position) {
		if (position < this.rolesAtBank.size())
			return this.rolesAtBank.get(position);
		else
			return null;
	}

	/**
	 * ����Ӧλ��position�ϲ������role
	 * 
	 * @param position
	 * @param role
	 * @return ��position���������������Ҳ���ɹ��򷵻�true�����򷵻�false
	 */
	public boolean setRoleAtBankAt(int position, Role role) {
		boolean success = false;
		if (position < this.rolesAtBank.size()) {

			this.rolesAtBank.set(position, role);
			success = true;
		}
		return success;
	}

	/**
	 * Boat����ĳ�ʼ��������
	 * 
	 * @return void
	 * 
	 *         private void init() { this.rolesAtBank = new ArrayList<Role>(); }
	 */

	/**
	 * ����Bank�������Ϣ
	 */
	public void reSet() {
		for (Role r : this.rolesAtBank) {
			if (r != null)
				r.reSet();
		}
	}
}
