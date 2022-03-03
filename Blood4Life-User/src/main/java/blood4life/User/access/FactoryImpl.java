/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.access;

import blood4life.User.access.Users.IClienteAcces;
import blood4life.User.access.Users.IUserAccess;
import blood4life.User.access.Users.UsuarioClienteImplSockets;
import blood4life.User.access.Users.UsuarioImplSockets;
import blood4life.commons.infra.Utilities;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class FactoryImpl {

    private static FactoryImpl instance;

    private FactoryImpl() {

    }

    public static FactoryImpl getInstance() {
        if (instance == null) {
            instance = new FactoryImpl();
        }
        return instance;
    }

    public IUserAccess getUsuarioAccess() {
        IUserAccess result = null;
        try {
            result = (IUserAccess) Class.forName(Utilities.loadProperty("UsuarioImplSockets"))
                    .getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(FactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == null) {
            result = new UsuarioImplSockets();
        }
        return result;
    }

    public IClienteAcces getCustomerAcces() {
        IClienteAcces result = null;
        try {
            result = (IClienteAcces) Class.forName(Utilities.loadProperty("UsuarioClienteImplSockets"))
                    .getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(FactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == null) {
            result = new UsuarioClienteImplSockets();
        }
        return result;
    }

    public ILugaresAcces getLugaresAcces() {
        ILugaresAcces result = null;
        try {
            result = (ILugaresAcces) Class.forName(Utilities.loadProperty("LugaresAccesImplSockets"))
                    .getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(FactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == null) {
            result = new LugaresAccesImplSockets();
        }
        return result;
    }

    public ICitaAcces getCitaAcces() {
        ICitaAcces result = null;
        try {
            result = (ICitaAcces) Class.forName(Utilities.loadProperty("CitaAccesImplSockets"))
                    .getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(FactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == null) {
            result = new CitaAccesImplSockets();
        }
        return result;
    }

    public ICitaAsignadaAcces getCitaAsignadaAcces() {
        ICitaAsignadaAcces result = null;
        try {
            result = (ICitaAsignadaAcces) Class.forName(Utilities.loadProperty("CitaAsignadaAccessImpSockets"))
                    .getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(FactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == null) {
            result = new CitaAsignadaAccessImpSockets();
        }
        return result;
    }
    
    public IEntidadAccess getEntidadAccess() {
        IEntidadAccess result = null;
        try {
            result = (IEntidadAccess) Class.forName(Utilities.loadProperty("EntidadImplSockets"))
                    .getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(FactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == null) {
            result = new EntidadImplSockets();
        }
        return result;
    }
    
    public IAssignmentsAccess getAssignmentsAccess() {
        IAssignmentsAccess result = null;
        try {
            result = (IAssignmentsAccess) Class.forName(Utilities.loadProperty("AssignmentsImplSockets"))
                    .getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
                | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(FactoryImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (result == null) {
            result = new AssignmentsImplSockets();
        }
        return result;
    }

}
