
package net.mcreator.crmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.crmod.itemgroup.TabToolsItemGroup;
import net.mcreator.crmod.CrmodModElements;

@CrmodModElements.ModElement.Tag
public class ShovelBlazItem extends CrmodModElements.ModElement {
	@ObjectHolder("crmod:shovelblaz")
	public static final Item block = null;
	public ShovelBlazItem(CrmodModElements instance) {
		super(instance, 78);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ShovelItem(new IItemTier() {
			public int getMaxUses() {
				return 1500;
			}

			public float getEfficiency() {
				return 7f;
			}

			public float getAttackDamage() {
				return 2.5f;
			}

			public int getHarvestLevel() {
				return 4;
			}

			public int getEnchantability() {
				return 10;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -1.2f, new Item.Properties().group(TabToolsItemGroup.tab)) {
		}.setRegistryName("shovelblaz"));
	}
}
