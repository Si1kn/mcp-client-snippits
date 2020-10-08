# EventSystem

Hello. I created this event System because i couldn't find any good ones.


* ***Call Event***
```
EventManager.getInstance().call(new Event());
```
 * ***To Setup Listner Class:***
 
 ``` LANG: JAVA
import EventProcess;
import EListener;

public class ExampleClass implements EListener{ 

	@EventProcess
	public void onEvent(final Event e) 
    {
		System.out.println("CALLED");
	}
}

```
  *To Use It*
   
  
  Put this In Your Main Or Init funtion Put this. 
   ```EventManager.getInstance().addListener(new ExampleClass());```
   * The Event Class:
``` 
import IEvent;

public class Stop extends IEvent {

	public Stop() {
		
	}

}
```
