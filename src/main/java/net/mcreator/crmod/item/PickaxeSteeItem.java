
package net.mcreator.crmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.crmod.itemgroup.TabToolsItemGroup;
import net.mcreator.crmod.CrmodModElements;

@CrmodModElements.ModElement.Tag
public class PickaxeSteeItem extends CrmodModElements.ModElement {
	@ObjectHolder("crmod:pickaxestee")
	public static final Item block = null;
	public PickaxeSteeItem(CrmodModElements instance) {
		super(instance, 83);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 500;
			}

			public float getEfficiency() {
				return 8f;
			}

			public float getAttackDamage() {
				return 4f;
			}

			public int getHarvestLevel() {
				return 3;
			}

			public int getEnchantability() {
				return 16;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.EMPTY;
			}
		}, 1, -1.2f, new Item.Properties().group(TabToolsItemGroup.tab)) {
		}.setRegistryName("pickaxestee"));
	}
}
