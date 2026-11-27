package net.searchies.bauen.datagen;

import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.ChangedDimensionCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.data.DataOutput;
import net.minecraft.data.advancement.AdvancementProvider;
import net.minecraft.data.advancement.AdvancementTabGenerator;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.searchies.bauen.Bauen;
import net.searchies.bauen.init.ModBlocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementsProvider extends AdvancementProvider {
    public ModAdvancementsProvider(DataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture, List.of(new BauenAdvancements()));
    }

    public static class BauenAdvancements implements AdvancementTabGenerator {

        @Override
        public void accept(RegistryWrapper.WrapperLookup registries, Consumer<AdvancementEntry> exporter) {

            AdvancementEntry root = Advancement.Builder.create()
                    .display(
                            ModBlocks.TREATED_BRICKS,
                            Text.translatable("advancements.bauen.root.title"),
                            Text.translatable("advancements.bauen.root.description"),
                            Identifier.ofVanilla("gui/advancements/backgrounds/nether"),
                            AdvancementFrame.TASK,
                            false,
                            false,
                            false)
                    .criterion("has_dirt", InventoryChangedCriterion.Conditions.items(Blocks.DIRT))
                    .build(exporter, Bauen.MOD_ID + ":bauen/root");

            Advancement.Builder.create()
                    .parent(root)
                    .display(
                            ModBlocks.NETHERITE_FENCE,
                            Text.translatable("advancements.bauen.netherite_fence.title"),
                            Text.translatable("advancements.bauen.netherite_fence.description"),
                            null,
                            AdvancementFrame.CHALLENGE,
                            true,
                            true,
                            false)
                    .rewards(AdvancementRewards.Builder.experience(500))
                    .criterion("has_netherite_fence", InventoryChangedCriterion.Conditions.items(ModBlocks.NETHERITE_FENCE))
                    .build(exporter, "bauen/obtain_netherite_fence");

        }
    }
}
