package blood4life.server.access;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import blood4life.commons.infra.Utilities;

public class Factory {

	private static Factory instance;
	private static IConnectionRepository conn;

	private Factory() {
		conn = getConnectionRepository();
	}

	public static Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;

	}

	private IConnectionRepository getConn() {
		if (conn == null) {
			conn = getConnectionRepository();
		}
		return conn;
	}

	private IConnectionRepository getConnectionRepository() {
		IConnectionRepository result = null;
		try {
			result = (IConnectionRepository) Class.forName(Utilities.loadProperty("ConnectionRepository"))
					.getConstructor().newInstance();
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
		}
		if (result == null)
			result = new ConnectionRepository();
		return result;
	}

	public IAssignmentsRepository getAssigmentRepository() {
		IAssignmentsRepository result = null;
		try {
			result = (IAssignmentsRepository) Class.forName(Utilities.loadProperty("AssignmentsRepository"))
					.getConstructor().newInstance(getConn());
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
		}
		if (result == null)
			result = new AssignmentsRepository(getConn());
		return result;
	}

	public IClienteRepository getClienteRepository() {
		IClienteRepository result = null;
		try {
			result = (IClienteRepository) Class.forName(Utilities.loadProperty("ClienteRepository")).getConstructor()
					.newInstance(getConn());
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
		}
		if (result == null)
			result = new ClienteRepository(getConn());
		return result;
	}

	public ILugaresRepository getLugaresRepository() {
		ILugaresRepository result = null;
		try {
			result = (ILugaresRepository) Class.forName(Utilities.loadProperty("LugaresRepository")).getConstructor()
					.newInstance(getConn());
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
		}
		if (result == null)
			result = new LugaresRepository(getConn());
		return result;
	}
        
        public ICitaRepository getCitaRepository() {
		ICitaRepository result = null;
		try {
			result = (ICitaRepository) Class.forName(Utilities.loadProperty("CitaRepository")).getConstructor()
					.newInstance(getConn());
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
			Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
		}
		if (result == null)
			result = new CitaRepository(getConn());
		return result;
	}

}
