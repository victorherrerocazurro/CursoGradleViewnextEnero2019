package com.curso.gradle.plugins;

public class TomcatPluginExtension {
    private String originDir;
    private String deployDir;
    private String tomcatHome;
    private String warName;

    public String getWarName() {
        return warName;
    }

    public void setWarName(String warName) {
        this.warName = warName;
    }

    public String getOriginDir() {
        return originDir;
    }

    public void setOriginDir(String originDir) {
        this.originDir = originDir;
    }

    public String getDeployDir() {
        return deployDir;
    }

    public void setDeployDir(String deployDir) {
        this.deployDir = deployDir;
    }

    public String getTomcatHome() {
        return tomcatHome;
    }

    public void setTomcatHome(String tomcatHome) {
        this.tomcatHome = tomcatHome;
    }
}
