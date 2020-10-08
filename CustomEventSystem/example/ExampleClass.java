
import EventProcess;
import EListener;

public class ExampleClass implements EListener{

	@EventProcess
	public void onEvent(final Event e) {
		System.out.println("CALLED");
	}
}
