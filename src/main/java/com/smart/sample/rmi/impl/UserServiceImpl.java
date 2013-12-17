package com.smart.sample.rmi.impl;

import com.smart.framework.DataSet;
import com.smart.framework.annotation.Service;
import com.smart.sample.entity.User;
import com.smart.sample.rmi.UserService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@Service
public class UserServiceImpl extends UnicastRemoteObject implements UserService {

    public UserServiceImpl() throws RemoteException {
    }

    @Override
    public User login(String username, String password) throws RemoteException {
        return DataSet.select(User.class, "username = ? and password = ?", username, password);
    }
}