import java.util.concurrent.ConcurrentHashMap;

public class RequestQueue {
	private final ConcurrentHashMap<String, StructDto> queue = new ConcurrentHashMap<String, StructDto>();

	public synchronized StructDto getRequest() {

		StructDto dto = new StructDto();
		dto.setName("name");
		queue.put("key1", dto);

		delRequestAll();

		dto = new StructDto();
		dto.setName("name2");
		queue.put("key1", dto);

		StructDto dto2 = this.queue.get("key1");

		return dto2;

	}

	public synchronized void delRequest() {

		this.queue.remove("key1");

	}

	public synchronized void delRequestAll() {

		for (String key : this.queue.keySet()) {
			this.queue.remove(key);
		}

	}

}
