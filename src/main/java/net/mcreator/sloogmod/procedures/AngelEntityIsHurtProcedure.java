package net.mcreator.sloogmod.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.block.Blocks;

import net.mcreator.sloogmod.SloogModModElements;
import net.mcreator.sloogmod.SloogModMod;

import java.util.Map;

@SloogModModElements.ModElement.Tag
public class AngelEntityIsHurtProcedure extends SloogModModElements.ModElement {
	public AngelEntityIsHurtProcedure(SloogModModElements instance) {
		super(instance, 13);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				SloogModMod.LOGGER.warn("Failed to load dependency x for procedure AngelEntityIsHurt!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				SloogModMod.LOGGER.warn("Failed to load dependency y for procedure AngelEntityIsHurt!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				SloogModMod.LOGGER.warn("Failed to load dependency z for procedure AngelEntityIsHurt!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				SloogModMod.LOGGER.warn("Failed to load dependency world for procedure AngelEntityIsHurt!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		double xPos = 0;
		double yPos = 0;
		double zPos = 0;
		zPos = (double) (z - 5);
		for (int index0 = 0; index0 < (int) (10); index0++) {
			yPos = (double) (y - 5);
			for (int index1 = 0; index1 < (int) (10); index1++) {
				xPos = (double) (x - 5);
				for (int index2 = 0; index2 < (int) (10); index2++) {
					world.setBlockState(new BlockPos((int) (xPos), (int) (yPos), (int) (zPos)), Blocks.AIR.getDefaultState(), 3);
					xPos = (double) ((xPos) + 1);
				}
				yPos = (double) ((yPos) + 1);
			}
			zPos = (double) ((zPos) + 1);
		}
	}
}
