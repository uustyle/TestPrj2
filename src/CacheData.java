
public class CacheData {

    private int status;

    private int key;

    private String response;

	public CacheData(int status, int key, String response) {
		super();
		this.status = status;
		this.key = key;
		this.response = response;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}




}
