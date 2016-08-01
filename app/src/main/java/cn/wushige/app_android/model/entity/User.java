package cn.wushige.app_android.model.entity;

/**
 * <p>
 * <p/>
 * </p>
 *
 * @author wushige
 * @date 2016-08-01 16:55
 */
public class User {

    private int id;
    private String username;
    private String password;
    private String gender;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
