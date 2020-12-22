package com.star;

/**
 * Created by lichunxia on 2020-04-14 17:41
 */
public class B extends A {

    @Override
    public B aa(A m) {
        return (B) m;
    }

    public static void main(String[] args) {

        A c = new C();
        try {
            c.aa(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ((B)c).aa(null);
        ((C)c).aa(null);

        ((I)c).m();
    }
}
