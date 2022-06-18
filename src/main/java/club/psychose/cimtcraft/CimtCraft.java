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

package club.psychose.cimtcraft;

import club.psychose.cimtcraft.core.plugin.listeners.BlockBreakEventListener;
import club.psychose.cimtcraft.core.plugin.listeners.BlockPlaceEventListener;
import club.psychose.cimtcraft.utils.Constants;
import club.psychose.cimtcraft.utils.logging.ConsoleLogger;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * <p>This class is the main class of this plugin, it would be called when the server loads the plugins.</p>
 * @author CrashedLife
 */

public final class CimtCraft extends JavaPlugin {
    @Override
    public void onEnable () {
        System.out.println("""
                  ___  __  _  _  ____  ___  ____   __   ____  ____\s
                 / __)(  )( \\/ )(_  _)/ __)(  _ \\ / _\\ (  __)(_  _)
                ( (__  )( / \\/ \\  )( ( (__  )   //    \\ ) _)   )( \s
                 \\___)(__)\\_)(_/ (__) \\___)(__\\_)\\_/\\_/(__)   (__)\s
                """);
        ConsoleLogger.debug("Copyright © 2022 psychose.club");
        ConsoleLogger.debug("Version: " + Constants.VERSION);
        ConsoleLogger.debug("Build Version: " + Constants.BUILD);
        ConsoleLogger.printEmptyLine();
        ConsoleLogger.debug("Initialize crafting recipes...");
        Constants.CRAFTING_RECIPES_MANAGER.initializeRecipes();
        ConsoleLogger.debug("Crafting recipes initialized!");
        ConsoleLogger.printEmptyLine();
        ConsoleLogger.debug("Initialize plugin features...");
        Constants.FEATURE_MANAGER.initializeFeatures();
        ConsoleLogger.debug("Plugin features initialized!");
        ConsoleLogger.printEmptyLine();
        ConsoleLogger.debug("Register listeners...");
        Bukkit.getPluginManager().registerEvents(new BlockBreakEventListener(), this);
        Bukkit.getPluginManager().registerEvents(new BlockPlaceEventListener(), this);
        ConsoleLogger.debug("Listeners registered!");
        ConsoleLogger.printEmptyLine();

        if (Constants.FEATURE_MANAGER.isFeatureEnabled("Custom crafting recipes")) {
            ConsoleLogger.debug("Register crafting recipes...");

            Constants.CRAFTING_RECIPES_MANAGER.getCraftingRecipesArrayList().forEach(shapedRecipe -> this.getServer().addRecipe(shapedRecipe));

            ConsoleLogger.debug("Crafting recipes registered!");
        } else {
            ConsoleLogger.debug("The feature is \"Custom crafting recipes\" is disabled! To enable it, enable it in the features.json and reload the plugin!");
        }
    }

    @Override
    public void onDisable () {
        ConsoleLogger.debug("CimtCraft disabled!");
    }
}