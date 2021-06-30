
package net.mcreator.crmod.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.mcreator.crmod.item.BatteryItem;
import net.mcreator.crmod.CrmodModElements;

@CrmodModElements.ModElement.Tag
public class TabElectronicsItemGroup extends CrmodModElements.ModElement {
	public TabElectronicsItemGroup(CrmodModElements instance) {
		super(instance, 153);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabtabelectronics") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(BatteryItem.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
