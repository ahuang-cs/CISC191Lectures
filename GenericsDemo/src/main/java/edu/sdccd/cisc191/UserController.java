package edu.sdccd.cisc191;

import java.util.HashSet;
import java.util.Set;

public class UserController<T extends User> {
    private Set<T> users;

    public UserController() {
        users = new HashSet<>();
    }

    public void addUser(T user) throws Exception {
        if(!users.add(user)) throw new Exception("Failed to add user " + user.getId());
    }

    public void removeUser(T user) throws Exception {
        if(!users.remove(user)) throw new Exception("Failed to remove user " + user.getId());
    }

    public T authenticate(long id, String name) throws Exception {
        for(T user: users) {
            if(id == user.getId() && name.equals(user.getName())) return user;
        }
        throw new Exception("Invalid user");
    }
}
