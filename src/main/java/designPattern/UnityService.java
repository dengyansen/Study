package designPattern;

import java.util.List;
import java.util.Map;

public class UnityService implements Report{
    private UnityConfig config;
    private CommUtil util;

    @Override
    public List<Object> campaignReport(String start, String end, String event,Map<String, String> arg) {
        return null;
    }

    @Override
    public List<Object> adGroupReport(String start, String end, String event, Map<String, String> arg) {
        return null;
    }

    @Override
    public List<Object> adReport(String start, String end, String event, Map<String, String> arg) {
        return null;
    }
}
