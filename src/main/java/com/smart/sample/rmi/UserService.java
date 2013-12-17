package com.smart.sample.rmi;

import com.smart.sample.entity.User;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UserService extends Remote {

    User login(String username, String password) throws RemoteException;
}