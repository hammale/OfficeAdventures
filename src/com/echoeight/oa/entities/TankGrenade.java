package com.echoeight.oa.entities;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class TankGrenade extends AbstractMoveableEntity {

	Texture tankbul;
	protected boolean flipped;
	
    public TankGrenade(boolean flipped, double x, double y, double width, double height) {
        super(x, y, width, height, Gun.NONE);
        this.flipped = flipped;
    }
    
    @Override
    public void draw(boolean flip) {
    	if(tankbul != null)
    	GL11.glDeleteTextures(tankbul.getTextureID());
    	try {
			tankbul = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/bul2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
  	
        tankbul.bind();
        GL11.glLoadIdentity();
        GL11.glTranslated(x, y, 0);
    	
    	GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(100,100);
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(100+tankbul.getTextureWidth(),100);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(100+tankbul.getTextureWidth(),100+tankbul.getTextureHeight());
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(100,100+tankbul.getTextureHeight());
		GL11.glEnd();
		 GL11.glLoadIdentity();
		
    }

    public void setFlipped(boolean flipped){
    	this.flipped = flipped;
    }
    
	public boolean isFlipped() {
		return flipped;
	}
    
} 