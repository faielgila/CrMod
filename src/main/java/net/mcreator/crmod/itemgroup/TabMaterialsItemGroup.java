
package net.mcreator.crmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.crmod.item.IngotAlemItem;
import net.mcreator.crmod.CrmodModElements;

@CrmodModElements.ModElement.Tag
public class TabMaterialsItemGroup extends CrmodModElements.ModElement {
	public TabMaterialsItemGroup(CrmodModElements instance) {
		super(instance, 136);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtabmaterials") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(IngotAlemItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
