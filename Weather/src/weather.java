
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.net.URL;
import java.net.URLConnection;
//import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class weather {
	// 94f833994ddbbc5e6c563669a6ea5bb4 my openWeather Api key.
	private String cityName;
	//private String city;
	private String APIkey;
	private int currentTemp;
	private int minTemp;
	private int maxTemp;
	private int feelsLike;
	private final int kelvin = 273;

	/**
	 * Creates a default weather object with toronto as city but no API key
	 * associated with it. API key must be set before using fetch
	 */
	public weather() {
		this.cityName = "tornoto";
		this.APIkey = "94f833994ddbbc5e6c563669a6ea5bb4";
	}

	/**
	 * Creates a weather object and pulls relevant weather forecast information
	 * about the given location
	 * 
	 * @param cityName   - The city of the requested information
	 * @param yourAPIkey - The API Key from OpenWeather (Should obtain one before
	 *                   hand)
	 */

	public weather(String cityName, String yourAPIkey) {
		this.cityName = cityName;
		this.APIkey = yourAPIkey;
	}

	/**
	 * This method fetches the weather information
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void fetchWeather() {
		try {

			String cityInput = cityName.toLowerCase().trim();
			
			int weatherInfo[] = new int[6];
			int count = 0;

			// URL
			URL oracle = new URL("http://api.openweathermap.org/data/2.5/weather?q=" + cityInput + "&appid=" + APIkey);
			URLConnection yc = oracle.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
			String inputLine = in.readLine();
			Object obj = new JSONParser().parse(inputLine);
			
			JSONObject jo = (JSONObject) obj;
			
			Map sys = ((Map) jo.get("sys"));
			String country = (String) sys.get("country"); //fetch country
			
			this.cityName = (String) jo.get("name") + ", "+country;
			Map main = ((Map) jo.get("main"));
			Iterator<Map.Entry> itr1 = main.entrySet().iterator();
			while (itr1.hasNext()) {
				Map.Entry pair = itr1.next();
				// cast double to int so that it automatically rounds down
				weatherInfo[count] = (int) Double.parseDouble(pair.getValue().toString());
				count++;
			}
			
			this.currentTemp = weatherInfo[0] - kelvin;
			this.feelsLike = weatherInfo[4] - kelvin;
			this.minTemp = weatherInfo[1] - kelvin;
			this.maxTemp = weatherInfo[5] - kelvin;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method returns an int representing today's current temperature in degree
	 * C
	 * 
	 * @return Current weather in degree C
	 */
	public int getCurrentWeather() {
		return this.currentTemp;
	}

	/**
	 * This method returns an int representing today's feel's like temperature in
	 * degree C
	 * 
	 * @return Feels like temperature in degree C
	 */
	public int getFeelsLike() {
		return this.feelsLike;
	}

	/**
	 * This method returns an int representing today's Min temp in degree C
	 * 
	 * @return Today's minimum temperature in degreeC
	 */
	public int getTodaysMin() {
		return this.minTemp;
	}

	/**
	 * This method returns an int representing today's Max temp in degree C
	 * 
	 * @return Today's maximum temperature in degree C
	 */
	public int getTodaysMax() {
		return this.maxTemp;
	}

	/**
	 * This method returns a string representation of the city's name
	 * 
	 * @return Name of the city as a string
	 */
	public String getCity() {
		return this.cityName;
	}

	/**
	 * This method sets the current city to city
	 * 
	 * @param city - Name of the city to be set
	 */
	public void setCity(String city) {
		this.cityName = city;
	}

	/**
	 * This method sets the current API key to APIkey
	 * 
	 * @param APIkey - The API key to be used to fetch weather information
	 */
	public void setAPIkey(String APIkey) {
		this.APIkey = APIkey;
	}

}
