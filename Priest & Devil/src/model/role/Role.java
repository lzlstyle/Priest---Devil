package model.role;

import controller.GameRule;

/**
 * ��Ϸ��ɫ�ĳ�����
 * 
 * @author lzlstyle
 * 
 */
public class Role {
	/** ��¼��ɫ��״ֵ̬ */
	// private RoleStatu roleStatu;
	/** ��¼role ��λ����Ϣ,���е�roleλ����Ϣ�Ǵ�0��ʼ�ģ��Ա���±걣��һ�� */
	private int position;

	// /**role����Ϸ�е�λ�ò������1��һ��16λ��ֵ*/
	// private int positionInGame;

	/**
	 * ��ȡrole����Ϸ�е�λ��
	 * 
	 * @return
	 */
	// public int getPositionInGame() {
	// return positionInGame;
	// }
	/**
	 * ���û��޸�role���ƶ�����еı仯���λ��
	 * 
	 * @param positionInGame
	 */
	// public void setPositionInGame(int positionInGame) {
	// this.positionInGame = positionInGame;
	// }
	/**
	 * ������Ϸ��ɫ
	 * 
	 * @param position
	 * 
	 */
	public Role(int position) {
		// this.roleStatu = GameRule.g_RoleStatu;
		this.position = position;
		// positionInGame = position;
	}

	/**
	 * ��ȡroleλ����Ϣ�����е�roleλ����Ϣ�Ǵ�0��ʼ�ģ��Ա���±걣��һ��
	 * 
	 * @return int ����role��λ��
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * ����Role��λ����Ϣ�����е�roleλ����Ϣ�Ǵ�0��ʼ�ģ��Ա���±걣��һ��
	 * 
	 * @param position
	 */
	// public void setPosition(int position) {
	// this.position = position;
	// }
	/**
	 * ��ȡrole��״ֵ̬
	 * 
	 * @param ��
	 * @return RoleStatu
	 */
	// public RoleStatu getStatu() {
	// return this.roleStatu;
	// }
	/**
	 * ����role��״ֵ̬
	 * 
	 * @param newStatu
	 * @return void
	 */
	// public void setStatu(RoleStatu newStatu) {
	// this.roleStatu = newStatu;
	// }
	/**
	 *����role״̬
	 */
	public void reSet() {
		// this.roleStatu = GameRule.g_RoleStatu;
		// this.positionInGame = this.position;
	}

	/**
	 * ͼ�ν���ʱ��role����Ӧ��������
	 */
	public void animation() {

	}
	/*
	 * public boolean isDead(){ boolean success =false;
	 * 
	 * return success; }
	 * 
	 * public void beKilled() {
	 * 
	 * }
	 */
}
