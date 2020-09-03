package net.mcreator.crmod.procedures;

import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;

import net.mcreator.crmod.CrmodModElements;

import java.util.Map;

@CrmodModElements.ModElement.Tag
public class ProcElemRadiationProcedure extends CrmodModElements.ModElement {
	public ProcElemRadiationProcedure(CrmodModElements instance) {
		super(instance, 215);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ProcElemRadiation!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		entity.attackEntityFrom(DamageSource.GENERIC, (float) 0.1);
	}
}
