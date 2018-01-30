
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "Alice", 3141592L).start();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        new ServerThread(requestQueue, "Bobby", 6535897L).start();
    }
}
