package com.caidapao.pattern.singleton.destoryer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Time 2020/7/24 21:31
 * address https://today.caidapao.com
 *
 * @author caidapao
 */
public class SerialDestroyerTest {

    public static void main(String[] args) {

        SerialDestroyer s1;
        SerialDestroyer s2 = SerialDestroyer.getInstance();

        try {
            FileOutputStream fos = new FileOutputStream("SerialDestroyer.java");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(s2);

            FileInputStream fis = new FileInputStream("SerialDestroyer.java");
            ObjectInputStream ois = new ObjectInputStream(fis);
            s1 = (SerialDestroyer) ois.readObject();
            System.out.println(s1 == s2);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
