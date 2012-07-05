package model.observer;

import java.util.ArrayList;

/**
 * 
 * ������������֪ͨ�ߣ����й�״̬�������۲��߶����ھ�������� �ڲ�״̬�ı�ʱ�������еǼǹ�Ĺ۲��߷���֪ͨ�����������ɫͨ����һ����������ʵ�֡�
 * 
 * @author lzlstyle
 * 
 */
public class ObservableImpl implements Observable {

	private ArrayList<Observer> observers = new ArrayList<Observer>();

	/**
	 * ��ӹ۲���
	 * 
	 * @param observer
	 */
	public void Attach(Observer observer) {
		observers.add(observer);
	}

	/**
	 * �Ƴ�۲���
	 * 
	 * @param observer
	 */
	public void Detach(Observer observer) {
		observers.remove(observer);
	}

	/**
	 * ֪ͨ
	 */
	public void Notify() {
		for (Observer o : observers) {
			o.update();
		}
	}

}
