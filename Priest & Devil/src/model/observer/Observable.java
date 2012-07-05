package model.observer;

import java.util.ArrayList;

/**
 * ����֪ͨ�ߣ�һ�����ڸ����������һ���ӿ�ʵ�֡������жԹ۲��߶�������ñ�����һ���ۼ��ÿ�����ⶼ���� ���κ������Ĺ۲��ߡ�
 * 
 * @author lzlstyle
 * 
 */
public interface Observable {

	/**
	 * ��ӹ۲���
	 * 
	 * @param observer
	 */
	public void Attach(Observer observer);

	/**
	 * ɾ��۲���
	 * 
	 * @param observer
	 */
	public void Detach(Observer observer);

	/**
	 * ֪ͨ�۲��ߣ�������Ϣ
	 */
	public void Notify();

}
