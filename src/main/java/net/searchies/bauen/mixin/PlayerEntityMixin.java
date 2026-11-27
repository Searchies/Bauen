package net.searchies.bauen.mixin;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;
import net.searchies.bauen.init.ModItems;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.ArrayList;
import java.util.List;

@Mixin(Player.class)
public abstract class PlayerEntityMixin {
    @Inject(at = @At("HEAD"), method = "getDestroySpeed", cancellable = true)
    public void trowelBreakSpeed(BlockState block, CallbackInfoReturnable<Float> cir) {
        float pickMiningSpeed = Items.DIAMOND_PICKAXE.getDestroySpeed(new ItemStack(Items.DIAMOND_PICKAXE), block);
        float axeMiningSpeed = Items.IRON_AXE.getDestroySpeed(new ItemStack(Items.IRON_AXE), block);
        float shovelMiningSpeed = Items.IRON_SHOVEL.getDestroySpeed(new ItemStack(Items.IRON_SHOVEL), block);
        float hoeMiningSpeed = Items.IRON_HOE.getDestroySpeed(new ItemStack(Items.IRON_HOE), block);

        float speed = Math.max(Math.max(hoeMiningSpeed, axeMiningSpeed), Math.max(pickMiningSpeed, shovelMiningSpeed));
        Player player = (Player)(Object)this;

        if (player.getMainHandItem().is(ModItems.TROWEL) &&
            player.getMainHandItem().getEnchantments().toString().contains("bauen:multitool")) {
            if (speed == 8F) { // fuckass workaround for pickaxes
                speed = 20F;
            }
            speed += (float)player.getAttributeValue(Attributes.MINING_EFFICIENCY);
            cir.setReturnValue(speed);
        }
    }

    @Inject(at = @At("HEAD"), method = "hasCorrectToolForDrops", cancellable = true)
    public void trowelBlockDrop(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        Player player = (Player)(Object)this;

        if (player.getMainHandItem().is(ModItems.TROWEL) &&
            player.getMainHandItem().getEnchantments().toString().contains("bauen:multitool")) {
            List<Item> items = List.of(Items.IRON_PICKAXE, Items.IRON_AXE, Items.IRON_SHOVEL, Items.IRON_HOE);

            for (Item item: items) {
                if (item.isCorrectToolForDrops(new ItemStack(item), state)) {
                    cir.setReturnValue(true);
                    return;
                }
            }
        }
    }
}
