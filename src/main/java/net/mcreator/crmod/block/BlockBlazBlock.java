
package net.mcreator.crmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.crmod.itemgroup.TabBuildingBlocksItemGroup;
import net.mcreator.crmod.CrmodModElements;

import java.util.List;
import java.util.Collections;

@CrmodModElements.ModElement.Tag
public class BlockBlazBlock extends CrmodModElements.ModElement {
	@ObjectHolder("crmod:blockblaz")
	public static final Block block = null;
	public BlockBlazBlock(CrmodModElements instance) {
		super(instance, 19);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items.add(
				() -> new BlockItem(block, new Item.Properties().group(TabBuildingBlocksItemGroup.tab)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.IRON).sound(SoundType.METAL).hardnessAndResistance(2f, 10f).lightValue(0).harvestLevel(4)
					.harvestTool(ToolType.PICKAXE));
			setRegistryName("blockblaz");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}
	}
}
