package com.echoeight.oa.images;

import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import com.echoeight.oa.entities.MoveableEntity.Gun;

public class LoadTextures {

	static Texture dude;
	static Texture fdude;
	static Texture pistol;
	static Texture fpistol;
	static Texture smg;
	static Texture fsmg;
	static Texture gre;
	static Texture fgre;
	
	static Texture ladder;
	
	public static void LoadAll() {
		try {
			loadDude();
			loadLadder();
			System.out.println("loaded all");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void loadDude() throws IOException {
		dude = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/man1.png"));
		fdude = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/man2.png"));
		pistol = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/gun1.png"));
		fpistol = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/gun2.png"));
		smg = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/smg2.png"));
		fsmg = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/smg1.png"));
		gre = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/gre2.png"));
		fgre = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/gre1.png"));		
	}
	
	private static void loadLadder() throws IOException {
		ladder = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/ladder.png"));
	}	

	public static Texture getLadder(){
		return ladder;
	}
	
	public static Texture getDude(boolean flip, Gun gun){
		if(!flip){
			if(gun == Gun.PISTOL){
				return fpistol;
			}else if(gun == Gun.SMG){
				return fsmg;
			}else if(gun == Gun.GRENADE){
				return fgre;
			}else if(gun == Gun.NONE){
				return fdude;
			}
		}else{
			if(gun == Gun.PISTOL){
				return pistol;
			}else if(gun == Gun.SMG){
				return smg;
			}else if(gun == Gun.GRENADE){
				return gre;
			}else if(gun == Gun.NONE){
				return dude;
			}
		}
		return dude;
	}
}
