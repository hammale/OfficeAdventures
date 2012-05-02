package com.echoeight.oa.images;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;

public class LoadImageMap {
	
	static Image textures;
	
	public static void LoadTexture() {
		try {
			textures = new Image("res/textures.png");
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public static Texture getDudeImage(int dir){
		Image dude = null;
		if(dir == 0){
			dude = textures.getSubImage(0, 0, 25, 49);
		}else if(dir == 1){
			//dude = textures.getSubImage(0, 25, 25, 49);
		}else if(dir == 2){
			
		}else if(dir == 3){
			
		}else if(dir == 4){
			
		}else if(dir == 5){
			
		}else if(dir == 6){
			
		}else if(dir == 7){
			
		}
		return dude.getTexture();
	}
	
}
