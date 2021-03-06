/*
 * ProActive Parallel Suite(TM):
 * The Open Source library for parallel and distributed
 * Workflows & Scheduling, Orchestration, Cloud Automation
 * and Big Data Analysis on Enterprise Grids & Clouds.
 *
 * Copyright (c) 2007 - 2017 ActiveEon
 * Contact: contact@activeeon.com
 *
 * This library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Affero General Public License
 * as published by the Free Software Foundation: version 3 of
 * the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * If needed, contact us to obtain a release under GPL Version 2 or 3
 * or a different license than the AGPL.
 */
package jsr223.cpython.python;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.objectweb.proactive.utils.OperatingSystem;


/**
 * @author ActiveEon Team
 * @since 05/10/2017
 */
public class PythonCommandCreator {

    /**
     * This method is used to create a bash command which executes a python script with a given python file
     * @param pythonFile
     * @param pythonVersion the version of Python (either 2 or 3)
     * @return A String which contains the command
     */
    public String[] createPythonExecutionCommand(File pythonFile, String pythonVersion) {
        List<String> command = new ArrayList<>();

        if (OperatingSystem.getOperatingSystem() == OperatingSystem.windows) {
            // if the operating system is windows, the PATH environment variable is not taken into account unless wrapped in cmd call
            command.add("cmd");
            command.add("/c");
        }

        //Add Python Command
        command.add(pythonVersion);

        //Add the file path
        command.add(pythonFile.getPath());

        return command.toArray(new String[command.size()]);
    }

    public String[] createPythonCommandWithParameter(File pythonFile, String pythonVersion, String parameter) {
        List<String> command = new ArrayList<>();

        if (OperatingSystem.getOperatingSystem() == OperatingSystem.windows) {
            // if the operating system is windows, the PATH environment variable is not taken into account unless wrapped in cmd call
            command.add("cmd");
            command.add("/c");
        }

        command.add(pythonVersion);

        if (pythonFile != null) {
            command.add(pythonFile.getPath());
        }

        command.add(parameter);

        return command.toArray(new String[command.size()]);
    }

}
