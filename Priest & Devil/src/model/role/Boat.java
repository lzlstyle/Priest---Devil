package model.role;

import java.util.ArrayList;

import controller.GameRule;

/**
 * ����Boat�࣬Boat��Ҫ��һ��������״̬�ı�����boatStatu������һ��rolesAtBoat �Ķ��������¼���ϵ�role����Ϣ
 * 
 * @author lzlstyle
 * 
 */
public class Boat {

	/** ��״̬���� */
	private BoatStatu boatStatu;

	/** ����roles�������Ϣ��˳������Ҽ�¼����Ӧλ����û��role����Ϊnull */
	private ArrayList<Role> rolesAtBoat;

	/**
	 * ���캯�����ڴ����ͳ�ʼ������Ϣ
	 * 
	 * @param rolesAtBoat
	 *            ����role��Ϣ
	 */
	public Boat(ArrayList<Role> rolesAtBoat) {
		this.rolesAtBoat = rolesAtBoat;
		this.boatStatu = GameRule.g_BoatStatu;
	}

	/**
	 * ��ȡ����״̬��Ϣ
	 * 
	 * @return boatStatu��Ϣ
	 */
	public BoatStatu getBoatStatu() {
		return this.boatStatu;
	}

	/**
	 * �޸Ĵ���״̬
	 * 
	 * @param boatStatu
	 */
	public void setBoatStatu(BoatStatu boatStatu) {
		this.boatStatu = boatStatu;
	}

	/**
	 * ��ȡ�������ж������Ϣ����������
	 * 
	 * @return ArrayList<Role>���͵�role��Ϣ
	 */
	public ArrayList<Role> getRolesAtBoat() {
		return this.rolesAtBoat;
	}

	/**
	 * ���ô������ж������Ϣ����������
	 * 
	 * @param roles
	 *            ArrayList<Role>���͵�role��Ϣ
	 */
	public void setRolesAtBoat(ArrayList<Role> roles) {
		this.rolesAtBoat = roles;
	}

	/**
	 * ����positionλ���ϵĶ�����Ϣ��
	 * 
	 * @param position
	 * @return ��positionԽ�磬�򷵻�null�����򷵻���Ӧ�Ķ���
	 */
	public Role getRoleAtBoatAt(int position) {
		if (position < this.rolesAtBoat.size())
			return this.rolesAtBoat.get(position);
		else
			return null;
	}

	/**
	 * ����Ӧλ��position�ϲ������role
	 * 
	 * @param position
	 * @param role
	 * @return ��position���������?�����Ҳ���ɹ��򷵻�true�����򷵻�false
	 */
	public boolean setRoleAtBoatAt(int position, Role role) {
		boolean success = false;
		if (position < this.rolesAtBoat.size()) {
			this.rolesAtBoat.set(position, role);
			success = true;
		}
		return success;
	}

	/**
	 * Boat����ĳ�ʼ������
	 * 
	 * @return void
	 * 
	 *         private void init() { this.boatStatu = GameRule.g_BoatStatu;
	 *         this.rolesAtBoat = new ArrayList<Role>(); }
	 */

	/**
	 * ����Boat�������Ϣ
	 */
	public void reSet() {
		this.boatStatu = GameRule.g_BoatStatu;
	}

	/**
	 * ��ȡ���ϵĶ������
	 */
	public int getRolesNumber() {
		int count = 0;
		for (Role r : this.rolesAtBoat) {
			if (r != null)
				count++;
		}
		return count;
	}

}
