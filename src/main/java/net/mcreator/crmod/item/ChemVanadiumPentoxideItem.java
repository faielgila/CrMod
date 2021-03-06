
package net.mcreator.crmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.block.BlockState;

import net.mcreator.crmod.itemgroup.TabChemicalsItemGroup;
import net.mcreator.crmod.CrmodModElements;

import java.util.List;

@CrmodModElements.ModElement.Tag
public class ChemVanadiumPentoxideItem extends CrmodModElements.ModElement {
	@ObjectHolder("crmod:chem_vanadium_pentoxide")
	public static final Item block = null;
	public ChemVanadiumPentoxideItem(CrmodModElements instance) {
		super(instance, 139);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TabChemicalsItemGroup.tab).maxStackSize(64).rarity(Rarity.COMMON));
			setRegistryName("chem_vanadium_pentoxide");
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
		public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add(new StringTextComponent("\u00A7oV2O5"));
		}
	}
}
