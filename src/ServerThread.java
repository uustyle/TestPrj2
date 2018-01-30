public class ServerThread extends Thread {
	private final RequestQueue requestQueue;

	public ServerThread(RequestQueue requestQueue, String name, long seed) {
		super(name);
		this.requestQueue = requestQueue;
	}

	public void run() {

//		this.requestQueue.delRequest();
		this.requestQueue.delRequestAll();

	}
}
