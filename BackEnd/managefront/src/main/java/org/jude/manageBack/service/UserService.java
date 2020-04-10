package org.jude.manageBack.service;

import org.jude.manageBack.pojo.Users;

import java.util.List;

public interface UserService {
    public List<Users> findAllUsers() throws Exception;

    public void updateUser(Users user) throws Exception;

    public void addUser(Users user) throws Exception;

    public void deleteUser(Integer userid) throws Exception;
}
