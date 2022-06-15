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

package club.psychose.cimtcraft.utils;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

/**
 * <p>The ItemUtils class provides methods to handle with specific items.</p>
 * @author CrashedLife
 */

public final class ItemUtils {
    /**
     * <p>We are restricting the access, because the class only contain static methods.</p>
     */
    private ItemUtils () {}

    /**
     * <p>This method checks if a {@link Block} is a wood log block.</p>
     * <p>NOTE! Stripped logs are not supported, since spigot detect them as air.</p>
     * @param block Defines which {@link Block} should be checked for.
     * @return true or false
     */
    public static boolean isBlockAWoodLog (Block block) {
        return checkViaMaterialName(block.getType(), "LOG");
    }

    /**
     * <p>This method checks if a {@link ItemStack} is an axe.</p>
     * @param itemStack Defines which {@link ItemStack} should be checked for.
     * @param excludeAxes Optional: Defines {@link Material} that should be excluded from the search.
     * @return true or false
     */
    public static boolean isItemAnAxe (ItemStack itemStack, Material... excludeAxes) {
        return (!(isItemAnPickaxe(itemStack, excludeAxes)) && (checkViaMaterialName(itemStack.getType(), "AXE", excludeAxes)));
    }

    /**
     * <p>This method checks if a {@link ItemStack} is an pickaxe.</p>
     * @param itemStack Defines which {@link ItemStack} should be checked for.
     * @param excludePickaxes Optional: Defines {@link Material} that should be excluded from the search.
     * @return true or false
     */
    public static boolean isItemAnPickaxe (ItemStack itemStack, Material... excludePickaxes) {
        return checkViaMaterialName(itemStack.getType(), "PICKAXE", excludePickaxes);
    }

    /**
     * <p>Checks for a {@link Material} over the material name.</p>
     * <p>Optional: Exclude specific {@link Material} from the search.</p>
     * @param material Defines which {@link Material} should be checked for.
     * @param materialName For this parameter will be searched.
     * @param excludeMaterial Optional: Exclude specific {@link Material}.
     * @return true or false
     */
    private static boolean checkViaMaterialName (Material material, String materialName, Material... excludeMaterial) {
        if (material.name().toUpperCase().contains(materialName)) {
            if ((excludeMaterial != null) && (excludeMaterial.length > 0)) {
                for (Material exclude : excludeMaterial) {
                    if (material.equals(exclude))
                        return false;
                }
            }

            return true;
        }

        return false;
    }
}