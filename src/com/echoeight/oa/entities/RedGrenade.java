package com.echoeight.oa.entities;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class RedGrenade extends AbstractMoveableEntity {
		
		Texture gre1;
		
    	protected double initialy;
    	
        public RedGrenade(double initialy, double x, double y, double width, double height) {
            super(x, y, width, height, Gun.NONE);
            this.initialy = initialy;
        }
        
        @Override
        public void draw(boolean flip) {
        	if(gre1 != null)
        	GL11.glDeleteTextures(gre1.getTextureID());
        	try {
				gre1 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/grebul2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
      	
            gre1.bind();
            GL11.glLoadIdentity();
            GL11.glTranslated(x, y, 0);
        	
        	GL11.glBegin(GL11.GL_QUADS);
    			GL11.glTexCoord2f(0,0);
    			GL11.glVertex2f(100,100);
    			GL11.glTexCoord2f(1,0);
    			GL11.glVertex2f(100+gre1.getTextureWidth(),100);
    			GL11.glTexCoord2f(1,1);
    			GL11.glVertex2f(100+gre1.getTextureWidth(),100+gre1.getTextureHeight());
    			GL11.glTexCoord2f(0,1);
    			GL11.glVertex2f(100,100+gre1.getTextureHeight());
    		GL11.glEnd();
    		 GL11.glLoadIdentity();
    		
        }
        
        public double getInitialY(){
        	return initialy;
        }
        
    }