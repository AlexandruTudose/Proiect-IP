package com.fiivirtualcatalog.modules.DTOs;

/**
 * Created by ochile on 06-May-17.
 *
 * @author ochile
 */
public class AdminDto extends UserDTO {
    public AdminDto(){
        super();
    }
    public AdminDto(String name, String role){
        super(name, role);
    }
}
