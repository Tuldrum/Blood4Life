/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.domain.services;

import blood4life.User.access.FactoryImpl;
import blood4life.User.access.Users.IUserAccess;
import blood4life.commons.domain.User;

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
