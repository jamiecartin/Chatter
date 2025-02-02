public class TypingSimulator {
    public static void simulateTyping(Runnable callback) {
        new Thread(() -> {
            try {
                System.out.print("ChatBot is typing");
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(500);
                    System.out.print(".");
                }
                callback.run();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }).start();
    }
}
