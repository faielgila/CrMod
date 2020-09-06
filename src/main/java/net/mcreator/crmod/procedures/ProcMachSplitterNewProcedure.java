package net.mcreator.crmod.procedures;

import net.mcreator.crmod.SlotHelper;
import net.mcreator.crmod.block.*;
import net.mcreator.crmod.item.*;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.crmod.CrmodModElements;
import net.minecraft.item.Items;

import java.util.Map;

@CrmodModElements.ModElement.Tag
public class ProcMachSplitterNewProcedure extends CrmodModElements.ModElement {
	public ProcMachSplitterNewProcedure(CrmodModElements instance) {
		super(instance, 289);
	}
	
	public static void executeProcedure(Map<String, Object> dependencies){
		System.out.println("Using abstracted code now!");
		
		System.out.println("Initializing processing lookup table...");
		
		// Throw a dependency error if entity is left empty
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SimpProc!");
		}
		
		SlotHelper sltHlpr = new SlotHelper((Entity) dependencies.get("entity"));
		
		if (!areItemSlotsValid(sltHlpr)) return;
		
		System.out.println("Beginning item processing...");
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
	
	public static Item[] getItemsOut (Item itemIn){
		
		/// Bloc A
		// Iron
		if (itemIn == Items.IRON_ORE) return new Item[] {ElemFeItem.block, ElemOItem.block};
		if (itemIn == Items.IRON_INGOT) return new Item[] {ElemFeItem.block};
		if (itemIn == Items.IRON_BLOCK) return new Item[] {ElemFeItem.block};
		if (itemIn == DustIronItem.block) return new Item[] {ElemFeItem.block};
		if (itemIn == PlateIronItem.block) return new Item[] {ElemFeItem.block};
		
		// Coal
		if (itemIn == Items.COAL_ORE) return new Item[] {ElemCItem.block, ElemOItem.block};
		if (itemIn == Items.COAL) return new Item[] {ElemCItem.block};
		if (itemIn == Items.CHARCOAL) return new Item[] {ElemCItem.block, ElemOItem.block, ElemHItem.block};
		if (itemIn == Items.COAL_BLOCK) return new Item[] {ElemCItem.block};
		
		// Diamond
		if (itemIn == Items.DIAMOND_ORE) return new Item[] {ElemCItem.block, ElemOItem.block, ElemHItem.block};
		if (itemIn == Items.DIAMOND) return new Item[] {ElemCItem.block};
		if (itemIn == Items.DIAMOND_BLOCK) return new Item[] {ElemCItem.block};
		
		// Emerald
		if (itemIn == Items.EMERALD_ORE) return new Item[] {ElemBeItem.block, ElemSiItem.block, ElemOItem.block};
		if (itemIn == Items.EMERALD) return new Item[] {ElemBeItem.block, ElemSiItem.block, ElemOItem.block, ElemAlItem.block, ElemVItem.block, ElemCrItem.block};
		if (itemIn == Items.EMERALD_BLOCK) return new Item[] {ElemBeItem.block, ElemSiItem.block, ElemOItem.block, ElemAlItem.block, ElemVItem.block, ElemCrItem.block};
		
		// Lapis
		if (itemIn == Items.LAPIS_ORE) return new Item[] {ElemNaItem.block, ElemAlItem.block};
		if (itemIn == Items.LAPIS_LAZULI) return new Item[] {ElemNaItem.block, ElemAlItem.block, ElemOItem.block, ElemCItem.block, ElemCaItem.block, ElemSItem.block};
		if (itemIn == Items.LAPIS_BLOCK) return new Item[] {ElemNaItem.block, ElemAlItem.block, ElemOItem.block, ElemCItem.block, ElemCaItem.block, ElemSItem.block};
		
		// Redstone
		if (itemIn == Items.REDSTONE_ORE) return new Item[] {ElemMnItem.block, ElemOItem.block};
		if (itemIn == Items.REDSTONE) return new Item[] {ElemMnItem.block, ElemOItem.block, ElemCItem.block, ElemCuItem.block, ElemAuItem.block};
		if (itemIn == Items.REDSTONE_BLOCK) return new Item[] {ElemMnItem.block, ElemOItem.block, ElemCItem.block, ElemCuItem.block, ElemAuItem.block};
		
		// Stone
		if (itemIn == Items.COBBLESTONE) return new Item[] {ElemCItem.block, ElemOItem.block, ElemCaItem.block, ElemMgItem.block};
		
		// Gold
		if (itemIn == Items.GOLD_ORE) return new Item[] {ElemAuItem.block, ElemAgItem.block};
		if (itemIn == Items.GOLD_INGOT) return new Item[] {ElemAuItem.block};
		if (itemIn == Items.GOLD_BLOCK) return new Item[] {ElemAuItem.block};
		if (itemIn == DustGoldItem.block) return new Item[] {ElemAuItem.block};
		if (itemIn == PlateGoldItem.block) return new Item[] {ElemAuItem.block};
		
		
		/// Bloc B
		// Alemonium
		if (itemIn == OreAlemBlock.block.asItem()) return new Item[] {ElemAeItem.block};
		if (itemIn == IngotAlemItem.block) return new Item[] {ElemAeItem.block};
		if (itemIn == BlockAlemBlock.block.asItem()) return new Item[] {ElemAeItem.block};
		if (itemIn == DustAlemItem.block) return new Item[] {ElemAeItem.block};
		if (itemIn == PlateAlemItem.block) return new Item[] {ElemAeItem.block};
		
		// Azurite
		if (itemIn == OreAzurBlock.block.asItem()) return new Item[] {ElemCuItem.block, ElemOItem.block};
		if (itemIn == GemAzurItem.block) return new Item[] {ElemCuItem.block, ElemOItem.block};
		if (itemIn == DustAzurItem.block) return new Item[] {ElemCuItem.block, ElemOItem.block};
		
		// Blaze
		if (itemIn == IngotBlazItem.block) return new Item[] {ElemEpItem.block, ElemCtItem.block, ElemWhItem.block};
		if (itemIn == BlockBlazBlock.block.asItem()) return new Item[] {ElemEpItem.block, ElemCtItem.block, ElemWhItem.block};
		if (itemIn == DustBlazItem.block) return new Item[] {ElemEpItem.block, ElemCtItem.block, ElemWhItem.block};
		if (itemIn == PlateBlazItem.block) return new Item[] {ElemEpItem.block, ElemCtItem.block, ElemWhItem.block};
		
		// Carnotite
		if (itemIn == OreCarnBlock.block.asItem()) return new Item[] {ElemKItem.block, ElemOItem.block};
		if (itemIn == CarnotiteItem.block) return new Item[] {ElemKItem.block, ElemVItem.block, ElemUItem.block};
		if (itemIn == DustCarnItem.block) return new Item[] {ElemKItem.block, ElemVItem.block, ElemUItem.block};
		
		// Chromite
		if (itemIn == OreChroBlock.block.asItem()) return new Item[] {ElemCrItem.block, ElemOItem.block};
		if (itemIn == ChromiteItem.block) return new Item[] {ElemCrItem.block};
		
		
		/// Bloc C
		// Copper
		if (itemIn == IngotCoprItem.block) return new Item[] {ElemCuItem.block};
		if (itemIn == BlockCoprBlock.block.asItem()) return new Item[] {ElemCuItem.block};
		if (itemIn == DustCoprItem.block) return new Item[] {ElemCuItem.block};
		if (itemIn == PlateCoprItem.block) return new Item[] {ElemCuItem.block};
		
		// Cuprite
		if (itemIn == OreCuprBlock.block.asItem()) return new Item[] {ElemOItem.block};
		if (itemIn == GemCuprItem.block) return new Item[] {ElemCuItem.block, ElemOItem.block};
		if (itemIn == DustCuprItem.block) return new Item[] {ElemCuItem.block, ElemOItem.block};
		
		// Heliodor (Beryl)
		if (itemIn == OreBeryBlock.block.asItem()) return new Item[] {ElemBeItem.block, ElemOItem.block};
		if (itemIn == GemBeryItem.block) return new Item[] {ElemBeItem.block, ElemOItem.block};
		if (itemIn == DustBeryItem.block) return new Item[] {ElemBeItem.block, ElemOItem.block};
		
		// Lead
		if (itemIn == OreLeadBlock.block.asItem()) return new Item[] {ElemPbItem.block, ElemOItem.block};
		if (itemIn == IngotLeadItem.block) return new Item[] {ElemPbItem.block};
		if (itemIn == DustLeadItem.block) return new Item[] {ElemPbItem.block};
		if (itemIn == PlateLeadItem.block) return new Item[] {ElemPbItem.block};
		if (itemIn == BlockLeadBlock.block.asItem()) return new Item[] {ElemPbItem.block};
		
		// Lithium
		if (itemIn == OreLithBlock.block.asItem()) return new Item[] {ElemLiItem.block, ElemOItem.block};
		if (itemIn == CrystalLithItem.block) return new Item[] {ElemLiItem.block};
		
		// Malachite
		if (itemIn == OreMalaBlock.block.asItem()) return new Item[] {ElemCuItem.block, ElemOItem.block};
		if (itemIn == GemMalaItem.block) return new Item[] {ElemCuItem.block, ElemOItem.block};
		if (itemIn == DustMalaItem.block) return new Item[] {ElemCuItem.block, ElemOItem.block};
		
		
		/// Bloc D
		// Paradaxium
		if (itemIn == OreParaBlock.block.asItem()) return new Item[] {ElemPxItem.block, ElemOItem.block};
		if (itemIn == GemParaUnstableItem.block) return new Item[] {ElemPxItem.block};
		
		// Pyrite
		if (itemIn == OrePyrtBlock.block.asItem()) return new Item[] {ElemFeItem.block, ElemSItem.block, ElemOItem.block};
		if (itemIn == CrystalPyrtItem.block) return new Item[] {ElemFeItem.block, ElemSItem.block};
		if (itemIn == BlockPyrtBlock.block.asItem()) return new Item[] {ElemFeItem.block, ElemSItem.block};
		
		// Pyrolusite
		if (itemIn == OrePyroBlock.block.asItem()) return new Item[] {ElemMnItem.block, ElemOItem.block};
		if (itemIn == PyrolusiteItem.block) return new Item[] {ElemMnItem.block};
		
		// Salt
		if (itemIn == OreSaltBlock.block.asItem()) return new Item[] {ElemNaItem.block, ElemClItem.block, ElemOItem.block};
		if (itemIn == CrystalSaltItem.block) return new Item[] {ElemNaItem.block, ElemClItem.block};
		if (itemIn == DustSaltItem.block) return new Item[] {ElemNaItem.block, ElemClItem.block};
		
		// Steel
		if (itemIn == IngotSteeItem.block) return new Item[] {ElemFeItem.block, ElemCItem.block};
		if (itemIn == DustSteeItem.block) return new Item[] {ElemFeItem.block, ElemCItem.block};
		if (itemIn == PlateSteeItem.block) return new Item[] {ElemFeItem.block, ElemCItem.block};
		if (itemIn == BlockSteeBlock.block.asItem()) return new Item[] {ElemFeItem.block, ElemCItem.block};
		
		
		/// Bloc E
		// Sulfur
		if (itemIn == OreSulfBlock.block.asItem()) return new Item[] {ElemSItem.block, ElemOItem.block};
		if (itemIn == DustSulfurItem.block) return new Item[] {ElemSItem.block};
		
		// Urac
		if (itemIn == OreUracBlock.block.asItem()) return new Item[] {ElemPbItem.block, ElemWhItem.block, ElemOItem.block};
		if (itemIn == IngotUracItem.block) return new Item[] {ElemPbItem.block, ElemWhItem.block};
		if (itemIn == DustUracItem.block) return new Item[] {ElemPbItem.block, ElemWhItem.block};
		if (itemIn == BlockUracBlock.block.asItem()) return new Item[] {ElemPbItem.block, ElemWhItem.block};
		
		// Uraze
		if (itemIn == IngotUrazItem.block) return new Item[] {ElemPbItem.block, ElemEpItem.block, ElemWhItem.block, ElemCtItem.block};
		if (itemIn == DustUrazItem.block) return new Item[] {ElemPbItem.block, ElemEpItem.block, ElemWhItem.block, ElemCtItem.block};
		if (itemIn == PlateUrazItem.block) return new Item[] {ElemPbItem.block, ElemEpItem.block, ElemWhItem.block, ElemCtItem.block};
		if (itemIn == BlockUrazBlock.block.asItem()) return new Item[] {ElemPbItem.block, ElemEpItem.block, ElemWhItem.block, ElemCtItem.block};
		
		return null;
	}
	public static int[] getAmountsOut (Item itemIn){
		
		/// Bloc A
		// Iron
		if (itemIn == Items.IRON_ORE) return new int[] {2, 2};
		if (itemIn == Items.IRON_INGOT) return new int[] {4};
		if (itemIn == Items.IRON_BLOCK) return new int[] {36};
		if (itemIn == DustIronItem.block) return new int[] {4};
		if (itemIn == PlateIronItem.block) return new int[] {4};
		
		// Coal
		if (itemIn == Items.COAL_ORE) return new int[] {2, 2};
		if (itemIn == Items.COAL) return new int[] {4};
		if (itemIn == Items.CHARCOAL) return new int[] {2, 1, 1};
		if (itemIn == Items.COAL_BLOCK) return new int[] {36};
		
		// Diamond
		if (itemIn == Items.DIAMOND_ORE) return new int[] {4, 2, 2};
		if (itemIn == Items.DIAMOND) return new int[] {8};
		if (itemIn == Items.DIAMOND_BLOCK) return new int[] {64};
		
		// Emerald
		if (itemIn == Items.EMERALD_ORE) return new int[] {1, 1, 2};
		if (itemIn == Items.EMERALD) return new int[] {3, 3, 9, 2, 1, 1};
		if (itemIn == Items.EMERALD_BLOCK) return new int[] {27, 27, 63, 18, 9, 9};
		
		// Lapis
		if (itemIn == Items.LAPIS_ORE) return new int[] {2, 2};
		if (itemIn == Items.LAPIS_LAZULI) return new int[] {6, 6, 27, 1, 3, 2};
		if (itemIn == Items.LAPIS_BLOCK) return new int[] {54, 54, 64, 9, 27, 18};
		
		// Redstone
		if (itemIn == Items.REDSTONE_ORE) return new int[] {1, 3};
		if (itemIn == Items.REDSTONE) return new int[] {1, 3, 1, 1, 1};
		if (itemIn == Items.REDSTONE_BLOCK) return new int[] {9, 27, 9, 9, 9};
		
		// Stone
		if (itemIn == Items.COBBLESTONE) return new int[] {2, 6, 1, 1};
		
		// Gold
		if (itemIn == Items.GOLD_ORE) return new int[] {2, 2};
		if (itemIn == Items.GOLD_INGOT) return new int[] {4};
		if (itemIn == Items.GOLD_BLOCK) return new int[] {36};
		if (itemIn == DustGoldItem.block) return new int[] {4};
		if (itemIn == PlateGoldItem.block) return new int[] {4};
		
		
		/// Bloc B
		// Alemonium
		if (itemIn == OreAlemBlock.block.asItem()) return new int[] {1};
		if (itemIn == IngotAlemItem.block) return new int[] {4};
		if (itemIn == BlockAlemBlock.block.asItem()) return new int[] {36};
		if (itemIn == DustAlemItem.block) return new int[] {4};
		if (itemIn == PlateAlemItem.block) return new int[] {4};
		
		// Azurite
		if (itemIn == OreAzurBlock.block.asItem()) return new int[] {1, 3};
		if (itemIn == GemAzurItem.block) return new int[] {2, 2};
		if (itemIn == DustAzurItem.block) return new int[] {2, 2};
		
		// Blaze
		if (itemIn == IngotBlazItem.block) return new int[] {2, 1, 1};
		if (itemIn == BlockBlazBlock.block.asItem()) return new int[] {18, 9, 9};
		if (itemIn == DustBlazItem.block) return new int[] {2, 1, 1};
		if (itemIn == PlateBlazItem.block) return new int[] {2, 1, 1};
		
		// Carnotite
		if (itemIn == OreCarnBlock.block.asItem()) return new int[] {1, 3};
		if (itemIn == CarnotiteItem.block) return new int[] {2, 1, 2};
		if (itemIn == DustCarnItem.block) return new int[] {2, 1, 2};
		
		// Chromite
		if (itemIn == OreChroBlock.block.asItem()) return new int[] {2, 2};
		if (itemIn == ChromiteItem.block) return new int[] {4};
		
		
		/// Bloc C
		// Copper
		if (itemIn == IngotCoprItem.block) return new int[] {4};
		if (itemIn == BlockCoprBlock.block.asItem()) return new int[] {36};
		if (itemIn == DustCoprItem.block) return new int[] {4};
		if (itemIn == PlateCoprItem.block) return new int[] {4};
		
		// Cuprite
		if (itemIn == OreCuprBlock.block.asItem()) return new int[] {4};
		if (itemIn == GemCuprItem.block) return new int[] {2, 2};
		if (itemIn == DustCuprItem.block) return new int[] {2, 2};
		
		// Heliodor (Beryl)
		if (itemIn == OreBeryBlock.block.asItem()) return new int[] {2, 2};
		if (itemIn == GemBeryItem.block) return new int[] {3, 1};
		if (itemIn == DustBeryItem.block) return new int[] {3, 1};
		
		// Lead
		if (itemIn == OreLeadBlock.block.asItem()) return new int[] {2, 2};
		if (itemIn == IngotLeadItem.block) return new int[] {4};
		if (itemIn == DustLeadItem.block) return new int[] {4};
		if (itemIn == PlateLeadItem.block) return new int[] {4};
		if (itemIn == BlockLeadBlock.block.asItem()) return new int[] {4};
		
		// Lithium
		if (itemIn == OreLithBlock.block.asItem()) return new int[] {2, 2};
		if (itemIn == CrystalLithItem.block) return new int[] {4};
		
		// Malachite
		if (itemIn == OreMalaBlock.block.asItem()) return new int[] {2, 2};
		if (itemIn == GemMalaItem.block) return new int[] {3, 1};
		if (itemIn == DustMalaItem.block) return new int[] {3, 1};
		
		
		/// Bloc D
		// Paradaxium
		if (itemIn == OreParaBlock.block.asItem()) return new int[] {2, 2};
		if (itemIn == GemParaUnstableItem.block) return new int[] {4};
		
		// Pyrite
		if (itemIn == OrePyrtBlock.block.asItem()) return new int[] {1, 1, 2};
		if (itemIn == CrystalPyrtItem.block) return new int[] {3, 1};
		if (itemIn == BlockPyrtBlock.block.asItem()) return new int[] {9, 27};
		
		// Pyrolusite
		if (itemIn == OrePyroBlock.block.asItem()) return new int[] {1, 3};
		if (itemIn == PyrolusiteItem.block) return new int[] {4};
		
		// Salt
		if (itemIn == OreSaltBlock.block.asItem()) return new int[] {1, 1, 2};
		if (itemIn == CrystalSaltItem.block) return new int[] {2, 2};
		if (itemIn == DustSaltItem.block) return new int[] {2, 2};
		
		// Steel
		if (itemIn == IngotSteeItem.block) return new int[] {3, 1};
		if (itemIn == DustSteeItem.block) return new int[] {3, 1};
		if (itemIn == PlateSteeItem.block) return new int[] {3, 1};
		if (itemIn == BlockSteeBlock.block.asItem()) return new int[] {27, 9};
		
		
		/// Bloc E
		// Sulfur
		if (itemIn == OreSulfBlock.block.asItem()) return new int[] {2, 2};
		if (itemIn == DustSulfurItem.block) return new int[] {4};
		
		// Urac
		if (itemIn == OreUracBlock.block.asItem()) return new int[] {1, 1, 2};
		if (itemIn == IngotUracItem.block) return new int[] {2, 2};
		if (itemIn == DustUracItem.block) return new int[] {2, 2};
		if (itemIn == BlockUracBlock.block.asItem()) return new int[] {18, 18};
		
		// Uraze
		if (itemIn == IngotUrazItem.block) return new int[] {4, 2, 1, 1};
		if (itemIn == DustUrazItem.block) return new int[] {4, 2, 1, 1};
		if (itemIn == PlateUrazItem.block) return new int[] {4, 2, 1, 1};
		if (itemIn == BlockUrazBlock.block.asItem()) return new int[] {36, 18, 9, 9};
		
		return null;
	}
	
