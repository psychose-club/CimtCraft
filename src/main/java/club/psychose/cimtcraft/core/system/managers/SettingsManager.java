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

import club.psychose.cimtcraft.CimtCraft;
import club.psychose.cimtcraft.core.plugin.features.PluginFeature;
import club.psychose.cimtcraft.utils.Constants;
import club.psychose.cimtcraft.utils.logging.ConsoleLogger;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.nio.file.Files;

/**
 * <p>The SettingsManager class provides methods to load and saves specific settings.</p>
 * @author CrashedLife
 */

public final class SettingsManager {
    private int loadAttempts = 0;

    /**
     * <p>Loads the features.</p>
     */
    public void loadFeatures () {
        if (this.loadAttempts <= 2) {
            if (Files.exists(Constants.getCimtCraftFolder("\\features.json"))) {
                try {
                    JsonObject featuresJsonObject = Constants.FILE_MANAGER.readJsonObject(Constants.getCimtCraftFolder("\\features.json"));

                    if (featuresJsonObject != null) {
                        for (PluginFeature pluginFeature : Constants.FEATURE_MANAGER.getPluginFeaturesArrayList()) {
                            if (featuresJsonObject.has(pluginFeature.getFeatureName()))
                                pluginFeature.setEnabled(featuresJsonObject.get(pluginFeature.getFeatureName()).getAsBoolean());
                        }
                    }
                } catch (IOException ioException) {
                    ConsoleLogger.debug("IOException while reading the features.json file!");
                    ioException.printStackTrace();
                }
            } else {
                this.loadAttempts ++;
                this.saveFeatures();
                this.loadFeatures();
            }
        } else {
            ConsoleLogger.debug("Failed to load features.json!");
            CimtCraft.getPlugin(CimtCraft.class).getPluginLoader().disablePlugin(CimtCraft.getPlugin(CimtCraft.class));
        }
    }

    /**
     * <p>Saves the features.</p>
     */
    private void saveFeatures () {
        try {
            if (!(Files.exists(Constants.getCimtCraftFolder(null))))
                Files.createDirectories(Constants.getCimtCraftFolder(null));
        } catch (IOException ioException) {
            ConsoleLogger.debug("IOException while creating the CimtCraft folder!");
            ioException.printStackTrace();
        }

        JsonObject featuresJsonObject = new JsonObject();

        Constants.FEATURE_MANAGER.getPluginFeaturesArrayList().forEach(pluginFeature -> featuresJsonObject.addProperty(pluginFeature.getFeatureName(), pluginFeature.isEnabled()));

        Constants.FILE_MANAGER.saveJsonObject(Constants.getCimtCraftFolder("\\features.json"), featuresJsonObject);
    }
}