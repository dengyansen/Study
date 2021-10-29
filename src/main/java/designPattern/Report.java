package designPattern;

import java.util.List;
import java.util.Map;

public interface Report {
    public List<Object> campaignReport(String start, String end,String event, Map<String,String> arg);
    public List<Object> adGroupReport(String start, String end,String event, Map<String,String> arg);
    public List<Object> adReport(String start, String end,String event, Map<String,String> arg);
}
