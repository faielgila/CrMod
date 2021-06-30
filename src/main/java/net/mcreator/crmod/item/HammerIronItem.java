
package net.mcreator.crmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.crmod.itemgroup.TabToolsItemGroup;
import net.mcreator.crmod.CrmodModElements;

@CrmodModElements.ModElement.Tag
public class HammerIronItem extends CrmodModElements.ModElement {
	@ObjectHolder("crmod:hammeriron")
	public static final Item block = null;
	public HammerIronItem(CrmodModElements instance) {
		super(instance, 69);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TabToolsItemGroup.tab).maxStackSize(2).rarity(Rarity.COMMON));
			setRegistryName("hammeriron");
		}

		@Override
		public boolean hasContainerItem() {
			return true;
		}

		@Override
		public ItemStack getContainerItem(ItemStack itemstack) {
			return new ItemStack(this);
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 50;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 2F;
		}
	}
}
