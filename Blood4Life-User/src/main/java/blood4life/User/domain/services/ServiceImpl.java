/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blood4life.User.domain.services;

import java.util.List;


/**
 *
 * @author ASUS
 */
public interface ServiceImpl {
    public String create(Object elements);  
    public String update(Object elements); 
    public String delete(Object elements); 
    public Object find(Object elements);  
    public Object list(Object elements); 
    
}
