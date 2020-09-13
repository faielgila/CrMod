package net.mcreator.crmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;

import net.mcreator.crmod.CrmodModElements;

import java.util.Map;

@CrmodModElements.ModElement.Tag
public class ProcElemRadiationProcedure extends CrmodModElements.ModElement {
	public ProcElemRadiationProcedure(CrmodModElements instance) {
		super(instance, 233);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ProcElemRadiation!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			System.err.println("Failed to load dependency itemstack for procedure ProcElemRadiation!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) (0.1 * (((itemstack)).getCount())));
	}
}
