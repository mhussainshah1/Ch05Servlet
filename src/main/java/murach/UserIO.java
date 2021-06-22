package murach;

import murach.business.User;

import java.io.*;

public class UserIO {
    public static void add(User user, String path) throws IOException {
        try (var fis = new FileOutputStream(path);
             var bis = new BufferedOutputStream(fis);
             var ois = new ObjectOutputStream(bis)) {
                ois.writeObject("Hello");
        }
        throw new IOException();
    }
}