	public static void processItem (SlotHelper slotHelper, Item itemIn) {
		System.out.println("Begun processing for " + itemIn.toString());
		Item[] itemsOut = getItemsOut(itemIn);
		int[] amountsOut = getAmountsOut(itemIn);
		if (itemsOut == null || amountsOut == null) { System.out.println("Item" + itemIn +" not a recognized input for this machine. Process aborted."); return; }
		
		System.out.println("Checking output slots...");
		int slotID;
		for (int i = 0; i < itemsOut.length; i++) {
			slotID = i + 1;
			SlotStatus slotStatus = getSlotStatusForItem(slotHelper.getItemStackInSlot(slotID), itemsOut[i], amountsOut[i]);
			System.out.println("Slot " + slotID + " Status: " + slotStatus);
			if (slotStatus == SlotStatus.noSpace) { System.out.println("Slot full! Aborting process..."); return; }
			if (slotStatus == SlotStatus.itemMismatch) { System.out.println("Slot taken! Aborting process..."); return;	}
		}
		
		System.out.println("Processing item...");
		
		SlotStatus batteryOutSlotStatus = getSlotStatusForItem(slotHelper.getItemStackInSlot(8), BatteryUsedItem.block, 1);
		switch (batteryOutSlotStatus) {
			case itemMatch:
				slotHelper.increaseItemAmountInSlot(7, -1);
				slotHelper.increaseItemAmountInSlot(8, 1);
				break;
			case empty:
				slotHelper.increaseItemAmountInSlot(7, -1);
				slotHelper.setItemStackInSlot(8, new ItemStack(BatteryUsedItem.block, 1));
				break;
		}
		
		for (int i = 0; i < itemsOut.length; i++) {
			slotID = i + 1;
			SlotStatus outputSlotStatus = getSlotStatusForItem(slotHelper.getItemStackInSlot(slotID), itemsOut[i], amountsOut[i]);
			switch (outputSlotStatus) {
				case itemMatch:
					slotHelper.increaseItemAmountInSlot(slotID, amountsOut[i]);
					break;
				case empty:
					slotHelper.setItemStackInSlot(slotID, new ItemStack(itemsOut[i], amountsOut[i]));
					break;
			}
		}
		
		slotHelper.increaseItemAmountInSlot(0, -1);
	}
	static SlotStatus getSlotStatusForItem (ItemStack itemStack, Item item, int amount) {
		if (itemStack == ItemStack.EMPTY) return SlotStatus.empty;
		if (itemStack.getItem() == item && itemStack.getCount() <= 64 - amount) return SlotStatus.itemMatch;
		if (itemStack.getItem() == item && itemStack.getCount() > 64 - amount) return SlotStatus.noSpace;
		if (itemStack.getItem() != item) return SlotStatus.itemMismatch;
		return SlotStatus.NULL;
	}
	
	public enum SlotStatus {
		itemMatch, noSpace, itemMismatch, empty, NULL
	}
}
