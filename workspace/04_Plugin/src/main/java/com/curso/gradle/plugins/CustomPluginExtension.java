package com.curso.gradle.plugins;

public class CustomPluginExtension {
    private String from;
    private String include;
    private String into;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include;
    }

    public String getInto() {
        return into;
    }

    public void setInto(String into) {
        this.into = into;
    }
}
