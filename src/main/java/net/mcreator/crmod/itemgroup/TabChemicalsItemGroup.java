
package net.mcreator.crmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.crmod.item.ChemSodiumHydroxideItem;
import net.mcreator.crmod.CrmodModElements;

@CrmodModElements.ModElement.Tag
public class TabChemicalsItemGroup extends CrmodModElements.ModElement {
	public TabChemicalsItemGroup(CrmodModElements instance) {
		super(instance, 305);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtab_chemicals") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ChemSodiumHydroxideItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
