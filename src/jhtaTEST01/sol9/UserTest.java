package jhtaTEST01.sol9;

import java.util.ArrayList;

public class UserTest extends User {
    private UserTest(String id, String pwd, String email) {
        super(id, pwd, email);
    }
    public static void main(String[] args) {
        ArrayList<String> userList = new ArrayList<>();
        User user = new User("Kiyelee","1234","kiyelee@naver.com");
        userList.add(user.getId());
        userList.add(user.getPwd());
        userList.add(user.getEmail());
        System.out.println(userList);
    }

}
