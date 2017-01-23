package db;

import db.obj.ClientIds;

import java.util.HashMap;

/**
 * Created by Eldath on 2017/1/23 0023.
 *
 * @author Eldath
 */
public class ClientIdsPool {
	private HashMap<String, ClientIds> clientIdsMap = new HashMap<>();
	private static ClientIdsPool instance = null;

	public static ClientIdsPool getInstance() {
		if (instance == null) instance = new ClientIdsPool();
		return instance;
	}

	private ClientIdsPool() {
		clientIdsMap.put("quiz", new ClientIds());
	}

	public void addClientIds(String sign, ClientIds addOn) {
		clientIdsMap.put(sign, addOn);
	}

	public ClientIds getClientIds(String sign) {
		return clientIdsMap.get(sign);
	}

	public void destoryClientIds(String sign) {
		clientIdsMap.remove(sign);
	}
}
