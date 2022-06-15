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

import club.psychose.cimtcraft.core.plugin.features.PluginFeature;

import java.util.ArrayList;

/**
 * <p>The FeatureManager class provides the methods to initialize the plugin features.</p>
 * @see PluginFeature
 * @author CrashedLife
 */

public final class FeatureManager {
    /**
     * <p>This ArrayList stores all registered {@link PluginFeature}.</p>
     */
    private final ArrayList<PluginFeature> pluginFeaturesArrayList = new ArrayList<>();

    /**
     * <p>This method initialize the hardcoded {@link PluginFeature}.</p>
     */
    public void initializeFeatures () {
        this.pluginFeaturesArrayList.add(new PluginFeature("Break Spawners", true));
        this.pluginFeaturesArrayList.add(new PluginFeature("Change Spawners", true));
        this.pluginFeaturesArrayList.add(new PluginFeature("Craft Spawn Eggs", true));
        this.pluginFeaturesArrayList.add(new PluginFeature("Chunk Loader", true));
        this.pluginFeaturesArrayList.add(new PluginFeature("Timber", true));
    }

    /**
     * <p>This boolean checks if a feature has the enabled state set to true.</p>
     * @param featureName Name of the feature that will be checked.
     * @return true or false
     */
    public boolean isFeatureEnabled (String featureName) {
        return this.pluginFeaturesArrayList.stream().filter(pluginFeature -> pluginFeature.getFeatureName().equals(featureName)).findFirst().filter(PluginFeature::isEnabled).isPresent();
    }

    /**
     * <p>Here we'll return the ArrayList that stores all registered {@link PluginFeature}</p>
     * @return Registered {@link PluginFeature}
     */
    public ArrayList<PluginFeature> getPluginFeaturesArrayList () {
        return this.pluginFeaturesArrayList;
    }
}