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

import club.psychose.cimtcraft.CimtCraft;
import club.psychose.cimtcraft.core.system.managers.CraftingRecipesManager;
import club.psychose.cimtcraft.core.system.managers.FeatureManager;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <p>The Constants class provides specific and important variables for the plugin.</p>
 * @author CrashedLife
 */

public final class Constants {
    /**
     * <p>We are restricting the access, because the class only contain static methods.</p>
     */
    private Constants () {}

    /**
     * <p>The VERSION string represents the official labeled version from the plugin.</p>
     * <p>The BUILD string represents the build number from the plugin.</p>
     */
    public static final String VERSION = "1.0.0";
    public static final String BUILD = "1";

    /**
     * <p>The managers are initialized here because they can't be finalized in the main class.</p>
     */
    public static final CraftingRecipesManager CRAFTING_RECIPES_MANAGER = new CraftingRecipesManager();
    public static final FeatureManager FEATURE_MANAGER = new FeatureManager();

    /**
     * <p>These are the plugin constants.</p>
     */
    public static final String PREFIX = "§7[§6CimtCraft§7]: ";

    /**
     * <p>The method returns the folder in the plugins directory, where the plugin works.</p>
     * @param additionalPath When the additionalPath is not null, it'll include the path, when the path is returned.
     * @return Returns the folder path.
     */
    public static Path getCimtCraftFolder (String additionalPath) {
        return (additionalPath != null ? StringUtils.getOSPath(Paths.get(CimtCraft.getPlugin(CimtCraft.class).getDataFolder().getPath() + "\\" + additionalPath)) : StringUtils.getOSPath(Paths.get(CimtCraft.getPlugin(CimtCraft.class).getDataFolder().getPath() + "\\")));
    }
}