package jhtaTEST01.sol1;

class User{
    private String id;
    private String pwd;
    private String email;
    public void setData(String id,String pwd,String email){
        this.id=id;
        this.pwd=pwd;
        this.email=email;
    }
    public String getId(){return id;}
    public String getPwd(){return pwd;}
    public String getEmail(){return email;}
}

public class UserTest {
    public static void main(String[] args) {
        User user = new User();
        user.setData("kiyelee","1234","kiyelee@naver.com");
        String id = user.getId();
        String pwd = user.getPwd();
        String email = user.getEmail();
        System.out.println("id : " + id + " pwd : " + pwd + " email : " + email);
    }
}
