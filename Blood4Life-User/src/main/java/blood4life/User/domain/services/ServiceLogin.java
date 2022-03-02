/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.domain.services;

import blood4life.User.access.FactoryImpl;
import blood4life.User.access.ICitaAcces;
import blood4life.User.access.ICitaAsignadaAcces;
import blood4life.User.access.ILugaresAcces;
import blood4life.User.access.Users.IClienteAcces;
import blood4life.User.access.Users.IUserAccess;
import blood4life.commons.domain.Cita;
import blood4life.commons.domain.CitaAsignada;
import blood4life.commons.domain.LugarRecogida;
import blood4life.commons.domain.User;
import blood4life.commons.domain.UsuarioCliente;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class ServiceLogin {

    private FactoryImpl instance;
    private IUserAccess usuarios;

    public ServiceLogin() {
        instance = FactoryImpl.getInstance();
        usuarios = instance.getUsuarioAccess();
    }

    public User logear(String id, String pw) throws Exception {
        return usuarios.logInUser(id, pw);
    }
}
