package jhtaTEST01.sol9;

import java.util.ArrayList;
class User{
    private String id;
    private String pwd;
    private String email;
    public User(String id,String pwd,String email){
        this.id=id;
        this.pwd=pwd;
        this.email=email;
    }
    public String getId(){return id;}
    public String getPwd(){return pwd;}
    public String getEmail(){return email;}
    public static void main(String[] args) {
        User user = new User("kiyelee","1234","kiyelee@naver.com");
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(user.id);
        arrayList.add(user.pwd);
        arrayList.add(user.email);
        System.out.println(arrayList);
    }

}
