
package net.mcreator.crmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.crmod.item.ElemAeItem;
import net.mcreator.crmod.CrmodModElements;

@CrmodModElements.ModElement.Tag
public class TabElementsItemGroup extends CrmodModElements.ModElement {
	public TabElementsItemGroup(CrmodModElements instance) {
		super(instance, 152);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtabelements") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(ElemAeItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static ItemGroup tab;
}
