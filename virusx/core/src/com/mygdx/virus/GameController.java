package com.mygdx.virus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class GameController extends BaseScreen {
	private Character background;
	private Virus virus;
	private float spawnTimer;
	private float spawnInterval;

	private int popped;
	private int escaped;
	private int clicked;

	private Label poppedLabel;
	private Label escapedLabel;
	private Label hitRatioLabel;
	private Label clickedLabel;
	private int popToWin = 50;
	private int escapedToFail = 5;
	final int mapWidth = 740;
	final int mapHeight = 580;
	public GameController(Game g){
		super(g);
	}

	@Override
	public void create() {
		background = new Character();
		background.setTexture(new Texture("bg.jpg"));
		background.setPosition(0,0);
		mainStage.addActor(background);
		spawnTimer = 0 ;
		spawnInterval =0.5f;

		BitmapFont font = new BitmapFont();
		Label.LabelStyle style = new Label.LabelStyle(font , Color.GOLDENROD);

		popped = 0;
		poppedLabel = new Label("Terbunh: 0 ",style);
		poppedLabel.setFontScale(2);
		poppedLabel.setPosition(20,440);
		uiStage.addActor(poppedLabel);

		escaped = 0;
		escapedLabel = new Label("Lolos: 0",style);
		escapedLabel.setFontScale(2);
		escapedLabel.setPosition(220,440);
		uiStage.addActor(escapedLabel);

		clicked = 0;
		hitRatioLabel = new Label( "Hit Ratio: ---", style );
		hitRatioLabel.setFontScale(2);
		hitRatioLabel.setPosition(420, 440);
		uiStage.addActor( hitRatioLabel );

		clickedLabel = new Label("Clicked: 0", style);
		clickedLabel.setFontScale(2);
		clickedLabel.setPosition(20,40);
		uiStage.addActor(clickedLabel);
	}
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		clicked++;
		return false;
	}

	@Override
	public void update(float delta) {
		spawnTimer += delta;

		if (spawnTimer > spawnInterval){

			spawnTimer -= spawnInterval;
			final Virus virus = new Virus(this);
			virus.addListener(
					new InputListener() {
						@Override
						public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
							popped++;
							//TODO examine InputListener
							virus.removeListener(virus.getListeners().first());
							virus.popBalloon();
							return true;
						}
					}
			);
			mainStage.addActor(virus);
		}

		// update user interface
		poppedLabel.setText("Terbunuh: " + popped);
		escapedLabel.setText("Lolos: " + escaped);
//        clickedLabel.setText("Clicked: " + clicked);

		if ( clicked > 0 )
		{
			int percent = (int)(100.0 * popped / clicked);
			hitRatioLabel.setText( "Hit Ratio: " + percent + "%"
			);
		}

		if (popped >= popToWin) {
			//winscreen
			game.setScreen(new MainMenu(game));
		}

		if (escaped >= escapedToFail) {
			//failscreen
			game.setScreen(new MainMenu(game));
		}


	}


	public void escapedInc(){
		escaped++;
	}
}
