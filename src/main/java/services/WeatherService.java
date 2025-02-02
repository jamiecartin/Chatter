import org.json.JSONObject;
import java.net.*;

public class WeatherService {
    private static final String API_URL = "https://api.openweathermap.org/data/2.5/weather";
    private final String apiKey;

    public WeatherService(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getWeather(String city) throws IOException {
        URL url = new URL(API_URL + "?q=" + city + "&appid=" + apiKey);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        
        try (BufferedReader reader = new BufferedReader(
            new InputStreamReader(conn.getInputStream()))) {
            
            JSONObject json = new JSONObject(reader.readLine());
            return json.getJSONArray("weather")
                .getJSONObject(0)
                .getString("description");
        }
    }
}
