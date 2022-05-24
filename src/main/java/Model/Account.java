/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Admins
 */
public class Account {
    String name;
    int ConnectWith;

    public Account(String name) {
        this.name = name;
        ConnectWith=-1;
    }

    public Account(String name, int ConnectWith) {
        this.name = name;
        this.ConnectWith = ConnectWith;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConnectWith() {
        return ConnectWith;
    }

    public void setConnectWith(int ConnectWith) {
        this.ConnectWith = ConnectWith;
    }

    @Override
    public String toString() {
        return "Account{" + "name=" + name + ", ConnectWith=" + ConnectWith + '}';
    }
    
    
}
