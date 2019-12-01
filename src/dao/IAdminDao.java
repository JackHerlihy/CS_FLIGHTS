package dao;

import model.Admin;

import java.util.List;


public interface IAdminDao {
    List<Admin> getAdmins();
    Boolean validateAdmin(Admin adminUser);
    boolean addAdmin(Admin newAdmin);

    //public Boolean validateAdmin(Admin admin);
}
