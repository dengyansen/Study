package designPattern;

import java.util.List;

public class CommLogProcess implements ApiLog{
    @Override
    public void deal(List<Object> list, String event) {
        for(Object json :list){
            //api.log(json,event);
            //todo....
        }
    }
}
