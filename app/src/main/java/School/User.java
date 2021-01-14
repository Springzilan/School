package School;

import java.io.Serializable;

//学生登录的用户名和学生id一样，密码默认和学号一样
public class User implements Serializable {
    private String username;
    private String password;
    public User(String username,String password){
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
