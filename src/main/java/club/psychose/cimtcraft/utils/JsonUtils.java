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

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * <p>The JsonUtils class contains utilities for handling JsonObjects.</p>
 * @author CrashedLife
 */

public final class JsonUtils {
    /**
     * <p>This methods fetches website content to a {@link JsonObject}.</p>
     * @param url URL that contains the content.
     * @return {@link JsonObject}
     * @throws IOException Signals that an I/O exception of some sort has occurred. This
     * class is the general class of exceptions produced by failed or
     * interrupted I/O operations.
     */
    public static JsonObject fetchOnlineJsonObject (String url) throws IOException {
        // Setups the variables to read the JsonObject.
        InputStream inputStream = new URL(url).openStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();

        // Reads the website content.
        int line;
        while ((line = bufferedReader.read()) != -1) {
            stringBuilder.append((char) line);
        }

        // Closes the streams.
        bufferedReader.close();
        inputStream.close();

        // Converts the JsonObject and returns it.
        return new Gson().fromJson(stringBuilder.toString().trim(), JsonObject.class);
    }
}