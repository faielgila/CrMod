
package net.mcreator.crmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.crmod.itemgroup.TabMaterialsItemGroup;
import net.mcreator.crmod.CrmodModElements;

@CrmodModElements.ModElement.Tag
public class CrystalLithItem extends CrmodModElements.ModElement {
	@ObjectHolder("crmod:crystallith")
	public static final Item block = null;
	public CrystalLithItem(CrmodModElements instance) {
		super(instance, 50);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TabMaterialsItemGroup.tab).maxStackSize(64));
			setRegistryName("crystallith");
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
