package Lesson10.HomeStar;


public class Clone {

    public static User clone(int id, String method, User[] object) throws CloneNotSupportedException {
        User clonedUsers;

        if ("deep".equals(method)) {
            clonedUsers = (User) object[id - 1].clone();
            UserOS clonedUsersOS;
            clonedUsersOS = (UserOS) clonedUsers.userOS.clone();
            clonedUsers.userOS = clonedUsersOS;
            return clonedUsers;
        } else if ("surface".equals(method)) {
            clonedUsers = (User) object[id - 1].clone();
            return clonedUsers;
        } else {
            System.out.println("Error");
            System.exit(1);
            return null;
        }
    }
}