package designPatterns;

interface IUser {
    public void print();
}

public class AvoidingInheritance {
    public static void main(String[] args) {
        User a = new User("Kim", "Seoul");
        VIP b = new VIP("Lee", "Busan", "123");

        printUser(a);
        printUser(b);
    }

    static void printUser(IUser u) {
        u.print();
    }
}

class User implements IUser {
    private String name;
    private String address;

    public User(String n, String ad) {
        name = n;
        address = ad;
    }

    public void print() {
        System.out.println(name);
        System.out.println(address);
    }
}

/*
 * class VIP extends User {
 * 
 * private String account;
 * 
 * public VIP(String n, String ad, String ac) {
 * super(n, ad);
 * account = ac;
 * }
 * 
 * public void print() {
 * super.print();
 * System.out.println(account);
 * }
 * }
 */

class VIP implements IUser {

    private User user; // "is a" -> "has a"
    private String account;

    public VIP(String n, String ad, String ac) {
        user = new User(n, ad);
        account = ac;
    }

    public void print() {
        user.print();
        System.out.println(account);
    }
}