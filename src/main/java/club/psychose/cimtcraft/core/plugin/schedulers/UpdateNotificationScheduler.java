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

package club.psychose.cimtcraft.core.plugin.schedulers;

import club.psychose.cimtcraft.utils.Constants;
import club.psychose.cimtcraft.utils.JsonUtils;
import club.psychose.cimtcraft.utils.logging.ConsoleLogger;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * <p>The UpdateNotificationScheduler class initializes a scheduler that searches for a new version.</p>
 * @author CrashedLife
 */

public final class UpdateNotificationScheduler {
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

    /**
     * <p>Starts the scheduler.</p>
     */
    public void startScheduler () {
        // Starts the scheduler.
        this.scheduledExecutorService.scheduleAtFixedRate(() -> {
            try {
                JsonObject responseJsonObject = JsonUtils.fetchOnlineJsonObject(Constants.RELEASE_INFORMATION_URL);

                if (responseJsonObject != null) {
                    if (responseJsonObject.has("Latest")) {
                        String latestVersion = responseJsonObject.get("Latest").getAsString();

                        Constants.UPDATE_AVAILABLE = !(Constants.VERSION.equals(latestVersion));
                        return;
                    }
                }

                ConsoleLogger.debug("Latest version not found!");
            } catch (IOException ioException) {
                ConsoleLogger.debug("IOException while searching for an update!");
                ioException.printStackTrace();
            }
        }, 0, 30, TimeUnit.MINUTES);
    }
}