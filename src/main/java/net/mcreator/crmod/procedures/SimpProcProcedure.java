package net.mcreator.crmod.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.crmod.item.IngotAlemItem;
import net.mcreator.crmod.item.ElemAeItem;
import net.mcreator.crmod.CrmodModElements;

import net.mcreator.crmod.SlotHelper;

import java.util.Map;

@CrmodModElements.ModElement.Tag
public class SimpProcProcedure extends CrmodModElements.ModElement {
	public SimpProcProcedure(CrmodModElements instance) {
		super(instance, 286);
	}
	
	public static void executeProcedure(Map<String, Object> dependencies) {
		System.out.println("Using abstracted code now!");
		
		// Throw a dependency error if entity is left empty
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure SimpProc!");
		}
		
		// Creates an instance of the SlotHelper with the entity dependency
		SlotHelper sltHlpr = new SlotHelper((Entity) dependencies.get("entity"));
		
		// Checks if the item in 'slot 0' is 'Alemonium Ingot'
		if (IngotAlemItem.block == sltHlpr.getItemStackInSlot(0).getItem()) {
			ItemStack outputSlotStack = sltHlpr.getItemStackInSlot(1);
			
			// Checks if the output slot is empty
			if (ItemStack.EMPTY == outputSlotStack) {
				// Decreases the item amount in 'slot 0' by '1'
				sltHlpr.increaseItemAmountInSlot(0, -1);
				
				// Sets the ItemStack in 'slot 1' to '1' 'Alemonium Atoms'
				sltHlpr.setItemStackInSlot(1, new ItemStack(ElemAeItem.block, 1));
			}
			// Checks if the item in the output slot is 'Alemonium Atoms'
			else if (ElemAeItem.block == outputSlotStack.getItem()) {
				// Decreases the item amount in 'slot 0' by '1'
				sltHlpr.increaseItemAmountInSlot(0, -1);
				
				// Increases the item in 'slot 1' by '1'
				sltHlpr.increaseItemAmountInSlot(1, 1);
			}
		}
	}
}
