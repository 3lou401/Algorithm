package com.JVM.classloading.myclassloader;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/22
 * Time: 22:12
 * Description: 自定义了一个类加载器
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String fileName = name.substring(name.lastIndexOf(".")+1)+".class";
                try(InputStream is =getClass().getResourceAsStream(fileName)) {
                    if (is ==null)
                        return super.loadClass(name);
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name,b,0,b.length);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return super.loadClass(name);
            }
        };

        String name ="com.JVM.classloading.myclassloader.ClassLoaderTest";
        Object c1 = classLoader.loadClass(name).newInstance();
        System.out.println(c1.getClass());
        System.out.println(c1 instanceof com.JVM.classloading.myclassloader.ClassLoaderTest);

    }
}
