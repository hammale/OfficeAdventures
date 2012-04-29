package com.echoeight.oa.entities;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Ladder extends AbstractEntity {

		Texture ladder;
	
        public Ladder(double x, double y, double width, double height) {
            super(x, y, width, height);
        }

        @Override
        public void draw(boolean flip) {
        	try {
        		if(ladder != null)
        		GL11.glDeleteTextures(ladder.getTextureID());
        		ladder = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/ladder.png"));
        	} catch (IOException e) {
        		e.printStackTrace();
        	}
            ladder.bind();
            GL11.glLoadIdentity();
            GL11.glTranslated(x, y, 0);
        	
        	GL11.glBegin(GL11.GL_QUADS);
    			GL11.glTexCoord2f(0,0);
    			GL11.glVertex2f(100,100);
    			GL11.glTexCoord2f(1,0);
    			GL11.glVertex2f(100+ladder.getTextureWidth(),100);
    			GL11.glTexCoord2f(1,1);
    			GL11.glVertex2f(100+ladder.getTextureWidth(),100+ladder.getTextureHeight());
    			GL11.glTexCoord2f(0,1);
    			GL11.glVertex2f(100,100+ladder.getTextureHeight());
    		GL11.glEnd();
    		 GL11.glLoadIdentity();
    		
    		
        }

		@Override
		public void update(int delta) {
			
		}

}