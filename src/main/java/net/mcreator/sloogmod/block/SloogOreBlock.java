
package net.mcreator.sloogmod.block;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.loot.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.sloogmod.SloogModModElements;

import java.util.Random;
import java.util.List;
import java.util.Collections;

@SloogModModElements.ModElement.Tag
public class SloogOreBlock extends SloogModModElements.ModElement {
	@ObjectHolder("sloog_mod:sloog_ore")
	public static final Block block = null;
	public SloogOreBlock(SloogModModElements instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new CustomBlock());
		elements.items
				.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(block.getRegistryName()));
	}
	public static class CustomBlock extends Block {
		public CustomBlock() {
			super(Block.Properties.create(Material.ROCK).sound(SoundType.GROUND).hardnessAndResistance(10f, 10f).setLightLevel(s -> 15)
					.harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().slipperiness(1f).speedFactor(0.1f).jumpFactor(0f)
					.setNeedsPostProcessing((bs, br, bp) -> true).setEmmisiveRendering((bs, br, bp) -> true));
			setRegistryName("sloog_ore");
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(this, 1));
		}

		@OnlyIn(Dist.CLIENT)
		@Override
		public void animateTick(BlockState state, World world, BlockPos pos, Random random) {
			super.animateTick(state, world, pos, random);
			PlayerEntity entity = Minecraft.getInstance().player;
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			if (true)
				for (int l = 0; l < 10; ++l) {
					double d0 = (x + random.nextFloat());
					double d1 = (y + random.nextFloat());
					double d2 = (z + random.nextFloat());
					int i1 = random.nextInt(2) * 2 - 1;
					double d3 = (random.nextFloat() - 0.5D) * 2D;
					double d4 = (random.nextFloat() - 0.5D) * 2D;
					double d5 = (random.nextFloat() - 0.5D) * 2D;
					world.addParticle(ParticleTypes.POOF, d0, d1, d2, d3, d4, d5);
				}
		}
	}
}
