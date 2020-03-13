package com.thinkingInJava.reflect;

/**
 * Created with IntelliJ IDEA.
 * User: leaderHoo
 * Date: 2020/3/12
 * Time: 15:09
 * Description: No Description
 */
public class Demo {
}
class NewInstance{
    public static Object instance(ClassLoader classLoader ,String className) throws BaseException {

        try {
            Class instance = classLoader.loadClass(className);
            return  instance.newInstance();
        } catch (ClassNotFoundException e) {
            throw  new BaseException("classNotfound",e);
        } catch (IllegalAccessException e) {
            throw  new BaseException("IllegalAccess",e);
        } catch (InstantiationException e) {
            throw  new BaseException("Instantiation",e);
        }

    }
}
class BaseException extends Throwable {
    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }
}