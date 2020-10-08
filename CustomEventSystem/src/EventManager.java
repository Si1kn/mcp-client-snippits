package io.github.Si1kn.Event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

import io.github.Si1kn.Event.EI.EListener;
import io.github.Si1kn.Event.EI.IEvent;

public class EventManager {

    private static EventManager instance;
    private Map<EListener, List<Method>> listeners;

    private EventManager(){
        this.listeners = new HashMap<>();
    }

    public void addListener(EListener e){
        if(!listeners.containsKey(e)){
            List<Method> tmp = new ArrayList<>();
            for(Method m : e.getClass().getMethods()){
                Object b = m.getAnnotation(EventProcess.class);
                if(b != null && !tmp.contains(m)){
                    tmp.add(m);
                }
            }
            listeners.put(e, tmp);
        }
    }

    public void removeListener(EListener e){
        listeners.remove(e);
    }

    public boolean call(IEvent e){
        AtomicBoolean cancelled = new AtomicBoolean(false);
        this.listeners.forEach((el, m) -> m.forEach(fm ->{
            if(fm != null && fm.getParameterTypes()[0] != null && fm.getParameterTypes()[0].getSimpleName().equals(e.getClass().getSimpleName())){
                try {
                    fm.invoke(el, e);
                    cancelled.set(e.isCancelled());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }));
        return cancelled.get();
    }

    public static EventManager getInstance(){
        if(instance == null)
            instance = new EventManager();
        return instance;
    }

}