package com.echoeight.oa.util;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class Fullscreen {
	
	public static boolean fullscreen;

	  public static void setDisplayMode(int width, int height, boolean fullscreen) {

	

	      if ((Display.getDisplayMode().getWidth() == width) && 

	          (Display.getDisplayMode().getHeight() == height) && 

	    (Display.isFullscreen() == fullscreen)) {

	        return;

	      }

	

	      try {

	          DisplayMode targetDisplayMode = null;

	      

	    if (fullscreen) {

	        DisplayMode[] modes = Display.getAvailableDisplayModes();

	        int freq = 0;

	          

	        for (int i=0;i<modes.length;i++) {

	            DisplayMode current = modes[i];

	            

	      if ((current.getWidth() == width) && (current.getHeight() == height)) {

	          if ((targetDisplayMode == null) || (current.getFrequency() >= freq)) {

	              if ((targetDisplayMode == null) || (current.getBitsPerPixel() > targetDisplayMode.getBitsPerPixel())) {

	            targetDisplayMode = current;

	            freq = targetDisplayMode.getFrequency();

	                          }

	                      }

	

	          if ((current.getBitsPerPixel() == Display.getDesktopDisplayMode().getBitsPerPixel()) &&

	                          (current.getFrequency() == Display.getDesktopDisplayMode().getFrequency())) {

	                              targetDisplayMode = current;

	                              break;

	                      }

	                  }

	              }

	          } else {

	              targetDisplayMode = new DisplayMode(width,height);

	          }

	

	          if (targetDisplayMode == null) {

	              System.out.println("Failed to find value mode: "+width+"x"+height+" fs="+fullscreen);

	              return;

	          }

	

	          Display.setDisplayMode(targetDisplayMode);

	          Display.setFullscreen(fullscreen);

	        

	      } catch (LWJGLException e) {

	          System.out.println("Unable to setup mode "+width+"x"+height+" fullscreen="+fullscreen + e);

	      }

	  }

	 
	
}
