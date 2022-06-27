/*
 * Copyright © 2022 psychose.club
 * Discord: https://www.psychose.club/discord
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package club.psychose.cimtcraft.core.system.managers;

import club.psychose.cimtcraft.core.plugin.features.crafting.*;
import club.psychose.cimtcraft.utils.Constants;
import org.bukkit.inventory.ShapedRecipe;

import java.util.ArrayList;

/**
 * <p>The CraftingRecipesManager class handles the custom crafting recipes from the plugin.</p>
 * @see ShapedRecipe
 * @author CrashedLife
 */

public final class CraftingRecipesManager {
    /**
     * <p>This ArrayList stores all registered {@link ShapedRecipe}.</p>
     */
    private final ArrayList<ShapedRecipe> craftingRecipesArrayList = new ArrayList<>();

    /**
     * <p>This method initialize the hardcoded {@link ShapedRecipe}.</p>
     */
    public void initializeRecipes () {
        // Clears the ArrayList to make reinitialization possible.
        this.craftingRecipesArrayList.clear();

        // Spawn Eggs.
        if (Constants.FEATURE_MANAGER.isFeatureEnabled("Craft Spawn Eggs")) {
            this.craftingRecipesArrayList.add(new AllaySpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new AxolotlSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new BatSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new BeeSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new BlazeSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new CatSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new CaveSpiderSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new ChickenSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new CodSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new CowSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new CreeperSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new DolphinSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new DonkeySpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new DrownedSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new ElderGuardianSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new EndermanSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new EndermiteSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new EvokerSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new FoxSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new FrogSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new GhastSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new GlowSquidSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new GoatSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new GuardianSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new HoglinSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new HorseSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new HuskSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new LlamaSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new MagmaCubeSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new MooshroomSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new MuleSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new OcelotSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new PandaSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new ParrotSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new PhantomSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new PiglinBruteSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new PiglinSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new PigSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new PillagerSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new PolarBearSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new PufferfishSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new RabbitSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new RavagerSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new SalmonSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new SheepSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new ShulkerSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new SilverfishSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new SkeletonHorseSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new SkeletonSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new SlimeSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new SpiderSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new SquidSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new StraySpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new StriderSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new TadpoleSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new TraderLlamaSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new TropicalFishSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new TurtleSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new VexSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new VillagerSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new VindicatorSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new WanderingTraderSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new WardenSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new WitchSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new WitherSkeletonSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new WolfSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new ZoglinSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new ZombieHorseSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new ZombieSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new ZombieVillagerSpawnEggRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new ZombifiedPiglinSpawnEggRecipe().getCraftingRecipe());
        }

        // Horse Armor.
        if (Constants.FEATURE_MANAGER.isFeatureEnabled("Craft Horse Armor")) {
            this.craftingRecipesArrayList.add(new IronHorseArmorRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new GoldHorseArmorRecipe().getCraftingRecipe());
            this.craftingRecipesArrayList.add(new DiamondHorseArmorRecipe().getCraftingRecipe());
        }

        // Nametag.
        if (Constants.FEATURE_MANAGER.isFeatureEnabled("Craft Nametag")) {
            this.craftingRecipesArrayList.add(new NametagRecipe().getCraftingRecipe());
        }

        // Saddle.
        if (Constants.FEATURE_MANAGER.isFeatureEnabled("Craft Saddle")) {
            this.craftingRecipesArrayList.add(new SaddleRecipe().getCraftingRecipe());
        }
    }

    /**
     * <p>Here we'll return the ArrayList that stores all registered {@link ShapedRecipe}.</p>
     * @return Registered {@link ShapedRecipe}
     */
    public ArrayList<ShapedRecipe> getCraftingRecipesArrayList () {
        return this.craftingRecipesArrayList;
    }
}