package com.fiivirtualcatalog.login.services;


import com.fiivirtualcatalog.login.models.ConfirmEmail;
import com.fiivirtualcatalog.login.repositories.ConfirmEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class ConfirmEmailServiceImpl implements ConfirmEmailService {

    @Autowired
    ConfirmEmailRepository confirmEmailRepository;

    @Override
    public ConfirmEmail findEmail(String email) {

        return confirmEmailRepository.findByEmail(email);
    }
    @Override
    public ConfirmEmail save(ConfirmEmail entity)
    {
        return confirmEmailRepository.save(entity);
    }

    @Override
    public void delete(String email) {
        confirmEmailRepository.deleteByEmail(email);
    }

    @Override
    public String generateCode(){
        StringBuilder code=new StringBuilder();
        Random r = new Random();
        int low = 0;
        int high;
        int indx;
        String chars="abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWZYZ";
        high=chars.length();
        for(int i=0;i<12;i++){
            indx = r.nextInt(high-low) + low;
            code.append(chars.charAt(indx));
        }
        return code.toString();
    }
}