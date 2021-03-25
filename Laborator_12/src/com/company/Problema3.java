package com.company;

import java.util.ArrayList;
import java.util.Objects;

public class Problema3 {
    public static void main(String args[]) {
        User u1 = new User("Andrei");
        User u2 = new User("Mihai");
        User u3 = new User("Ion");
        User u4 = new User("George");
        User u5 = new User("Valentin");

        Channel channel = new Channel(new ArrayList<>(), "EpicDrama");
        channel.subscribe(u1);
        channel.subscribe(u2);
        channel.subscribe(u3);
        channel.subscribe(u4);
        channel.subscribe(u5);
        channel.notify("ai primit un mesaj");

    }
}

class Channel {
    public ArrayList<User> users;
    public String name;

    public Channel(ArrayList<User> users, String name) {
        this.users = users;
        this.name = name;
    }

    public Channel() {
        this.users = new ArrayList<>();
        this. name = "";
    }

    public void subscribe(User user) {
        if(!users.contains(user))
            users.add(user);
    }

    public void unsubscriebe(User user) {
        users.remove(user);
    }

    public void notify(String notification) {
        for(User user : users)
            user.update(notification);
    }

 }

class User {
    String name;

    public User(String name) {
        this.name = name;
    }

    public User() {
        this("");
    }

    public void update(String notification) {
        System.out.println("User " + this.name + " " + notification);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
