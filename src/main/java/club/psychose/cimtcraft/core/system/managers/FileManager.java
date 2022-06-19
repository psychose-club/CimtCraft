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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * <p>The FileManager class manages files and creates automatically the needed directories for the plugin content.</p>
 * @author CrashedLife
 */

public final class FileManager {
    /**
     * <p>Reads a file as JsonObject.</p>
     * @param inputPath The location where the file is stored.
     * @return {@link JsonObject}
     * @throws IOException Signals that an I/O exception of some sort has occurred. This
     * class is the general class of exceptions produced by failed or
     * interrupted I/O operations.
     */

    public JsonObject readJsonObject (Path inputPath) throws IOException {
        if (Files.exists(inputPath)) {
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.setPrettyPrinting().create();

            try (FileReader fileReader = new FileReader(inputPath.toFile())) {
                return gson.fromJson(fileReader, JsonObject.class);
            }
        }

        return null;
    }

    /**
     * <p>Saves the JsonObject to a file.</p>
     * @param outputPath The location where the file should be saved.
     * @param jsonObject The JsonObject that should be saved.
     */
    public void saveJsonObject (Path outputPath, JsonObject jsonObject) {
        // Setup Gson.
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();

        // Creates the file and writes the JsonObject to it.
        try (FileWriter fileWriter = new FileWriter(outputPath.toFile())) {
            gson.toJson(jsonObject, fileWriter);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}