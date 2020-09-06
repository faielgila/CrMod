
package net.mcreator.crmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.entity.Entity;
import net.minecraft.block.BlockState;

import net.mcreator.crmod.procedures.ProcElemRadiationProcedure;
import net.mcreator.crmod.itemgroup.TabElementsItemGroup;
import net.mcreator.crmod.CrmodModElements;

import java.util.Map;
import java.util.HashMap;

@CrmodModElements.ModElement.Tag
public class ElemUItem extends CrmodModElements.ModElement {
	@ObjectHolder("crmod:elemu")
	public static final Item block = null;
	public ElemUItem(CrmodModElements instance) {
		super(instance, 121);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TabElementsItemGroup.tab).maxStackSize(32));
			setRegistryName("elemu");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}

		@Override
		public void inventoryTick(ItemStack itemstack, World world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				$_dependencies.put("itemstack", itemstack);
				ProcElemRadiationProcedure.executeProcedure($_dependencies);
			}
		}
	}
}
