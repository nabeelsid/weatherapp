
public class root {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		weather w = new weather("mississauga", "94f833994ddbbc5e6c563669a6ea5bb4"); //construct with city and API key.
		weather w1 = new weather(); //construct without any parameters
		w.fetchWeather();
		System.out.println(w.getCurrentWeather());
		System.out.println(w.getCity());
		
		w1.setCity("dubai");
		w1.setAPIkey("94f833994ddbbc5e6c563669a6ea5bb4");
		w1.fetchWeather();
		System.out.println(w1.getCurrentWeather());
		System.out.println(w1.getCity());
		
		weatherGUI GUI = new weatherGUI();
		while(GUI.getInput() == null) {
			
		}
		System.out.println(GUI.getInput());
	}

}
