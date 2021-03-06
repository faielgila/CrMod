
package net.mcreator.crmod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.item.Rarity;
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
public class ElemPxItem extends CrmodModElements.ModElement {
	@ObjectHolder("crmod:elempx")
	public static final Item block = null;
	public ElemPxItem(CrmodModElements instance) {
		super(instance, 133);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TabElementsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("elempx");
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
		@OnlyIn(Dist.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
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
