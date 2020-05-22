/*
 * Copyright (c) 2020 Dzikoysk
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.panda_lang.reposilite.config;

import org.panda_lang.reposilite.Reposilite;
import org.panda_lang.reposilite.ReposiliteConstants;
import org.panda_lang.reposilite.utils.FilesUtils;
import org.panda_lang.reposilite.utils.YamlUtils;

import java.io.File;
import java.io.IOException;

public final class ConfigurationLoader {

    public Configuration load() throws IOException {
        File configurationFile = new File(ReposiliteConstants.CONFIGURATION_FILE_NAME);

        if (!configurationFile.exists()) {
            Reposilite.getLogger().info("Generating default configuration file.");
            FilesUtils.copyResource("/reposilite.yml", ReposiliteConstants.CONFIGURATION_FILE_NAME);
        }
        else {
            Reposilite.getLogger().info("Using an existing configuration file");
        }

        Reposilite.getLogger().info("");
        return YamlUtils.load(configurationFile, Configuration.class);
    }


}
