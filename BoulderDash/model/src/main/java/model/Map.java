package model;

import java.util.ArrayList;

import model.element.IElement;

public class Map implements IMap {
	private int width;
	private int height;
	private IElement[][] onTheMap;
	private ArrayList<IFall> falls;
	private ArrayList<IMob> mobs;
	private IMobile myCharacter;
	
	public Map(int level) {
		
	}
	
	
}
