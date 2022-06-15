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

package club.psychose.cimtcraft.core.plugin.features;

import org.bukkit.inventory.ShapedRecipe;

/**
 * <p>The CraftingRecipe class defines a custom crafting recipe that will be used in Spigot.</p>
 * <p>It'll register all recipes in {@link club.psychose.cimtcraft.core.system.managers.CraftingRecipesManager}</p>
 * @author CrashedLife
 */

public abstract class CraftingRecipe {
    /**
     * <p>Method to initialize the crafting recipe.</p>
     * @return {@link ShapedRecipe}
     */
    public abstract ShapedRecipe getCraftingRecipe ();
}