package com.dmdev.oop.lesson15;

public class TrainingGround {

    public static void main(String[] args) {
        Warrior warrior = new Warrior("Боромир", 15);
        Mage mage = new Mage("Гэндальф", 20);
        Archer archer = new Archer("Леголас", 10);

        Enemy enemy = new Enemy("Зомби", 100);

        attackEnemy(enemy, warrior, mage, archer);
    }

    public static void attackEnemy(Enemy enemy, Hero... heroes) {
        while (enemy.isAlive()) {
            for (Hero hero : heroes) {
                if (enemy.isAlive()) {
                    hero.attackEnemy(enemy);
                }
            }
        }
    }
}
