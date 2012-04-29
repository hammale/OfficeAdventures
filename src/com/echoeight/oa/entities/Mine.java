package com.echoeight.oa.entities;

import java.io.IOException;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

public class Mine extends AbstractEntity {
	
	Texture mine;
	
	protected boolean explode = false;
	
    public Mine(double x, double y, double width, double height) {
        super(x, y, width, height);
    }
    
    @Override
    public void draw(boolean flip) {
    	try {
			if(mine != null)
			GL11.glDeleteTextures(mine.getTextureID());
    		if(!explode){
    			mine = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/mine.png"));
    		}else{
    			mine = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/boom.png"));
    		}
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
        mine.bind();
        GL11.glLoadIdentity();
        GL11.glTranslated(x, y, 0);
    	
    	GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(100,100);
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(100+mine.getTextureWidth(),100);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(100+mine.getTextureWidth(),100+mine.getTextureHeight());
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(100,100+mine.getTextureHeight());
		GL11.glEnd();
		 GL11.glLoadIdentity();
		
    }
    
    public boolean isExploded(){
    	return this.explode;
    }
    
    public void explode(boolean explode){
    	this.explode = explode;
	}

	@Override
	public void update(int delta) {
		
	}

}