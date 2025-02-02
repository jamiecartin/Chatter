import java.util.Scanner;

public class ChatApp {
    private final ChatBot bot;
    private final Scanner scanner = new Scanner(System.in);

    public ChatApp(ChatBot bot) {
        this.bot = bot;
    }

    public void startConsoleChat() {
        System.out.println("ChatBot: Hello! (Type 'exit' to end)");
        
        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("ChatBot: Goodbye!");
                break;
            }
            
            System.out.println("ChatBot: " + bot.respondTo(input));
        }
    }

    public static void main(String[] args) {
        ChatBot bot = new SimpleChatBot();
        // ChatBot bot = new AIChatBot("your-api-key");
        
        // Console version
        new ChatApp(bot).startConsoleChat();
        
        // GUI version
        // SwingUtilities.invokeLater(() -> new ChatGUI(bot));
    }
}
