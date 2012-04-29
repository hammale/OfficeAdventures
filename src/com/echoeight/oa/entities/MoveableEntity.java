package com.echoeight.oa.entities;

public interface MoveableEntity extends Entity {
	public double getDX();
	public double getDY();
	public void setDX(double dx);
	public void setDY(double dy);
	public Gun getGun();
	public void setGun(Gun gun);
    enum Gun { NONE, PISTOL, SMG, GRENADE };
}
