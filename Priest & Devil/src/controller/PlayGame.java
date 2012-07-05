package controller;

import exceptions.*;

/**
 * ��Ϸ������
 * 
 * @author lzlstyle
 * 
 */
public abstract class PlayGame {

	/**
	 * ������Ϸ״̬
	 * 
	 * @throws GameException
	 */
	public abstract void reSet() throws GameException;

	/**
	 * ��������Ϸ
	 * 
	 * @throws GameException
	 */
	public abstract void rePlay() throws GameException;

	/**
	 * ��ʼ����Ϸ
	 * 
	 * @throws GameException
	 */
	public abstract void play() throws GameException;

	/**
	 * �������� �ɹ��򷵻�true�����򷵻�false
	 * 
	 * @return
	 * @throws GameException
	 */
	public abstract boolean go() throws GameException;

	/**
	 * �ϴ���Ĭ�Ϸ��� �ɹ��򷵻�true�����򷵻�false
	 * 
	 * @return
	 * @throws GameException
	 */
	public abstract boolean board() throws GameException;

	/**
	 * ѡ��ڼ���role�ϴ� �ɹ��򷵻�true�����򷵻�false
	 * 
	 * @param param
	 * @return
	 * @throws GameException
	 */
	public abstract boolean board(int param) throws GameException;

	/**
	 * ���ѡ���ϵ�һ��role�´� �ɹ��򷵻�true�����򷵻�false
	 * 
	 * @return
	 * @throws GameException
	 */
	public abstract boolean disembark() throws GameException;

	/**
	 * ѡ��paramλ���ϵ�role�´�
	 * 
	 * 
	 * @param param
	 *            ����Ϊ�� 1��2
	 * @return �ɹ��򷵻�true�����򷵻�false
	 * @throws GameException
	 */
	public abstract boolean disembark(int param) throws GameException;

	/**
	 * �����Ϸ״̬
	 * 
	 * @return ״̬�ַ�
	 */
	public abstract String echo();

	/**
	 * ��ȡ״ֵ̬
	 * 
	 * @return
	 * @throws GameException
	 */
	public static PlayGame getInstance() {
		return null;
	}
}
