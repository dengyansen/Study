package designPattern;

import java.util.HashMap;

public interface MediaConfig {
    public String getApiKey();
    public String getVersion();
    public String getBaseUrl();
    public String getAccount();
    public HashMap<String,String> getConfig();
    public String getValue(String key);
}
