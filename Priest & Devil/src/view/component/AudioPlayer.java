package view.component;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

import controller.PlayGameImpl;
import model.observer.Observer;
import model.role.GameStatu;

/**
 * ��Ϸ���ֲ��Ź۲���
 * 
 * @author lzlstyle
 * 
 */
public class AudioPlayer implements Observer {
	private boolean start = false;
	Clip clip;

	public AudioPlayer() {
		try {
			String path = Thread.currentThread().getContextClassLoader()
					.getResource("").toString();
			path = path.substring(path.indexOf('/'), path.lastIndexOf('/'));
			String audiofile = path + "/view/audio/bgmusic.wav";
			// System.out.println(start);
			AudioInputStream stream = AudioSystem.getAudioInputStream(new File(
					audiofile));
			AudioFormat format = stream.getFormat();
			if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
				format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,
						format.getSampleRate(),
						format.getSampleSizeInBits() * 2, format.getChannels(),
						format.getFrameSize() * 2, format.getFrameRate(), true);
				stream = AudioSystem.getAudioInputStream(format, stream);
			}
			DataLine.Info info = new DataLine.Info(Clip.class, stream
					.getFormat(), ((int) stream.getFrameLength() * format
					.getFrameSize()));

			clip = (Clip) AudioSystem.getLine(info);
			clip.open(stream);
			// ѭ��18�Σ�û��ʲô�ر�����壬ֻ���� ���ѭ������
			clip.loop(18);
			clip.start();
			// clip.start();
			start = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {

		try {
			if (!clip.isActive()) {
				clip.start();
				start = true;
			}
		} catch (Exception e) {

		}

		if (PlayGameImpl.getInstance().getGameStatu() == GameStatu.playing
				&& start == false) {
			try {
				if (!clip.isActive()) {
					clip.start();
					start = true;
				}
			} catch (Exception e) {

			}
		}

		if (PlayGameImpl.getInstance().getGameStatu() == GameStatu.end) {
			try {
				clip.stop();

				start = false;
			} catch (Exception e) {

			}
		}
	}

}
