import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class UserProfile {
    private String userId;
    private String name;
    private LocalDateTime lastSeen;
    private List<String> conversationHistory = new ArrayList<>();
    
    public void addToHistory(String message) {
        conversationHistory.add(message);
    }
}
