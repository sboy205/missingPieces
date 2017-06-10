/**
 * 
 */
package com.sb205.missing_pieces.MpBlocks;

import net.minecraft.util.IStringSerializable;

/**
 * @author US980705
 *
 */
public enum EnumChairTypes implements IStringSerializable {
	SPINDLE(0,0, "spindle"), 
	STRAIGHT(1,4, "straight"), 
	TALL(2,8,  "tall"), 
	ADIRONDACK(3,12, "adirondack");

	private int index;
	private String name;
	private int meta;
	
	private EnumChairTypes(int indexIn, int metaIn, String nameIn){
		this.index = indexIn;
		this.name = nameIn;
		this.meta = metaIn;
	}
	
	static public EnumChairTypes getType( int meta){
		// search through list of values to find a match
		for( EnumChairTypes chairType: values()){
			// if a match if found, return it.
			if (chairType.meta == (meta & 0xC)){
				//System.out.println("found type: " + chairType.name);
				return chairType;
			}
		}
		// if we don't find one... return Spindle by default
		System.out.println("returning SPINDLE");
		return (SPINDLE);
	}
	public EnumChairTypes getType(){
		return this;
	}
	static public int getMeta( EnumChairTypes chairType){
		switch(chairType){
		default:
		case SPINDLE:
			//System.out.println("Spindle:" + SPINDLE.meta);
			return SPINDLE.meta;
		case STRAIGHT:
			//System.out.println("Straight:" + STRAIGHT.meta);
			return STRAIGHT.meta;
		case TALL:
			//System.out.println("Padded:" + PADDED.meta);
			return TALL.meta;
		case ADIRONDACK:
			//System.out.println("Adirondack:" + ADIRONDACK.meta);
			return ADIRONDACK.meta;
			
		}
	}
	public int getMeta(){
		//System.out.println(" Type: "+this.name + " Meta: "+this.meta);
		return this.meta;
	}
	static public int getMin(){
		return 0;
	}
	static public int getMax(){
		return 3;
	}
	
	@Override
	public String getName() {
		return this.name;
	}

}
