  
import java.util.ArrayList;

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
    private ArrayList<Pokemon> pokedex = new ArrayList();

    public User() {
    }

    public User(int age, String Name, String user, String password) {
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

    public ArrayList<Pokemon> getPokedex() {
        return pokedex;
    }

    public void setPokedex(ArrayList<Pokemon> pokedex) {
        this.pokedex = pokedex;
    }

    @Override
    public String toString() {
        return "User{" + "age=" + age + ", Name=" + Name + ", user=" + user + ", password=" + password + ", pokedex=" + pokedex + '}';
    }
    
    
}
