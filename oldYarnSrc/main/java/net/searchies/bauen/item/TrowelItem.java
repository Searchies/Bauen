package net.searchies.bauen.item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.*;

public class TrowelItem extends Item {
    public TrowelItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Settings settings) {
        super(settings.shovel(material, attackDamage, attackSpeed));
    }

    // ill totally optimize this later...

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (miner instanceof PlayerEntity player) {
            Inventory inventory = player.getInventory();
            List<BlockItem> blocks = new ArrayList<>();
            List<Integer> slots = new ArrayList<>();

            int counter = 0;
            while (counter <= 8) {
                ItemStack tempStack = inventory.getStack(counter);
                if (tempStack.getItem() instanceof BlockItem tempBlock) {
                    blocks.add(tempBlock);
                    slots.add(counter);
                }
                counter++;
            }

            if (blocks.isEmpty()) return true;

            Random rand = new Random();
            int rng = rand.nextInt(blocks.size());

            BlockItem block = blocks.get(rng);
            int slot = slots.get(rng);

            if (!world.isClient()) {
                world.setBlockState(pos, block.getBlock().getDefaultState());
                if (!player.isCreative()) {
                    inventory.getStack(slot).setCount(inventory.getStack(slot).getCount() - 1);
                }
            }
            return super.postMine(block.getDefaultStack(), world, state, pos, miner);
        }
        return true;
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        Inventory inventory = context.getPlayer().getInventory();
        List<BlockItem> blocks = new ArrayList<>();
        List<Integer> slots = new ArrayList<>();

        int counter = 0;
        while (counter <= 8) {
            ItemStack tempStack = inventory.getStack(counter);
            if (tempStack.getItem() instanceof BlockItem tempBlock) {
                blocks.add(tempBlock);
                slots.add(counter);
            }
            counter++;
        }

        if (blocks.isEmpty()) return ActionResult.PASS;

        Random rand = new Random();
        int rng = rand.nextInt(blocks.size());

        BlockItem block = blocks.get(rng);
        int slot = slots.get(rng);

        World world = context.getWorld();
        BlockPos pos = context.getBlockPos();

        if (!world.isClient()) {
            boolean isPlaced = block.place(new ItemPlacementContext(
                world, context.getPlayer(), null, block.getDefaultStack(),
                context.getHitResult().withSide(context.getSide()))).isAccepted();

            if (!context.getPlayer().isCreative() && isPlaced) {
                inventory.getStack(slot).setCount(inventory.getStack(slot).getCount() - 1);
            }

            world.playSound(null, pos, SoundEvents.BLOCK_PACKED_MUD_STEP, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }

        return ActionResult.SUCCESS;
    }
}
