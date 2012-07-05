package model.role;

import java.util.ArrayList;

/**
 * 定义岸边的类，主要有岸边的对象的信息数组链表：rolesAtBank
 */
public class Bank {
	private ArrayList<Role> rolesAtBank;

	/**
	 * 创建Bank对象并初始化
	 */
	public Bank(ArrayList<Role> rolesAtBank) {
		this.rolesAtBank = rolesAtBank;
	}

	/**
	 * 获取岸边上所有对象的信息的数组链表
	 * 
	 * @return ArrayList<Role>类型的role信息
	 */
	public ArrayList<Role> getRolesAtBank() {
		return this.rolesAtBank;
	}

	/**
	 * 返回position位置上的对象信息，
	 * 
	 * @param position
	 * @return 若position越界，则返回null，否则返回相应的对象
	 */
	public Role getRoleAtBankAt(int position) {
		if (position < this.rolesAtBank.size())
			return this.rolesAtBank.get(position);
		else
			return null;
	}

	/**
	 * 在相应位置position上插入对象role
	 * 
	 * @param position
	 * @param role
	 * @return 若position在数组链表长度内且插入成功则返回true，否则返回false
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
	 * Boat对象的初始辅助函数
	 * 
	 * @return void
	 * 
	 *         private void init() { this.rolesAtBank = new ArrayList<Role>(); }
	 */

	/**
	 * 重置Bank对象的信息
	 */
	public void reSet() {
		for (Role r : this.rolesAtBank) {
			if (r != null)
				r.reSet();
		}
	}
}
