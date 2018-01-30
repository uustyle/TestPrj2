
public class ClientThread extends Thread {

    private final RequestQueue requestQueue;
    public ClientThread(RequestQueue requestQueue, String name, long seed) {
        super(name);
        this.requestQueue = requestQueue;
    }
    public void run() {

    	StructDto dto = this.requestQueue.getRequest();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
        }


		System.out.println(dto.getName());
    }
}
