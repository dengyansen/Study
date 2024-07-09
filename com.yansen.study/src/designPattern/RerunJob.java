package designPattern;

public class RerunJob implements Job{
    public void process(String start,String end,String event){
        String config = "start:end:reportType:event:sleepM:media";
        String[] args = config.split(":");
        //伪代码...根据不同参数进行重跑，可配置重跑时间、休眠时间等
        String reportType = args[2];
        switch (reportType){
            case "campaign" : new VungleService().campaignReport(args[0],args[1],args[2],null);
            case "adGroup"  :
        }



    }
}
