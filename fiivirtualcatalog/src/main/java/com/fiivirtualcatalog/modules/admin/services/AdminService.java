package com.fiivirtualcatalog.modules.admin.services;

import com.fiivirtualcatalog.modules.admin.models.Admin;
import com.fiivirtualcatalog.modules.user.models.User;
import com.fiivirtualcatalog.modules.user.services.UserService;
import com.fiivirtualcatalog.services.CrudService;

import java.util.List;

public interface AdminService extends CrudService<User> {
    List<Admin> getAllAdmins();
    List<Admin> getAllByName(String name);
}
