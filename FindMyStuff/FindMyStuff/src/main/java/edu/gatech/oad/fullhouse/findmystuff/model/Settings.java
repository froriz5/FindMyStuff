package edu.gatech.oad.fullhouse.findmystuff.model;

public class Settings {

    private static Settings _instance;
    private String serverUrl;
    
    private Settings() {
        
    }
    
    public static Settings instance() {
        if (_instance == null) {
            _instance = new Settings();
        }
        return _instance;
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }
}
