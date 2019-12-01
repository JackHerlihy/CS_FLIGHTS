package dao;

import model.User;

import java.util.List;
import model.Admin;

public interface IUserDao {
    List<User> getUsers();
    Boolean validateUser(User loginUser);
    boolean addUser(User newUser);

    //public Boolean validateAdmin(Admin admin);
}
