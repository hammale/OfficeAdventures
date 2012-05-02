package com.echoeight.oa;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class OfficeAdventures extends StateBasedGame {

    static int WIDTH = 640;
    static int HEIGHT = 480;

    public OfficeAdventures() {

    	super("Office Adventures");
    	
		this.addState(new LevelOneState(1));
		this.addState(new MainMenuState(-1));

		this.enterState(-1);
    }

	public static void main(String[] argv) throws SlickException {

		boolean fullscreen = false;

        for (String s: argv) {
    		if (s.equalsIgnoreCase("fullscreen")) {

    			fullscreen = true;
    		}
        }

        AppGameContainer app = new AppGameContainer(new OfficeAdventures());

        app.setDisplayMode(WIDTH, HEIGHT, fullscreen);
        app.start();
	}

	@Override
	public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.getState(-1).init(gameContainer, this);
        this.getState(1).init(gameContainer, this);
	}
}