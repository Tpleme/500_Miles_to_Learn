package org.academiadecodigo.gnunas.fivehundredmilestolearn.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.academiadecodigo.gnunas.fivehundredmilestolearn.MainClass;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = MainClass.WIDTH;
		config.height = MainClass.HEIGHT;
		config.title = MainClass.title;
		new LwjglApplication(new MainClass(), config);
	}


}
