package com.echoeight.oa.entities;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Tank extends AbstractMoveableEntity {
    	
    	Texture tanktxture;
    	
    	protected double initialx;
    	protected boolean last = false;;
    	
        public Tank(double initialx, double y, double width, double height) {
            super(initialx, y, width, height, Gun.NONE);
            this.initialx = initialx;
        }
        
        @Override
        public void draw(boolean flip) {
        	if(tanktxture != null)
        	GL11.glDeleteTextures(tanktxture.getTextureID());
        	if(flip){
        		try {
        			tanktxture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/tank1.png"));
        		}catch (IOException e) {
        			e.printStackTrace();
        		}
        	}else{
        		try {
        			tanktxture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/tank2.png"));
        		} catch (IOException e) {
        			e.printStackTrace();
        		}
        	}
            tanktxture.bind();
            GL11.glLoadIdentity();
            GL11.glTranslated(x, y, 0);
        	
        	GL11.glBegin(GL11.GL_QUADS);
    			GL11.glTexCoord2f(0,0);
    			GL11.glVertex2f(100,100);
    			GL11.glTexCoord2f(1,0);
    			GL11.glVertex2f(100+tanktxture.getTextureWidth(),100);
    			GL11.glTexCoord2f(1,1);
    			GL11.glVertex2f(100+tanktxture.getTextureWidth(),100+tanktxture.getTextureHeight());
    			GL11.glTexCoord2f(0,1);
    			GL11.glVertex2f(100,100+tanktxture.getTextureHeight());
    		GL11.glEnd();
    		 GL11.glLoadIdentity();
    		
        }
        
        public double getBaseX(){
        	return initialx;
        }
        
        public void setLast(boolean last){
        	this.last = last;
        }
        
		public boolean getLast() {
			return last;
		}
                
}