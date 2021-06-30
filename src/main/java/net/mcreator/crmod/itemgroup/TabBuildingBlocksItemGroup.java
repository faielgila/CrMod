
package net.mcreator.crmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.crmod.block.OreAlemBlock;
import net.mcreator.crmod.CrmodModElements;

@CrmodModElements.ModElement.Tag
public class TabBuildingBlocksItemGroup extends CrmodModElements.ModElement {
	public TabBuildingBlocksItemGroup(CrmodModElements instance) {
		super(instance, 151);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtabbuildingblocks") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(OreAlemBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
