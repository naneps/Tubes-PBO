package com.mygdx.virus.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.mygdx.virus.VirusGame;

public class DesktopLauncher {
	public void main(String[] arg) {
		VirusGame myProgram = new VirusGame();
		LwjglApplication launcher = new LwjglApplication(
				myProgram );

	}
}
