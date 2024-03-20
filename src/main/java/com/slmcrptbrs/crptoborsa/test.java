package com.slmcrptbrs.crptoborsa;

import com.slmcrptbrs.crptoborsa.dao.UserDao;
import com.slmcrptbrs.crptoborsa.dao.UserDaoImpl;
import com.slmcrptbrs.crptoborsa.entity.User;

import java.util.List;

public class test {
    public static void main(String[] args) {
        UserDao d = new UserDaoImpl();
        if(d.isRegistered(new User("6", "5426"))){
            System.out.println("kayıt var");
        } else {
            System.out.println("kayıt yok");
        }
        /*List<User> ulist = d.getAllUsers();
        for(User u : ulist) {
            System.out.println(u.toString());

        }*/
    }
}
