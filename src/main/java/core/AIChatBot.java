import org.json.JSONObject;
import java.net.*;

public class AIChatBot implements ChatBot {
    private static final String API_URL = "https://api.openai.com/v1/chat/completions";
    private final String apiKey;

    public AIChatBot(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public String respondTo(String input) {
        try {
            return getChatGPTResponse(input);
        } catch (IOException e) {
            return "I'm having trouble connecting right now.";
        }
    }
  private static String getChatGPTResponse(String prompt) throws IOException {
        URL url = new URL(API_URL);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", "Bearer " + API_KEY);

        JSONObject requestBody = new JSONObject();
        requestBody.put("model", "gpt-3.5-turbo");
        
        JSONObject message = new JSONObject();
        message.put("role", "user");
        message.put("content", prompt);
        requestBody.append("messages", message);
        requestBody.put("temperature", 0.7);

        conn.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
        wr.writeBytes(requestBody.toString());
        wr.flush();
        wr.close();

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        
        while ((line = br.readLine()) != null) {
            response.append(line);
        }
        br.close();

        JSONObject jsonResponse = new JSONObject(response.toString());
        return jsonResponse.getJSONArray("choices")
                .getJSONObject(0)
                .getJSONObject("message")
                .getString("content");
    }
}
