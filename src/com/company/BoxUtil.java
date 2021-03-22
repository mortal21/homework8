package com.company;

public class BoxUtil {
    public static <T> void copyFromBoxToBox(final Box<T> src, final Box<? super T> dest) {
        if (src.get() != null) {
            dest.put(src.get());
        }
    }

    public static <T extends Fruit> void copyFreshFruitFromBoxToBox(final Box<T> src, final Box<? super T> dest) {
        if (src.get() != null && src.get().isFresh()) {
            dest.put(src.get());
        }
    }

    public static void printElementFromTwoBoxes(final Box<Box<?>> box) {
        try {
            System.out.println(box.get().get().toString());
        } catch (NullPointerException e) {
            System.out.println("В коробке лежит null");
        }
    }

    public static void printElementFromBoxes(final Box<?> box) {
        /*
        Проверяем, лежит ли в коробке другая коробка.
        До тех пор, пока не встретим коробку с чем-то другим (Object, Fruit или Apple)
        Если в коробке ничего нет - null
         */
        try {
            if (box.get().getClass().equals(Box.class)) {
                printElementFromBoxes((Box<?>) box.get());
            } else {
                System.out.println(box.get().toString());
            }
        } catch (NullPointerException e) {
            System.out.println("В коробке лежит null");
        }
    }
}