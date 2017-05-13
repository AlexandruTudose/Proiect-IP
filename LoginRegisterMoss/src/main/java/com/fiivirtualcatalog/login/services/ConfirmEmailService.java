package com.fiivirtualcatalog.login.services;


import com.fiivirtualcatalog.login.models.ConfirmEmail;
import org.springframework.stereotype.Service;

@Service
public interface ConfirmEmailService{

    public ConfirmEmail findEmail(String email);
    public ConfirmEmail save(ConfirmEmail entity);
    public void delete(String email);
    public String generateCode();

}
