package com.mrh0.createaddition.energy;

import com.mrh0.createaddition.index.*;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;;

public enum WireType {
	COPPER(0, 256, 78, 37, 30, CAItems.COPPER_WIRE.asStack(4), CAItems.COPPER_SPOOL.asStack()),
	GOLD(1, 1024, 98, 83, 29, CAItems.GOLD_WIRE.asStack(4), CAItems.GOLD_SPOOL.asStack()),
	ELECTRUM(2, 8196, 88, 66, 37, CAItems.ELECTRUM_WIRE.asStack(4), CAItems.ELECTRUM_SPOOL.asStack()),
	SUPERCONDUCTING(4, 2147483647, 134, 146, 252, CAItems.SUPERCONDUCTING_WIRE.asStack(4), CAItems.SUPERCONDUCTING_SPOOL.asStack()),
	FESTIVE(3, 256, 26, 94, 12, CAItems.COPPER_WIRE.asStack(4), CAItems.FESTIVE_SPOOL.asStack());

	private final int ID, TRANSFER, CR, CG, CB;
	private final ItemStack DROP;
	private final ItemStack SOURCE_DROP;

	WireType(int id, int transfer, int red, int green, int blue, ItemStack drop, ItemStack source) {
		ID = id;
		TRANSFER = transfer;
		CR = red;
		CG = green;
		CB = blue;
		DROP = drop;
		SOURCE_DROP = source;
	}

	public static WireType fromIndex(int index) {
		return switch (index) {
			case 0 -> COPPER;
			case 1 -> GOLD;
			case 2 -> ELECTRUM;
			case 3 -> FESTIVE;
			case 4 -> SUPERCONDUCTING;
			default -> null;
		};
	}

	public int getIndex() {
		return ID;
	}

	public ItemStack getDrop() {
		return DROP.copy();
	}

	public ItemStack getSourceDrop() {
		return SOURCE_DROP.copy();
	}

	public int transfer() {
		return TRANSFER;
	}

	public int getRed() {
		return CR;
	}

	public int getGreen() {
		return CG;
	}

	public int getBlue() {
		return CB;
	}

	public boolean isFestive( ) {
		return this == FESTIVE;
	}

	public static WireType of(Item item) {
		if(item == CAItems.COPPER_SPOOL.get())
			return WireType.COPPER;
		if(item == CAItems.GOLD_SPOOL.get())
			return WireType.GOLD;
		if(item == CAItems.FESTIVE_SPOOL.get())
			return WireType.FESTIVE;
		if(item == CAItems.SUPERCONDUCTING_SPOOL.get())
			return WireType.SUPERCONDUCTING;
		if(item == CAItems.ELECTRUM_SPOOL.get())
			return WireType.ELECTRUM;
		return WireType.COPPER;
	}
}
