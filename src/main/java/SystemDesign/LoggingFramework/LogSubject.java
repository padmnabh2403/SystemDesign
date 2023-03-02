package SystemDesign.LoggingFramework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogSubject {
//    List<LogObserver> logObservers = new  ArrayList<>();
    Map<Integer, List<LogObserver>> logObservers = new HashMap<>();
    void addObserver(int level, LogObserver logObserver){
        List<LogObserver> logObserverList = logObservers.getOrDefault(level, new ArrayList<>());
        logObserverList.add(logObserver);
        logObservers.put(level,logObserverList);
    }

    void notifyAllObserver(int level, String Msg){
        for(Map.Entry<Integer, List<LogObserver>> entry : logObservers.entrySet()){
            if(entry.getKey() == level){
                entry.getValue().forEach(observer -> observer.log(Msg));
            }
        }
    }
}
