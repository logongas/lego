package es.logongas.lego;

import java.lang.reflect.*;
import java.io.*;
import java.net.*;

public class ClassPathHacker {

    private static final Class[] parameters = new Class[]{URL.class};

    public static void addFile(String s) {
        File f = new File(s);
        addFile(f);
    }

    /* File.toURL() was deprecated, so use File.toURI().toURL() */
    public static void addFile(File f) {
        try {
            addURL(f.toURI().toURL());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addURL(URL url) {
        URLClassLoader sysloader = (URLClassLoader) ClassLoader.getSystemClassLoader();
        try {
            Method method = URLClassLoader.class.getDeclaredMethod("addURL", parameters);
            method.setAccessible(true);
            method.invoke(sysloader, new Object[]{url});
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

