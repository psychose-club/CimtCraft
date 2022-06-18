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

package club.psychose.cimtcraft.core.plugin.listeners;

import club.psychose.cimtcraft.utils.Constants;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

/**
 * <p>The BlockPlaceEventListener class listens for events where a player places a block.</p>
 * @see Listener
 * @see BlockPlaceEvent
 * @author CrashedLife
 */

public final class BlockPlaceEventListener implements Listener {
    /**
     * <p>This method executes specific actions when a block was placed by a player.</p>
     * @param blockPlaceEvent Passed event from the {@link EventHandler} and {@link Listener}.
     */
    @EventHandler
    public void onBlockPlace (BlockPlaceEvent blockPlaceEvent) {
        // Checks if the Break Spawners module is enabled.
        if (Constants.FEATURE_MANAGER.isFeatureEnabled("Break Spawners"))
            Constants.FEATURE_MANAGER.getPluginFeatureViaName("Break Spawners").onBlockPlaceEvent(blockPlaceEvent);
    }
}