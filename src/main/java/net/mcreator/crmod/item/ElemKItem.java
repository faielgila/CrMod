
package net.mcreator.crmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.crmod.itemgroup.TabElementsItemGroup;
import net.mcreator.crmod.CrmodModElements;

@CrmodModElements.ModElement.Tag
public class ElemKItem extends CrmodModElements.ModElement {
	@ObjectHolder("crmod:elemk")
	public static final Item block = null;
	public ElemKItem(CrmodModElements instance) {
		super(instance, 120);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TabElementsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("elemk");
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
	}
}
