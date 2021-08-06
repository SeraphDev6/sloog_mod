
package net.mcreator.sloogmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.IPlantable;

import net.minecraft.world.IBlockReader;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.sloogmod.SloogModModElements;

import java.util.List;
import java.util.Collections;

@SloogModModElements.ModElement.Tag
public class SloogBlockBlock extends SloogModModElements.ModElement {
	@ObjectHolder("sloog_mod:sloog_block")
	public static final Block block = null;
	public SloogBlockBlock(SloogModModElements instance) {
		super(instance, 1);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ORGANIC).sound(SoundType.BONE).hardnessAndResistance(10f, 10f).setLightLevel(s -> 15)
					.harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool().slipperiness(1f).speedFactor(0.1f).jumpFactor(0f)
					.setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true));
			setRegistryName("sloog_block");
		}

		@Override
		public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction direction, IPlantable plantable) {
			return true;
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
