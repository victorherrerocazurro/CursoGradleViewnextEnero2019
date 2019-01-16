package com.curso.gradle.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class CustomPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {

        CustomPluginExtension extension = project.getExtensions().create("custom", CustomPluginExtension.class);

        project.task("copiar").doLast(task -> {
                if(project.hasProperty("descripcion")) {
                    project.copy(copySpec -> {
                        copySpec.from(extension.getFrom());
                        copySpec.include(extension.getInclude());
                        copySpec.into(extension.getInto());
                    });
                }
        });
        project.task("copiar2").doLast(task -> {
            if(project.hasProperty("descripcion")) {
                project.copy(copySpec -> {
                    copySpec.from("/");
                    copySpec.include("*.gradle");
                    copySpec.into("build/");
                });
            }
        });
    }
}
