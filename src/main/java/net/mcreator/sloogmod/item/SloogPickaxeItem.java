
package net.mcreator.sloogmod.item;

import net.minecraftforge.registries.ObjectHolder;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;

import net.mcreator.sloogmod.SloogModModElements;

@SloogModModElements.ModElement.Tag
public class SloogPickaxeItem extends SloogModModElements.ModElement {
	@ObjectHolder("sloog_mod:sloog_pickaxe")
	public static final Item block = null;
	public SloogPickaxeItem(SloogModModElements instance) {
		super(instance, 4);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new PickaxeItem(new IItemTier() {
			public int getMaxUses() {
				return 0;
			}

			public float getEfficiency() {
				return 10f;
			}

			public float getAttackDamage() {
				return 8f;
			}

			public int getHarvestLevel() {
				return 1;
			}

			public int getEnchantability() {
				return 30;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(SloogIngotItem.block, (int) (1)));
			}
		}, 1, 16f, new Item.Properties().group(ItemGroup.TOOLS).isImmuneToFire()) {
			@Override
			@OnlyIn(Dist.CLIENT)
			public boolean hasEffect(ItemStack itemstack) {
				return true;
			}
		}.setRegistryName("sloog_pickaxe"));
	}
}
