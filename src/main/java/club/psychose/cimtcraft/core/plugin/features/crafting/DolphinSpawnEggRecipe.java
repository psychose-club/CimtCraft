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

package club.psychose.cimtcraft.core.plugin.features.crafting;

import club.psychose.cimtcraft.CimtCraft;
import club.psychose.cimtcraft.core.plugin.features.CraftingRecipe;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public final class DolphinSpawnEggRecipe extends CraftingRecipe {
    @Override
    public ShapedRecipe getCraftingRecipe() {
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(CimtCraft.getPlugin(CimtCraft.class), "crafting_dolphin_spawn_egg"), new ItemStack(Material.DOLPHIN_SPAWN_EGG));
        shapedRecipe.shape("XXX", "ZYZ", "ZZZ");

        shapedRecipe.setIngredient('X', Material.PRISMARINE_CRYSTALS);
        shapedRecipe.setIngredient('Y', Material.HEART_OF_THE_SEA);
        shapedRecipe.setIngredient('Z', Material.WATER_BUCKET);

        return shapedRecipe;
    }
}
