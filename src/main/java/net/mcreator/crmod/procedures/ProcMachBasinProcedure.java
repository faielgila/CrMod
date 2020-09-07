package net.mcreator.crmod.procedures;

import net.mcreator.crmod.item.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.crmod.CrmodModElements;
import net.mcreator.crmod.SlotHelper;
import net.minecraft.item.Items;

import java.util.Map;

@CrmodModElements.ModElement.Tag
public class ProcMachBasinProcedure extends CrmodModElements.ModElement {
	public ProcMachBasinProcedure(CrmodModElements instance) {
		super(instance, 1003);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		System.out.println("Using abstracted code now!");
		
		// Throw a dependency error if entity is left empty
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for \"Chemical Basin Procedure\"!");
		}
		SlotHelper sltHlpr = new SlotHelper((Entity) dependencies.get("entity"));
		
		if (!areItemInSlotsValid(sltHlpr) && !areItemOutSlotsValid(sltHlpr)) return;
		
		processItem(sltHlpr);
	}

	public static boolean areItemInSlotsValid(SlotHelper slotHelper) {
		ItemStack[] itemStacks = new ItemStack[] {
				slotHelper.getItemStackInSlot(0),
				slotHelper.getItemStackInSlot(1),
				slotHelper.getItemStackInSlot(2),
				slotHelper.getItemStackInSlot(3),
				slotHelper.getItemStackInSlot(4),
				slotHelper.getItemStackInSlot(5)
		};
		for (ItemStack itemStack : itemStacks) return getSlotStatusForItem(itemStack) == SlotStatus.hasItem;
		return false;
	}
	public static boolean areItemOutSlotsValid(SlotHelper slotHelper) {
		ItemStack[] itemStacks = new ItemStack[] {
				slotHelper.getItemStackInSlot(7),
				slotHelper.getItemStackInSlot(8),
				slotHelper.getItemStackInSlot(9),
				slotHelper.getItemStackInSlot(10),
				slotHelper.getItemStackInSlot(11)
		};
		for (ItemStack itemStack : itemStacks) return getSlotStatusForItem(itemStack) == SlotStatus.empty;
		return false;
	}

	public static void processItem (SlotHelper sltHlpr) {
		System.out.println("Processing item...");
		
		// Salt Dust + Water Bucket -> Thorium + Sodium Hydroxide Solution
		if (sltHlpr.getItem(0) == Items.AIR && sltHlpr.getItem(1) == Items.AIR && sltHlpr.getItem(5) == Items.AIR) {
			if (sltHlpr.getItem(2) == AnodeCathodeItem.block && sltHlpr.getItem(3) == DustSaltItem.block && sltHlpr.getItem(4) == DustSaltItem.block) {
				if (sltHlpr.getItem(6) == Items.WATER_BUCKET) {
					sltHlpr.increaseItemAmountInSlot(3, -1);
					sltHlpr.increaseItemAmountInSlot(4, -1);
					sltHlpr.increaseItemAmountInSlot(6, -1);
					sltHlpr.setItemStackInSlot(11, new ItemStack(ChemSodiumHydroxideItem.block, 1));
					return;
				}
			}
		}
		
		// Thorite + Sodium Hydroxide Solution -> Thorium + TSP Solution
		if (sltHlpr.getItem(3) == Items.AIR && sltHlpr.getItem(4) == Items.AIR && sltHlpr.getItem(5) == Items.AIR) {
			if (sltHlpr.getItem(0) == ThoriteItem.block && sltHlpr.getItem(1) == ThoriteItem.block && sltHlpr.getItem(2) == ThoriteItem.block) {
				if (sltHlpr.getItem(6) == ChemSodiumHydroxideItem.block) {
					sltHlpr.increaseItemAmountInSlot(0, -1);
					sltHlpr.increaseItemAmountInSlot(1, -1);
					sltHlpr.increaseItemAmountInSlot(2, -1);
					sltHlpr.increaseItemAmountInSlot(6, -1);
					sltHlpr.setItemStackInSlot(10, new ItemStack(ThoriumItem.block, 2));
					sltHlpr.setItemStackInSlot(11, new ItemStack(ChemTSPItem.block, 1));
				}
			}
		}
		if (sltHlpr.getItem(0) == Items.AIR && sltHlpr.getItem(1) == Items.AIR && sltHlpr.getItem(2) == Items.AIR) {
			if (sltHlpr.getItem(3) == ThoriteItem.block && sltHlpr.getItem(4) == ThoriteItem.block && sltHlpr.getItem(5) == ThoriteItem.block) {
				if (sltHlpr.getItem(6) == ChemSodiumHydroxideItem.block) {
					sltHlpr.increaseItemAmountInSlot(3, -1);
					sltHlpr.increaseItemAmountInSlot(4, -1);
					sltHlpr.increaseItemAmountInSlot(5, -1);
					sltHlpr.increaseItemAmountInSlot(6, -1);
					sltHlpr.setItemStackInSlot(10, new ItemStack(ThoriumItem.block, 2));
					sltHlpr.setItemStackInSlot(11, new ItemStack(ChemTSPItem.block, 1));
				}
			}
		}
		
		System.out.println("Itemset not a valid input for this process.");
	}
	
	static SlotStatus getSlotStatusForItem (ItemStack itemStack, Item item, int amount) {
		if (itemStack == ItemStack.EMPTY) return SlotStatus.empty;
		if (itemStack.getItem() == item && itemStack.getCount() <= 64 - amount) return SlotStatus.itemMatch;
		if (itemStack.getItem() == item && itemStack.getCount() > 64 - amount) return SlotStatus.noSpace;
		if (itemStack.getItem() != item) return SlotStatus.itemMismatch;
		return SlotStatus.NULL;
	}
	static SlotStatus getSlotStatusForItem (ItemStack itemStack) {
		if (itemStack == ItemStack.EMPTY || itemStack.getItem() == Items.AIR) return SlotStatus.empty;
		if (itemStack != ItemStack.EMPTY) return SlotStatus.hasItem;
		return SlotStatus.NULL;
	}
	
	public enum SlotStatus {
		itemMatch, noSpace, itemMismatch, empty, NULL,
		hasItem
	}
}
