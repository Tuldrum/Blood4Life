package blood4life.server.access;

import blood4life.commons.infra.Utilities;

public class Factory {

    private static Factory instance;
    private static IConnectionRepository conn;  
    
    private Factory() {
    	conn = new ConnectionRepository();  
    }
    
    public static Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;

    }

	private IConnectionRepository getConn() {
		return conn;
	}
    

    
}
