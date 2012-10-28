package com.bignlp.langy.metamap.result;

import com.bignlp.langy.metamap.Position;

public class MetaMapPosition implements Position {
	private int x;
	private int y;

	public MetaMapPosition() {
		super();
	}

	public MetaMapPosition(int argsX, int argsY) {
		super();
		this.x = argsX;
		this.y = argsY;
	}

	public int getX() {
		return this.x;
	}

	public void setX(int argsX) {
		this.x = argsX;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int argsY) {
		this.y = argsY;
	}

}
