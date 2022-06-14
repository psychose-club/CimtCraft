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

package club.psychose.cimtcraft.utils.logging;

import club.psychose.cimtcraft.utils.Constants;
import org.bukkit.entity.Player;

/**
 * <p>The PlayerLogger class provides methods to send information to the player.</p>
 * @author CrashedLife
 */

public final class PlayerLogger {
    /**
     * <p>This method sends a message to the player.</p>
     * @param player Player which will receive the message.
     * @param message The message which will be sent.
     */
    public static void sendMessage (Player player, String message) {
        player.sendMessage(Constants.PREFIX + message);
    }
}