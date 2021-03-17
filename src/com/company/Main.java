package com.company;

public class Main {
    public static void main(final String[] args) {
        Box<Object> boxWithObj = new Box<>();
        Box<Apple> boxOfApples = new Box<>();
        Box<Fruit> boxOfFruits = new Box<>();
        Box<Box<?>> box = new Box<>();
        Box<Box<Box<?>>> box2 = new Box<>();
        boxOfApples.put(new Apple(false));

        // Копируем содержимое и выводим
        BoxUtil.copyFromBoxToBox(boxOfApples, boxOfFruits);
        System.out.println(boxOfFruits.get());

        boxOfApples.put(new Apple(true));

        // Копируем свежие и выводим
        BoxUtil.copyFreshFruitFromBoxToBox(boxOfApples, boxOfFruits);
        System.out.println(boxOfFruits.get());

        // Печатаем содержимое второй коробки
        BoxUtil.printElementFromTwoBoxes(box);
        box.put(boxOfApples);
        BoxUtil.printElementFromTwoBoxes(box);

        box2.put(box);

        // Печатаем содержимое последней вложенной коробки
        Box<?>[] boxArr = new Box[]{boxWithObj, boxOfFruits, boxOfApples, box, box2};
        for (Box<?> b : boxArr) {
            BoxUtil.printElementFromBoxes(b);
        }
    }
}