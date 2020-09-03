package net.mcreator.crmod.procedures;

import net.mcreator.crmod.CrmodModElements;
import net.mcreator.crmod.SlotHelper;

import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Map;

import net.mcreator.crmod.block.*;
import net.mcreator.crmod.item.*;
import net.minecraft.item.Items;

@CrmodModElements.ModElement.Tag
public class MachSplitterNewProcedure extends CrmodModElements.ModElement {
	public MachSplitterNewProcedure(CrmodModElements instance) {
		super(instance, 1001);
		init_processingTable();
	}
	
	public static void executeProcedure(Map<String, Object> dependencies){
		System.out.println("Using abstracted code now!");
		
		// Throw a dependency error if entity is left empty
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SimpProc!");
		}
		
		SlotHelper sltHlpr = new SlotHelper((Entity) dependencies.get("entity"));
		
		if (!areItemSlotsValid(sltHlpr)) return;
		
		processItem(sltHlpr, sltHlpr.getItemStackInSlot(0).getItem());
	}
	
	public static boolean isPowerInSlotValid  (SlotHelper slotHelper) {
		return slotHelper.getItemStackInSlot(7).getItem() == BatteryItem.block;
	}
	public static boolean isPowerOutSlotValid (SlotHelper slotHelper) {
		ItemStack slotItemStack = slotHelper.getItemStackInSlot(8);
		return slotItemStack.getItem() == BatteryUsedItem.block || slotItemStack == ItemStack.EMPTY;
	}
	public static boolean isItemInSlotValid   (SlotHelper slotHelper) {
		ItemStack slotItemStack = slotHelper.getItemStackInSlot(0);
		return slotItemStack != ItemStack.EMPTY;
	}
	public static boolean areItemSlotsValid   (SlotHelper slotHelper) {
		return isPowerInSlotValid(slotHelper) && isPowerOutSlotValid(slotHelper) && isItemInSlotValid(slotHelper);
	}
	
	public static Dictionary<Item, ProcessorOutput> processingTable = new Hashtable<>();
	public static void init_processingTable () {
		processingTable.put(IngotAlemItem.block, new ProcessorOutput(new Item[]{ElemAeItem.block}, new int[]{4}));
		processingTable.put(Items.IRON_INGOT, new ProcessorOutput(new Item[]{ElemFeItem.block}, new int[]{4}));
	}
	
	public static void processItem (SlotHelper slotHelper, Item itemIn) {
		if (processingTable.get(itemIn) == null) { return; }
		Item[] itemsOut = processingTable.get(itemIn).itemsOut;
		
		boolean canFitAllItems = true;
		for (Item itemOut : itemsOut) {
			if (can_putItemInBestSlot(slotHelper, itemOut)) canFitAllItems = false;
		}
		if (canFitAllItems) {
			for (Item itemOut : itemsOut) {
				putItemInBestSlot(slotHelper, itemOut, 4);
			}
		}
	}
	private static boolean can_putItemInBestSlot (SlotHelper slotHelper, Item item){
		int bestMatchingSlot = getBestMatchingSlotForItem(slotHelper, item);
		int bestEmptySlot = getFirstEmptySlot(slotHelper);
		
		if (bestMatchingSlot == -1 && bestEmptySlot == -1) { System.out.println("No output slots available!"); return false; }
		return true;
	}
	private static void putItemInBestSlot (SlotHelper slotHelper, Item item, int amount) {
		int bestMatchingSlot = getBestMatchingSlotForItem(slotHelper, item);
		int bestEmptySlot = getFirstEmptySlot(slotHelper);
		
		if (bestMatchingSlot != -1) slotHelper.increaseItemAmountInSlot(bestMatchingSlot, amount);
		if (bestMatchingSlot == -1) slotHelper.setItemStackInSlot(bestEmptySlot, new ItemStack(item, amount));
	}
	private static int getBestMatchingSlotForItem (SlotHelper slotHelper, Item item) {
		ItemStack[] outputItemStacks = SlotHelper.groupItemStacks(
				slotHelper.getItemStackInSlot(1),
				slotHelper.getItemStackInSlot(2),
				slotHelper.getItemStackInSlot(3),
				slotHelper.getItemStackInSlot(4),
				slotHelper.getItemStackInSlot(5),
				slotHelper.getItemStackInSlot(6)
		);
		int slotMatch = -1;
		
		for (int i = outputItemStacks.length - 1; i > 0; i--) {
			if (outputItemStacks[i].getItem() == item) slotMatch = i;
		}
		
		return slotMatch;
	}
	private static int getFirstEmptySlot (SlotHelper slotHelper) {
		ItemStack[] outputItemStacks = SlotHelper.groupItemStacks(
				slotHelper.getItemStackInSlot(1),
				slotHelper.getItemStackInSlot(2),
				slotHelper.getItemStackInSlot(3),
				slotHelper.getItemStackInSlot(4),
				slotHelper.getItemStackInSlot(5),
				slotHelper.getItemStackInSlot(6)
		);
		int slotEmpty = -1;
		
		for (int i = outputItemStacks.length - 1; i > 0; i--) {
			if (outputItemStacks[i] == ItemStack.EMPTY) slotEmpty = i;
		}
		
		return slotEmpty;
	}
	
	public static class ProcessorOutput {
		public Item[] itemsOut;
		public int[] amountsOut;
		
		public ProcessorOutput (Item[] _itemsOut, int[] _amountsOut) {
			itemsOut = _itemsOut;
			amountsOut = _amountsOut;
		}
	}
}
