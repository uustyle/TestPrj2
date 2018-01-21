import java.util.ArrayList;
import java.util.List;


public class CacheManager {

    private final List<CacheData> cacheDataList = new ArrayList<CacheData>();

    public synchronized String search(int key) {

    	CacheData cacheData = this.getCacheData(key);
    	if (cacheData == null) {

    		cacheData = new CacheData(0, key, null);
    		cacheDataList.add(cacheData);
    		return null;

    	} else if (cacheData.getStatus() == 2){

    		return cacheData.getResponse();
    	}

    	while (this.getCacheData(key).getStatus() == 1) {
            try {
                System.out.println(Thread.currentThread().getName() + ": wait() begins, queue = " + queue);
                wait();
                System.out.println(Thread.currentThread().getName() + ": wait() ends,   queue = " + queue);
            } catch (InterruptedException e) {
            }
        }
        return queue.remove();
    }

    private CacheData getCacheData(int key) {

    	if (cacheDataList.isEmpty() || cacheDataList.size() == 0) {
    		CacheData cacheData = new CacheData(0, key, null);
    		cacheDataList.add(cacheData);
    		return cacheData;
    	}

    	for(CacheData cacheData : cacheDataList) {

    		if (cacheData.getKey() == key) {
    			return cacheData;
    		}
    	}
		CacheData cacheData = new CacheData(0, key, null);
		cacheDataList.add(cacheData);
		return cacheData;

    }


    public synchronized void putRequest(Request request) {
        queue.offer(request);
        System.out.println(Thread.currentThread().getName() + ": notifyAll() begins, queue = " + queue);
        notifyAll();
        System.out.println(Thread.currentThread().getName() + ": notifyAll() ends, queue = " + queue);
    }



}
