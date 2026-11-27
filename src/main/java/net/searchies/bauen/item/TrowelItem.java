package net.searchies.bauen.item;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import java.util.*;

public class TrowelItem extends Item {
    public TrowelItem(ToolMaterial material, float attackDamage, float attackSpeed, Item.Properties settings) {
        super(settings.shovel(material, attackDamage, attackSpeed));
    }

    // ill totally optimize this later...

    @Override
    public boolean mineBlock(ItemStack stack, Level world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (miner instanceof Player player) {
            Container inventory = player.getInventory();
            List<BlockItem> blocks = new ArrayList<>();
            List<Integer> slots = new ArrayList<>();

            int counter = 0;
            while (counter <= 8) {
                ItemStack tempStack = inventory.getItem(counter);
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

            if (!world.isClientSide()) {
                world.setBlockAndUpdate(pos, block.getBlock().defaultBlockState());
                if (!player.isCreative()) {
                    inventory.getItem(slot).setCount(inventory.getItem(slot).getCount() - 1);
                }
            }
            return super.mineBlock(block.getDefaultInstance(), world, state, pos, miner);
        }
        return true;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Container inventory = context.getPlayer().getInventory();
        List<BlockItem> blocks = new ArrayList<>();
        List<Integer> slots = new ArrayList<>();

        int counter = 0;
        while (counter <= 8) {
            ItemStack tempStack = inventory.getItem(counter);
            if (tempStack.getItem() instanceof BlockItem tempBlock) {
                blocks.add(tempBlock);
                slots.add(counter);
            }
            counter++;
        }

        if (blocks.isEmpty()) return InteractionResult.PASS;

        Random rand = new Random();
        int rng = rand.nextInt(blocks.size());

        BlockItem block = blocks.get(rng);
        int slot = slots.get(rng);

        Level world = context.getLevel();
        BlockPos pos = context.getClickedPos();

        if (!world.isClientSide()) {
            boolean isPlaced = block.place(new BlockPlaceContext(
                world, context.getPlayer(), null, block.getDefaultInstance(),
                context.getHitResult().withDirection(context.getClickedFace()))).consumesAction();

            if (!context.getPlayer().isCreative() && isPlaced) {
                inventory.getItem(slot).setCount(inventory.getItem(slot).getCount() - 1);
            }

            world.playSound(null, pos, SoundEvents.PACKED_MUD_STEP, SoundSource.BLOCKS, 1.0F, 1.0F);
        }

        return InteractionResult.SUCCESS;
    }
}
