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
import club.psychose.cimtcraft.utils.logging.PlayerLogger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * <p>The PlayerJoinEventListener class listens for events where a player joins the server.</p>
 * @see Listener
 * @see PlayerJoinEvent
 * @author CrashedLife
 */

public final class PlayerJoinEventListener implements Listener {
    /**
     * <p>This method executes specific actions when a player joins the server.</p>
     * @param playerJoinEvent Passed event from the {@link EventHandler} and {@link Listener}.
     */
    @EventHandler
    public void onPlayerJoinEvent (PlayerJoinEvent playerJoinEvent) {
        Player player = playerJoinEvent.getPlayer();

        if ((player.hasPermission("cimtcraft.update.notification")) && (Constants.UPDATE_AVAILABLE)) {
            PlayerLogger.sendMessage(player, "§aA plugin update is available!");
            PlayerLogger.sendMessage(player, "§aTo download the latest version, click here:");
            PlayerLogger.sendMessage(player, "https://github.com/psychose-club/CimtCraft/releases/latest");
        }
    }
}