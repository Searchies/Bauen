package net.searchies.bauen.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.searchies.bauen.init.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin {
    @Inject(at = @At("HEAD"), method = "getBlockBreakingSpeed", cancellable = true)
    public void trowelBreakSpeed(BlockState block, CallbackInfoReturnable<Float> cir) {
        float pickMiningSpeed = Items.DIAMOND_PICKAXE.getMiningSpeed(new ItemStack(Items.DIAMOND_PICKAXE), block);
        float axeMiningSpeed = Items.IRON_AXE.getMiningSpeed(new ItemStack(Items.IRON_AXE), block);
        float shovelMiningSpeed = Items.IRON_SHOVEL.getMiningSpeed(new ItemStack(Items.IRON_SHOVEL), block);
        float hoeMiningSpeed = Items.IRON_HOE.getMiningSpeed(new ItemStack(Items.IRON_HOE), block);

        float speed = Math.max(Math.max(hoeMiningSpeed, axeMiningSpeed), Math.max(pickMiningSpeed, shovelMiningSpeed));
        PlayerEntity player = (PlayerEntity)(Object)this;

        if (player.getMainHandStack().isOf(ModItems.TROWEL) &&
            player.getMainHandStack().getEnchantments().toString().contains("bauen:multitool")) {
            if (speed == 8F) { // fuckass workaround for pickaxes
                speed = 20F;
            }
            cir.setReturnValue(speed);
        }
    }

    @Inject(at = @At("HEAD"), method = "canHarvest", cancellable = true)
    public void trowelBlockDrop(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        PlayerEntity player = (PlayerEntity)(Object)this;

        if (player.getMainHandStack().isOf(ModItems.TROWEL) &&
            player.getMainHandStack().getEnchantments().toString().contains("bauen:multitool")) {
            List<Item> items = new ArrayList<>();
            items.add(Items.IRON_PICKAXE);
            items.add(Items.IRON_AXE);
            items.add(Items.IRON_SHOVEL);
            items.add(Items.IRON_HOE);

            for (Item item: items) {
                if (item.isCorrectForDrops(new ItemStack(item), state)) {
                    cir.setReturnValue(true);
                    return;
                }
            }
        }
    }
}
