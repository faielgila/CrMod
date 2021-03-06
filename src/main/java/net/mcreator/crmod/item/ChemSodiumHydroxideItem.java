
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
public class ChemSodiumHydroxideItem extends CrmodModElements.ModElement {
	@ObjectHolder("crmod:chem_sodium_hydroxide")
	public static final Item block = null;
	public ChemSodiumHydroxideItem(CrmodModElements instance) {
		super(instance, 137);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(TabChemicalsItemGroup.tab).maxStackSize(1).rarity(Rarity.COMMON));
			setRegistryName("chem_sodium_hydroxide");
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
			list.add(new StringTextComponent("\u00A7oNaOH"));
		}
	}
}
