package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;

/**
 * @Author: leaderHoo
 * @Date: 2020/3/10 17:51
 * @Desc:
 */
public class Test2 extends FileInputStream implements Runnable,Serializable,Cloneable {
    public Test2(String name) throws FileNotFoundException {
        super(name);
    }

    @Override
    public void run() {

    }
}
