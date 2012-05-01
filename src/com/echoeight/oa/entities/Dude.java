package com.echoeight.oa.entities;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.echoeight.oa.LevelOneState;
import com.echoeight.oa.OfficeAdventures;

public class Dude extends AbstractMoveableEntity {
    	
		Texture dude;
	
            public Dude(double x, double y, double width, double height) {
                super(x, y, width, height, Gun.NONE);
            }

            @Override
            public void draw(boolean flip) {
            	if(dude != null)
            	GL11.glDeleteTextures(dude.getTextureID());
            	if(flip){
            		try {
            			if(LevelOneState.hasgun){
            				String path = "res/man1.png";
            	        	if(LevelOneState.currentGun == Gun.NONE){
            	        		path = "res/man1.png";
            	        	}else if(LevelOneState.currentGun == Gun.PISTOL){
            	        		path = "res/gun1.png";
            	        	}else if(LevelOneState.currentGun == Gun.SMG){
            	        		path = "res/smg2.png";
            	        	}else if(LevelOneState.currentGun == Gun.GRENADE){
            	        		path = "res/gre2.png";
            	        	}
            	        	
            				dude = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(path));
            			}else{
            				dude = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/man1.png"));
            			}
            		} catch (IOException e) {
            			e.printStackTrace();
            		}
            	}else{
            		try {
            			if(LevelOneState.hasgun){
            				String path = "res/man1.png";
            	        	if(LevelOneState.currentGun == Gun.NONE){
            	        		path = "res/man2.png";
            	        	}else if(LevelOneState.currentGun == Gun.PISTOL){
            	        		path = "res/gun2.png";
            	        	}else if(LevelOneState.currentGun == Gun.SMG){
            	        		path = "res/smg1.png";
            	        	}else if(LevelOneState.currentGun == Gun.GRENADE){
            	        		path = "res/gre1.png";
            	        	}
            	        	
            				
            				dude = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream(path));
            			}else{
            				dude = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/man2.png"));
            			}
            		} catch (IOException e) {
            			e.printStackTrace();
            		}
            	}
                dude.bind();
                GL11.glLoadIdentity();
                GL11.glTranslated(x, y, 0);
            	
	        	GL11.glBegin(GL11.GL_QUADS);
	    			GL11.glTexCoord2f(0,0);
	    			GL11.glVertex2f(100,100);
	    			GL11.glTexCoord2f(1,0);
	    			GL11.glVertex2f(100+dude.getTextureWidth(),100);
	    			GL11.glTexCoord2f(1,1);
	    			GL11.glVertex2f(100+dude.getTextureWidth(),100+dude.getTextureHeight());
	    			GL11.glTexCoord2f(0,1);
	    			GL11.glVertex2f(100,100+dude.getTextureHeight());
	    		GL11.glEnd();
	    		 GL11.glLoadIdentity();
	    		
            }
}