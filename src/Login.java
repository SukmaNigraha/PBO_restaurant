public class Login {
    private String username_admin,password_admin,

                   username_user,password_user;
    public Login(){
        username_admin = "sugma";
        password_admin = "haimanis";

        username_user = "sigma";
        password_user = "haimanis";
    }
    //setter

    public void setUsername_admin(String username_admin) {
        this.username_admin = username_admin;}

    public void setPassword_admin(String password_admin) {
        this.password_admin = password_admin;}

    public void setUsername_user(String username_user) {
        this.username_user = username_user;}

    public void setPassword_user(String password_user) {
        this.password_user = password_user;}
    //getter

    public String getUsername_admin() {
        return username_admin;}

    public String getPassword_admin() {
        return password_admin;}

    public String getUsername_user() {
        return username_user;}

    public String getPassword_user() {
        return password_user;}
}
