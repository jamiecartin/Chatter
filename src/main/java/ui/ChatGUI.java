import javax.swing.*;

public class ChatGUI extends JFrame {
    private final ChatBot bot;
    private JTextArea chatArea = new JTextArea();
    
    public ChatGUI(ChatBot bot) {
        this.bot = bot;
        initializeUI();
    }
    
    private void initializeUI() {
        JTextField inputField = new JTextField();
        inputField.addActionListener(e -> {
            String input = inputField.getText();
            chatArea.append("\nYou: " + input);
            String response = bot.respondTo(input);
            chatArea.append("\nBot: " + response);
            inputField.setText("");
        });
        
        add(new JScrollPane(chatArea), BorderLayout.CENTER);
        add(inputField, BorderLayout.SOUTH);
    }
}
