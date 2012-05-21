package com.echoeight.oa.entities;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;

import com.echoeight.oa.images.LoadTextures;

public class Dude extends AbstractMoveableEntity {
    	
	Texture dude;

	protected int health;
	
	public static boolean manflip;
	public static boolean hasgun; 
	
	
	
	public static Gun currentGun = Gun.NONE;
	
            public Dude(double x, double y, double width, double height, int health) {
                super(x, y, width, height, Gun.NONE);
                this.health = health;
            }
            
            public void setHealth(int health){
            	this.health = health;
            }
            
            public int getHealth(){
            	return this.health;
            }
            
            @Override
            public void draw(boolean flip) {           	
            	if(hasgun){
            	       	if(currentGun == Gun.NONE){
            	       		dude = LoadTextures.getDude(manflip, Gun.NONE);
            	       	}else if(currentGun == Gun.PISTOL){
            	       		dude = LoadTextures.getDude(manflip, Gun.PISTOL);
            	       	}else if(currentGun == Gun.SMG){
            	       		dude = LoadTextures.getDude(manflip, Gun.SMG);
            	       	}else if(currentGun == Gun.GRENADE){
            	       		dude = LoadTextures.getDude(manflip, Gun.GRENADE);
            	       	}
            	}else{
            	    dude = LoadTextures.getDude(manflip, Gun.NONE);
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
            
            @Override
            public void update(int delta){
            	if(hasgun){
        	       	if(currentGun == Gun.NONE){
        	       		dude = LoadTextures.getDude(manflip, Gun.NONE);
        	       	}else if(currentGun == Gun.PISTOL){
        	       		dude = LoadTextures.getDude(manflip, Gun.PISTOL);
        	       	}else if(currentGun == Gun.SMG){
        	       		dude = LoadTextures.getDude(manflip, Gun.SMG);
        	       	}else if(currentGun == Gun.GRENADE){
        	       		dude = LoadTextures.getDude(manflip, Gun.GRENADE);
        	       	}
            	}else{
            		dude = LoadTextures.getDude(manflip, Gun.NONE);
            	} 
            }
}