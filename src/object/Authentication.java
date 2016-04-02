/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package object;

/**
 * Release R2
 * @author hubanato
 */
public class Authentication {

    private String login;
    private String password;

    public Authentication(String login, String password) {
        this.login = login;
        this.password = password;
    }

    /**
     * This method is used to log into the application
     */
    public void Connect() {
    }

    ;
    
    /**
     * This method is used to log out the application
     */
    public void Disconnect() {
    }
;
}
