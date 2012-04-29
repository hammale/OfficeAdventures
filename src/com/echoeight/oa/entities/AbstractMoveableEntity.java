package com.echoeight.oa.entities;

public abstract class AbstractMoveableEntity extends AbstractEntity implements MoveableEntity {
	 
    protected double dx ,dy;
    protected Gun manGun;
    
    public AbstractMoveableEntity(double x, double y, double width,
                    double height, Gun gun) {
            super(x, y, width, height);
            this.dx = 0;
            this.dy = 0;
            manGun = gun;            
    }
   
    @Override
    public void update(int delta) {
            this.x += delta * dx;
            this.y += delta * dy;
    }
    public double getDX() {
            return dx;
    }
    public Gun getGun() {
    	return manGun;
    }
    public void setGun(Gun gun) {
    	manGun = gun;
    }
    public double getDY() {
            return dy;
    }
    public void setDX(double dx) {
            this.dx = dx;
    }
    public void setDY(double dy) {
            this.dy = dy;
    }
	public static class Guns {
		static Gun gun;
	    
	    public Guns(Gun gun) {
	        Guns.gun = gun;
	    }
	
	}
    
}
