package com.echoeight.oa;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
 
public class MainMenuState extends BasicGameState{
 
    Image background = null;
    Image startGameOption = null;
    Image exitOption = null;
 
    private static int menuX = 410;
    private static int menuY = 160;
 
    float startGameScale = 1;
    float exitScale = 1;
 
    Sound fx = null;
 
    int stateID = -1;
    
    MainMenuState( int stateID ) 
    {
       this.stateID = stateID;
    }
 
    @Override
    public int getID() {
        return stateID;
    }
 
    UnicodeFont trueTypeFont = null;
 
    public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
    	background = new Image("res/menu.png");
    } 
 
    public void render(GameContainer arg0, StateBasedGame arg1, Graphics arg2) throws SlickException {
    	arg2.drawImage(background, 0, 0);
    }
 
    public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {

    	int mx = Mouse.getX();
    	int my = Mouse.getY();

    	if (Mouse.isButtonDown(0)) {

//    		System.out.println(mx);
//    		System.out.println(my);

    		if (mx > 375 && my > 280 && mx < 600 && my < 330) {

    			System.out.println("Starting Game");
    			sb.enterState(1);
    		}

    		if (mx > 375 && my > 210 && mx < 600 && my < 260) {

    			//TODO Continue
    		}

    		if (mx > 375 && my > 145 && mx < 600 && my < 190) {

    			//TODO Level Select
    		}

    		if (mx > 375 && my > 75 && mx < 600 && my < 125) {

    			//TODO Options
    		}

    		if (mx > 375 && my > 16 && mx < 600 && my < 64) {

    			gc.exit();
    		}
    	}
    }
}