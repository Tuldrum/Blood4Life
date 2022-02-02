package blood4life.server.access;

import java.sql.Connection;

public interface IConnectionRepository {
	
	public void disconnect();
	public Connection getConn();
}
