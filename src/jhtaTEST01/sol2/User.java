package jhtaTEST01.sol2;

class User{
    private String id;
    private String pwd;
    private String email;

    public User() {

    }

    public void setData(String id, String pwd, String email){
        this.id=id;
        this.pwd=pwd;
        this.email=email;
    }
    public String getId(){return id;}
    public String getPwd(){return pwd;}
    public String getEmail(){return email;}
}