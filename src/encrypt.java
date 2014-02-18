
class encrypt {

    private String password;
    private String username;

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserName(String UserName) {
        this.username = UserName;
    }

    public String getDbPassword() {
        return password;
    }

    public String getDbUserName() {
        return username;
    }
}
