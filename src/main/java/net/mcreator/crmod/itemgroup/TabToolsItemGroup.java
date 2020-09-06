
package net.mcreator.crmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.crmod.item.HammerIronItem;
import net.mcreator.crmod.CrmodModElements;

@CrmodModElements.ModElement.Tag
public class TabToolsItemGroup extends CrmodModElements.ModElement {
	public TabToolsItemGroup(CrmodModElements instance) {
		super(instance, 137);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtabtools") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(HammerIronItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
