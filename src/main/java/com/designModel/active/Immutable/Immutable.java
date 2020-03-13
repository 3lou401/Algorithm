package com.designModel.active.Immutable;

/**
 * @Author: leaderHoo
 * @Date: 2020/2/29 21:23
 * @Desc:
 */
public class Immutable {

}

class WeakyImmutable {
    private String state;
    private ReferClass referClass = new ReferClass("zhangsan", 12);

    public WeakyImmutable(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }
}

class ReferClass {
    String name;
    int age;

    public ReferClass(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

final class StrongImmutable {
    private String state = "bad";
}