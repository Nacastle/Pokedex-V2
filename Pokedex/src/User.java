  
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alexis
 */
public class User {
    private int age;
    private String Name;
    private String user;
    private String password;
    TDA_Archivo pokedex;

    public User() {
    }

    public User(int age, String Name, String user, String password) {
        File x = new File("./"+user+"/"+user+"_poke.txt");
        File y = new File("./"+user+"/"+user+"_pokeb.txt");
        try {
            x.createNewFile();
            y.createNewFile();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Algo Exploto");
        }
        this.pokedex = new TDA_Archivo(x,y);
        this.age = age;
        this.Name = Name;
        this.user = user;
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TDA_Archivo getPokedex() {
        return pokedex;
    }

    public void setPokedex(TDA_Archivo pokedex) {
        this.pokedex = pokedex;
    }

    @Override
    public String toString() {
        return "User{" + "age=" + age + ", Name=" + Name + ", user=" + user + ", password=" + password + ", pokedex=" + pokedex + '}';
    }
    
    
}
