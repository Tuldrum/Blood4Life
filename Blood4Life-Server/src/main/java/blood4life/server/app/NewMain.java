/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.server.app;

import blood4life.commons.domain.LugarRecogida;
import blood4life.server.domain.services.ServiceModel;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiceModel service = new ServiceModel();  
        List<LugarRecogida> lis = service.listLugaresDisp(Date.valueOf("2022-02-05"),Date.valueOf("2022-02-17"));  
        lis.clear();
    }
    
}
