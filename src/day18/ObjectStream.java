package day18;

import homework.day11.User;

import java.io.*;
import java.util.ArrayList;

public class ObjectStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, 22, "wm"));
        users.add(new User(2, 23, "wy"));
        writeSeq(users);
        readSeq();
    }

    public static void readSeq() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream("src/day18/object.txt"));
        Object o = ois.readObject();
        if (o instanceof ArrayList) {
            ArrayList<User> users = (ArrayList<User>) o;
            users.forEach(System.out::println);
        }
        ois.close();
    }

    public static void writeSeq(ArrayList<User> users) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(
            new FileOutputStream("src/day18/object.txt")
        );
        oos.writeObject(users);
        oos.close();
    }
}
