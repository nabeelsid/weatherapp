import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.net.URL;
import java.net.URLConnection;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class weather {
	
	public weather() {
		JFrame frame = new JFrame(); //First create this object 
		JPanel panel = new JPanel(); //panel goes inside the frame
		JButton button = new JButton("Find Weather");
		JLabel label =  new JLabel("Get Weather");
		panel.setBorder(BorderFactory.createEmptyBorder(50, 150, 0, 150));
		panel.setLayout(new GridLayout(2,2));
		panel.add(button);
		
		
		
		frame.add(panel, BorderLayout.CENTER); //here we add the panel in the frame with border as Center
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Weather GUI");
		frame.pack();
		frame.setVisible(true);
	}

	public static String cityCall() {
		Scanner input = new Scanner(System.in);
		System.out.print("Please Enter a City : ");
		String cityInput = input.next().toLowerCase().trim();
		// input.close();
		return cityInput;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "resource" })
	public static void main(String[] args) {
		weather myWeather = new weather();
		try {
			String cityInput = cityCall();
			while (cityInput != "exit") {
				if (cityInput == "exit") {
					break;
				} else {
					String city;
					int weatherInfo[] = new int[6];
					int count = 0;

					// URL
					URL oracle = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + cityInput
							+ "&appid=94f833994ddbbc5e6c563669a6ea5bb4");
					URLConnection yc = oracle.openConnection();
					BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
					String inputLine = in.readLine();
					Object obj = new JSONParser().parse(inputLine);

					JSONObject jo = (JSONObject) obj;
					city = (String) jo.get("name");
					Map main = ((Map) jo.get("main"));
					Iterator<Map.Entry> itr1 = main.entrySet().iterator();
					while (itr1.hasNext()) {
						Map.Entry pair = itr1.next();
						// System.out.println(pair.getKey() + " : " + pair.getValue());
						weatherInfo[count] = (int) Double.parseDouble(pair.getValue().toString()); // cast double to int
																									// so
																									// that it
																									// automatically
																									// rounds down
						count++;
					}
					System.out.printf("\nWeather info for %s\n", city);
					System.out.printf("\nCurrent Temp	: %d C	Feels like	: %d C\n\n", (weatherInfo[0] - 273),
							(weatherInfo[4] - 273));
					System.out.printf("Today's Min	: %d C	Today's Max	: %d C\n", (weatherInfo[1] - 273),
							(weatherInfo[5] - 273));
					cityInput = cityCall();
				}
			}
			
		} catch (FileNotFoundException e) {
			// System.out.println("Invalid argument. No such city");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
