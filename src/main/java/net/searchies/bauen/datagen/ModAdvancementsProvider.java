package net.searchies.bauen.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Blocks;
import net.searchies.bauen.Bauen;
import net.searchies.bauen.init.ModBlocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class ModAdvancementsProvider extends AdvancementProvider {
    public ModAdvancementsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture, List.of(new BauenAdvancements()));
    }

    public static class BauenAdvancements implements AdvancementSubProvider {

        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> exporter) {

            AdvancementHolder root = Advancement.Builder.advancement()
                    .display(
                            ModBlocks.TREATED_BRICKS,
                            Component.translatable("advancements.bauen.root.title"),
                            Component.translatable("advancements.bauen.root.description"),
                            Identifier.withDefaultNamespace("gui/advancements/backgrounds/nether"),
                            AdvancementType.TASK,
                            false,
                            false,
                            false)
                    .addCriterion("has_dirt", InventoryChangeTrigger.TriggerInstance.hasItems(Blocks.DIRT))
                    .save(exporter, Bauen.MOD_ID + ":bauen/root");

            Advancement.Builder.advancement()
                    .parent(root)
                    .display(
                            ModBlocks.NETHERITE_FENCE,
                            Component.translatable("advancements.bauen.netherite_fence.title"),
                            Component.translatable("advancements.bauen.netherite_fence.description"),
                            null,
                            AdvancementType.CHALLENGE,
                            true,
                            true,
                            false)
                    .rewards(AdvancementRewards.Builder.experience(500))
                    .addCriterion("has_netherite_fence", InventoryChangeTrigger.TriggerInstance.hasItems(ModBlocks.NETHERITE_FENCE))
                    .save(exporter, "bauen/obtain_netherite_fence");

        }
    }
}
