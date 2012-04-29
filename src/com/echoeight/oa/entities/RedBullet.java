package com.echoeight.oa.entities;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;
	
public class RedBullet extends AbstractMoveableEntity {
		
	Texture bul1;
		
        public RedBullet(double x, double y, double width, double height) {
            super(x, y, width, height, Gun.NONE);
        }

        @Override
        public void draw(boolean flip) {
        	if(bul1 != null)
        	GL11.glDeleteTextures(bul1.getTextureID());
        	try {
				bul1 = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/bul2.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
      	
            bul1.bind();
            GL11.glLoadIdentity();
            GL11.glTranslated(x, y, 0);
        	
        	GL11.glBegin(GL11.GL_QUADS);
    			GL11.glTexCoord2f(0,0);
    			GL11.glVertex2f(100,100);
    			GL11.glTexCoord2f(1,0);
    			GL11.glVertex2f(100+bul1.getTextureWidth(),100);
    			GL11.glTexCoord2f(1,1);
    			GL11.glVertex2f(100+bul1.getTextureWidth(),100+bul1.getTextureHeight());
    			GL11.glTexCoord2f(0,1);
    			GL11.glVertex2f(100,100+bul1.getTextureHeight());
    		GL11.glEnd();
    		 GL11.glLoadIdentity();
    		
        }
    }