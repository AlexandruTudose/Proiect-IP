package com.fiivirtualcatalog.modules.transformers;

import com.fiivirtualcatalog.modules.DTOs.AdminDto;
import com.fiivirtualcatalog.modules.admin.models.Admin;
import org.springframework.stereotype.Component;

/**
 * Created by ochile on 06-May-17.
 *
 * @author ochile
 */
@Component
public class AdminTransformer implements Transformer<Admin, AdminDto>{
    @Override
    public Admin toModel(AdminDto object) {
        Admin user = new Admin();
        user.setName(object.getName());
        user.setRole(object.getRole());
        return user;
    }

    @Override
    public AdminDto toDTO(Admin object) {
        return (new AdminDto(object.getName(), object.getRole()));
    }
}
