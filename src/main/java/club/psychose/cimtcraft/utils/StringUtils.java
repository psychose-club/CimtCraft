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

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * <p>The StringUtils class provides various utilities to handle with strings.</p>
 * @author CrashedLife
 */

public final class StringUtils {
    /**
     * <p>We are restricting the access, because the class only contain static methods.</p>
     */
    private StringUtils () {}

    /**
     * <p>This method returns a valid path for the used operating system.</p>
     * @param path The path that should be converted to the valid path.
     * @return Replaces the \\ from the path with the separator from {@link File}.
     */
    public static Path getOSPath (Path path) {
        return Paths.get(path.toString().trim().replace("\\", File.separator));
    }
}