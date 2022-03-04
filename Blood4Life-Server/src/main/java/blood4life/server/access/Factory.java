package blood4life.server.access;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

import blood4life.commons.infra.Utilities;
import blood4life.server.access.users.ClienteRepository;
import blood4life.server.access.users.IClienteRepository;

public class Factory {

    private static Factory instance;
    private static IConnectionRepository conn;
    private IAssignmentsRepository assisRepo = null;
    private IClienteRepository ClienteRepo = null;
    private ILugaresRepository LugarRepo = null;
    private ICitaRepository citaRepo = null;
    private ISangreRepository SangreRepo = null;
    private ICitaAsignadaRepository citAsigRepo = null;
    private IEntidadRepository entidadrepo = null; 

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
        if (result == null) {
            result = new ConnectionRepository();
        }
        return result;
    }

    public IAssignmentsRepository getAssigmentRepository() {
        if (assisRepo == null) {
            try {
                assisRepo = (IAssignmentsRepository) Class.forName(Utilities.loadProperty("AssignmentsRepository"))
                        .getConstructor(IConnectionRepository.class, ILugaresRepository.class, IEntidadRepository.class)
                        .newInstance(getConn(), getLugaresRepository(), getEntidadRepository());
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                    | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (assisRepo == null) {
                assisRepo = new AssignmentsRepository(getConn(), getLugaresRepository(), getEntidadRepository());
            }
        }
        return assisRepo;
    }

    public IClienteRepository getClienteRepository() {
        if (ClienteRepo == null) {
            try {
                ClienteRepo = (IClienteRepository) Class.forName(Utilities.loadProperty("ClienteRepository"))
                        .getConstructor(IConnectionRepository.class, ISangreRepository.class).newInstance(getConn(), getSangreRepository());
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                    | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (ClienteRepo == null) {
                ClienteRepo = new ClienteRepository(getConn(), getSangreRepository());
            }
        }
        return ClienteRepo;
    }

    public ILugaresRepository getLugaresRepository() {
        if (LugarRepo == null) {
            try {
                LugarRepo = (ILugaresRepository) Class.forName(Utilities.loadProperty("LugaresRepository"))
                        .getConstructor(IConnectionRepository.class).newInstance(getConn());
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                    | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (LugarRepo == null) {
                LugarRepo = new LugaresRepository(getConn());
            }
        }
        return LugarRepo;
    }

    public ICitaRepository getCitaRepository() {
        if (citaRepo == null) {
            try {
                citaRepo = (ICitaRepository) Class.forName(Utilities.loadProperty("CitaRepository"))
                        .getConstructor(IConnectionRepository.class, ILugaresRepository.class)
                        .newInstance(getConn(), getLugaresRepository());
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                    | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (citaRepo == null) {
                citaRepo = new CitaRepository(getConn(), getLugaresRepository());
            }
        }
        return citaRepo;
    }

    public ISangreRepository getSangreRepository() {
        if (SangreRepo == null) {
            try {
                SangreRepo = (ISangreRepository) Class.forName(Utilities.loadProperty("SangreRepository"))
                        .getConstructor(IConnectionRepository.class).newInstance(getConn());
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                    | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (SangreRepo == null) {
                SangreRepo = new SangreRepository(getConn());
            }
        }
        return SangreRepo;
    }

    public ICitaAsignadaRepository getCitaAsignadaRepository() {
        if (citAsigRepo == null) {
            try {
                citAsigRepo = (ICitaAsignadaRepository) Class.forName(Utilities.loadProperty("CitaAsignadaRepository"))
                        .getConstructor(
                                ICitaRepository.class,
                                IClienteRepository.class,
                                IConnectionRepository.class)
                        .newInstance(getCitaRepository(),
                                getClienteRepository(),
                                getConn());
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                    | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (citAsigRepo == null) {
                citAsigRepo = new CitaAsignadaRepository(getCitaRepository(),
                        getClienteRepository(),
                        getConn());
            }
        }
        return citAsigRepo;
    }
    
    public IEntidadRepository getEntidadRepository () {
        if (entidadrepo == null) {
            try {
                entidadrepo = (IEntidadRepository) Class.forName(Utilities.loadProperty("EntidadRepository"))
                        .getConstructor(IConnectionRepository.class).newInstance(getConn());
            } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                    | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Factory.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (entidadrepo == null) {
                entidadrepo = new EntidadRepository(getConn());
            }
        }
        return entidadrepo;
    }
}
