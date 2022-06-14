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

/**
 * <p>The PluginFeature class defines a feature that offers the plugin.</p>
 * <p>It'll register all features in {@link club.psychose.cimtcraft.core.system.managers.FeatureManager}</p>
 * @author CrashedLife
 */

public final class PluginFeature {
    /**
     * <p>Defines the feature variables.</p>
     */
    private final String featureName;
    private boolean enabled;

    /**
     * <p>Public constructor.</p>
     * @param featureName Defines the name of the plugin feature.
     * @param enabled Sets the enabled status of the feature.
     */
    public PluginFeature (String featureName, boolean enabled) {
        this.featureName = featureName;
        this.enabled = enabled;
    }

    /**
     * <p>Sets the enabled status.</p>
     * @param value Accepts true or false (on or off) as value.
     */
    public void setEnabled (boolean value) {
        this.enabled = value;
    }

    /**
     * <p>Returns the feature name.</p>
     * @return Feature Name
     */
    public String getFeatureName () {
        return this.featureName;
    }

    /**
     * <p>Returns the enabled status.</p>
     * @return Enabled
     */
    public boolean isEnabled () {
        return this.enabled;
    }
}