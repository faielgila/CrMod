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
				slotHelper.getItemStack(0),
				slotHelper.getItemStack(1),
				slotHelper.getItemStack(2),
				slotHelper.getItemStack(3),
				slotHelper.getItemStack(4),
				slotHelper.getItemStack(5)
		};
		for (ItemStack itemStack : itemStacks) return getSlotStatusForItem(itemStack) == SlotStatus.hasItem;
		return false;
	}
	public static boolean areItemOutSlotsValid(SlotHelper slotHelper) {
		ItemStack[] itemStacks = new ItemStack[] {
				slotHelper.getItemStack(7),
				slotHelper.getItemStack(8),
				slotHelper.getItemStack(9),
				slotHelper.getItemStack(10),
				slotHelper.getItemStack(11)
		};
		for (ItemStack itemStack : itemStacks) return getSlotStatusForItem(itemStack) == SlotStatus.empty;
		return false;
	}

	public static void processItem (SlotHelper sltHlpr) {
		System.out.println("Processing item...");
		
		// Salt Dust + Water Bucket -> Sodium Hydroxide Solution
		if (sltHlpr.getItem(0) == Items.AIR && sltHlpr.getItem(1) == Items.AIR && sltHlpr.getItem(5) == Items.AIR) {
			if (sltHlpr.getItem(2) == AnodeCathodeItem.block && sltHlpr.getItem(3) == DustSaltItem.block && sltHlpr.getItem(4) == DustSaltItem.block) {
				if (sltHlpr.getItem(6) == Items.WATER_BUCKET) {
					sltHlpr.increaseItemAmount(3, -1);
					sltHlpr.increaseItemAmount(4, -1);
					sltHlpr.increaseItemAmount(6, -1);
					sltHlpr.setItemStack(11, new ItemStack(ChemSodiumHydroxideItem.block, 1));
					return;
				}
			}
		}
		
		// Thorite + Sodium Hydroxide Solution -> Thorium + TSP Solution
		if (sltHlpr.getItem(3) == Items.AIR && sltHlpr.getItem(4) == Items.AIR && sltHlpr.getItem(5) == Items.AIR) {
			if (sltHlpr.getItem(0) == ThoriteItem.block && sltHlpr.getItem(1) == ThoriteItem.block && sltHlpr.getItem(2) == ThoriteItem.block) {
				if (sltHlpr.getItem(6) == ChemSodiumHydroxideItem.block) {
					sltHlpr.increaseItemAmount(0, -1);
					sltHlpr.increaseItemAmount(1, -1);
					sltHlpr.increaseItemAmount(2, -1);
					sltHlpr.increaseItemAmount(6, -1);
					sltHlpr.setItemStack(10, new ItemStack(ThoriumItem.block, 2));
					sltHlpr.setItemStack(11, new ItemStack(ChemTSPItem.block, 1));
				}
			}
		}
		if (sltHlpr.getItem(0) == Items.AIR && sltHlpr.getItem(1) == Items.AIR && sltHlpr.getItem(2) == Items.AIR) {
			if (sltHlpr.getItem(3) == ThoriteItem.block && sltHlpr.getItem(4) == ThoriteItem.block && sltHlpr.getItem(5) == ThoriteItem.block) {
				if (sltHlpr.getItem(6) == ChemSodiumHydroxideItem.block) {
					sltHlpr.increaseItemAmount(3, -1);
					sltHlpr.increaseItemAmount(4, -1);
					sltHlpr.increaseItemAmount(5, -1);
					sltHlpr.increaseItemAmount(6, -1);
					sltHlpr.setItemStack(10, new ItemStack(ThoriumItem.block, 2));
					sltHlpr.setItemStack(11, new ItemStack(ChemTSPItem.block, 1));
				}
			}
		}
		
		// Sulfur Dioxide Oxidation
		if (sltHlpr.getItem(0) == Items.AIR && sltHlpr.getItem(1) == Items.AIR && sltHlpr.getItem(4) == Items.AIR && sltHlpr.getItem(5) == Items.AIR) {
			if (sltHlpr.getItem(2) == ChemVanadiumPentoxideItem.block && sltHlpr.getItem(3) == ChemSulfurDioxideItem.block) {
				if (sltHlpr.getItem(6) == Items.AIR) {
					sltHlpr.increaseItemAmount(2, -1);
					sltHlpr.increaseItemAmount(3, -1);
					
					sltHlpr.setItemStack(7, new ItemStack(ChemVanadiumPentoxideItem.block, 1));
					sltHlpr.setItemStack(11, new ItemStack(ChemSulfurTrioxideItem.block, 1));
				}
			}
		}
		
		// Sulfur Trioxide Hydration
		if (sltHlpr.getItem(0) == Items.AIR && sltHlpr.getItem(1) == Items.AIR && sltHlpr.getItem(2) == Items.AIR) {
			if (sltHlpr.getItem(4) == Items.AIR && sltHlpr.getItem(5) == Items.AIR) {
				if (sltHlpr.getItem(3) == ChemSulfurTrioxideItem.block && sltHlpr.getItem(6) == Items.WATER_BUCKET) {
					sltHlpr.increaseItemAmount(3, -1);
					sltHlpr.increaseItemAmount(6, -1);
					
					sltHlpr.setItemStack(11, new ItemStack(ChemSulfuricAcidItem.block, 1));
				}
			}
		}
		
		// Hydrofluoric Acid Production
		if (sltHlpr.getItem(0) == Items.AIR && sltHlpr.getItem(1) == Items.AIR && sltHlpr.getItem(2) == Items.AIR) {
			if (sltHlpr.getItem(4) == Items.AIR && sltHlpr.getItem(5) ==Items.AIR) {
				if (sltHlpr.getItem(3) == CrystalFluoItem.block && sltHlpr.getItem(6) == ChemSulfuricAcidItem.block) {
					sltHlpr.increaseItemAmount(3, -1);
					sltHlpr.increaseItemAmount(6, -1);
					
					sltHlpr.setItemStack(10, new ItemStack(ChemAnhydriteItem.block, 1));
					sltHlpr.setItemStack(11, new ItemStack(ChemHydrofluoricAcidItem.block, 1));
				}
			}
		}
		
		// Fluorine and Hydrogen Gas Production
		if (sltHlpr.getItem(0) == Items.GLASS_BOTTLE && sltHlpr.getItem(1) == Items.GLASS_BOTTLE && sltHlpr.getItem(4) == Items.AIR && sltHlpr.getItem(5) == Items.AIR) {
			if (sltHlpr.getItem(2) == AnodeCathodeItem.block && sltHlpr.getItem(3) == DustSaltItem.block) {
				if (sltHlpr.getItem(6) == ChemHydrofluoricAcidItem.block) {
					sltHlpr.increaseItemAmount(0, -1);
					sltHlpr.increaseItemAmount(1, -1);
					sltHlpr.increaseItemAmount(2, -1);
					sltHlpr.increaseItemAmount(3, -1);
					sltHlpr.increaseItemAmount(6, -1);
					
					sltHlpr.setItemStack(9, new ItemStack(ChemHydrogenItem.block, 1));
					sltHlpr.setItemStack(10, new ItemStack(ChemFluorineItem.block, 1));
					sltHlpr.setItemStack(11, new ItemStack(Items.BUCKET, 1));
				}
			}
		}
		
		// Lithium Fluoride Production
		if (sltHlpr.getItem(0) == Items.AIR && sltHlpr.getItem(1) == Items.AIR && sltHlpr.getItem(2) == Items.AIR) {
			if (sltHlpr.getItem(4) == Items.AIR && sltHlpr.getItem(5) == Items.AIR) {
				if (sltHlpr.getItem(3) == CrystalLithItem.block && sltHlpr.getItem(6) == ChemFluorineItem.block) {
					sltHlpr.increaseItemAmount(3, -1);
					sltHlpr.increaseItemAmount(6, -1);
					
					sltHlpr.setItemStack(10, new ItemStack(ChemLithiumFluorideItem.block, 1));
					sltHlpr.setItemStack(11, new ItemStack(Items.GLASS_BOTTLE, 1));
				}
			}
		}
		
		// Beryllium Fluoride Production
		if (sltHlpr.getItem(0) == Items.AIR && sltHlpr.getItem(1) == Items.AIR && sltHlpr.getItem(2) == Items.AIR) {
			if (sltHlpr.getItem(4) == Items.AIR && sltHlpr.getItem(5) == Items.AIR) {
				if (sltHlpr.getItem(3) == Items.EMERALD && sltHlpr.getItem(6) == ChemHydrofluoricAcidItem.block) {
					sltHlpr.increaseItemAmount(3, -1);
					sltHlpr.increaseItemAmount(6, -1);
					
					sltHlpr.setItemStack(9, new ItemStack(ChemKyaniteItem.block, 1));
					sltHlpr.setItemStack(10, new ItemStack(ChemBerylliumFluorideItem.block, 1));
					sltHlpr.setItemStack(11, new ItemStack(Items.GLASS_BOTTLE));
				}
			}
		}
		
		// FLiBe Salt Production
		if (sltHlpr.getItem(0) == Items.AIR && sltHlpr.getItem(1) == Items.AIR && sltHlpr.getItem(2) == Items.AIR) {
			if (sltHlpr.getItem(5) == Items.AIR) {
				if (sltHlpr.getItem(3) == ChemBerylliumFluorideItem.block && sltHlpr.getItem(4) == ChemLithiumFluorideItem.block) {
					if (sltHlpr.getItem(6) == Items.BUCKET) {
						sltHlpr.increaseItemAmount(3, -1);
						sltHlpr.increaseItemAmount(4, -1);
						sltHlpr.increaseItemAmount(6, -1);
						
						sltHlpr.setItemStack(11, new ItemStack(ChemFLiBeSaltItem.block, 1));
					}
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
