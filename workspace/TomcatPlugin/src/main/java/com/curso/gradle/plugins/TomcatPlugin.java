package com.curso.gradle.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.Copy;
import org.gradle.api.tasks.Exec;

public class TomcatPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {

        TomcatPluginExtension extension = project.getExtensions().create("tomcat", TomcatPluginExtension.class);

        project.task("desplegar").doLast(task -> {
            task.setGroup("tomcat");
            project.copy(copySpec -> {
                copySpec.from(extension.getOriginDir());
                copySpec.into(extension.getDeployDir());
            });
        });

        project.task("arrancar").doLast(task -> {
            task.setGroup("tomcat");
            project.exec(execSpec -> {
                execSpec.setWorkingDir(extension.getTomcatHome() + "\\bin");
                execSpec.setCommandLine("cmd", "/c", "startup.bat");
            });
        });

        project.task("parar").doLast(task -> {
            task.setGroup("tomcat");
            project.delete(extension.getDeployDir() + "\\" + extension.getWarName() + ".war");
            project.delete(extension.getDeployDir() + "\\" + extension.getWarName() + "\\");
            project.exec(execSpec -> {
                execSpec.setWorkingDir(extension.getTomcatHome() + "\\bin");
                execSpec.setCommandLine("cmd", "/c", "shutdown.bat");
            });
        });
    }
}
