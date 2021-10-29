package designPattern;

import java.util.List;

public class UnityJob implements Job{
    private UnityService service;
    private CommLogProcess commLogProcess;
    public void process(){
        List<Object> report = service.adReport("","","",null);
        //伪代码..
        commLogProcess.deal(report,"");
    }
}
