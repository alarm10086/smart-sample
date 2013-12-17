package com.smart.plugin;

import com.smart.framework.Plugin;
import com.smart.framework.helper.BeanHelper;
import com.smart.sample.rmi.UserService;
import com.smart.sample.rmi.impl.UserServiceImpl;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class RMIPlugin implements Plugin {

    @Override
    public void init() {
        try {
            UserService userService = BeanHelper.getBean(UserServiceImpl.class);
            LocateRegistry.createRegistry(8888);
            Naming.bind("rmi://localhost:8888/UserService", userService);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        try {
            System.out.println("RMIPlugin destroy");
            Naming.unbind("rmi://localhost:8888/UserService");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}