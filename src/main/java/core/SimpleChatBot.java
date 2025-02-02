import java.util.HashMap;

public class SimpleChatBot implements ChatBot {
    private HashMap<String, String> responses = new HashMap<>();
    
    public SimpleChatBot() {
        initializeResponses();
    }
    
    private void initializeResponses() {
        responses.put("hello", "Hello there!");
        responses.put("how are you", "I'm just a program, but I'm doing great!");
        // Add more responses
    }
    
    @Override
    public String respondTo(String input) {
        return responses.entrySet().stream()
            .filter(entry -> input.toLowerCase().contains(entry.getKey()))
            .findFirst()
            .orElse(responses.get("default"))
            .getValue();
    }
}
