package db.obj;

import java.util.Vector;

/**
 * Created by Eldath on 2017/1/23 0023.
 *
 * @author Eldath
 */
public class ClientIds {
	private Vector<String> clientIds;

	public ClientIds() {
		clientIds = new Vector<>();
	}

	public Vector<String> getClientIds() {
		return clientIds;
	}

	public boolean addClientId(String clientId) {
		return clientIds.add(clientId);
	}
}
