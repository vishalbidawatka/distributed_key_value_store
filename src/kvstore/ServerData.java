package kvstore;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServerData {
	
	public ConcurrentHashMap <String, String> map = new ConcurrentHashMap<String, String>();
	public ConcurrentHashMap <String, String> replicaMap = new ConcurrentHashMap<String, String>();
	public ConcurrentHashMap <String, String> tempMap = new ConcurrentHashMap<String, String>();
	public ConcurrentHashMap <String, String> tempReplicaMap = new ConcurrentHashMap<String, String>();
	public HashMap <String, Boolean> mapLock = new HashMap <String, Boolean>();
	public Lock lock;
	public ServerData() {
		lock = new ReentrantLock(true);
	}

	public ServerData(ConcurrentHashMap<String, String> map, ConcurrentHashMap<String, String> replicaMap,
			ConcurrentHashMap<String, String> tempMap, ConcurrentHashMap<String, String> tempReplicaMap) {
		super();
		this.map = map;
		this.replicaMap = replicaMap;
		this.tempMap = tempMap;
		this.tempReplicaMap = tempReplicaMap;
		this.lock = new ReentrantLock(true);
	}

	public ConcurrentHashMap<String, String> getMap() {
		return map;
	}

	public void setMap(ConcurrentHashMap<String, String> map) {
		this.map = map;
	}

	public ConcurrentHashMap<String, String> getReplicaMap() {
		return replicaMap;
	}

	public void setReplicaMap(ConcurrentHashMap<String, String> replicaMap) {
		this.replicaMap = replicaMap;
	}

	public ConcurrentHashMap<String, String> getTempMap() {
		return tempMap;
	}

	public void setTempMap(ConcurrentHashMap<String, String> tempMap) {
		this.tempMap = tempMap;
	}

	public ConcurrentHashMap<String, String> getTempReplicaMap() {
		return tempReplicaMap;
	}

	public void setTempReplicaMap(ConcurrentHashMap<String, String> tempReplicaMap) {
		this.tempReplicaMap = tempReplicaMap;
	}
	public void getLock() {
		this.lock.lock();
	}
	public void put(String key, String value) {
		
		
	}
	
	public String get(String key) {
		if(this.map.containsKey(key))
			return this.map.get(key);
		else
			return "";
	}
	public String getFromReplica(String key) {
		if(this.replicaMap.containsKey(key))
			return this.replicaMap.get(key);
		else
			return "";
	}
	

}
