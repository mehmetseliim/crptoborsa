package com.slmcrptbrs.crptoborsa.dao;

import com.slmcrptbrs.crptoborsa.entity.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    public boolean addUser(User user);
    public boolean deleteUser(User user);
    public boolean isRegistered(User user);

}
