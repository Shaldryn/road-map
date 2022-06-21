package com.dmdev.collections.lesson20.task;

import java.util.HashSet;
import java.util.Map;

/**
 * 3. Написать метод isUnique, который принимает Map&lt;String, String&gt;
 * и возвращает true,
 * если каждому ключу соответствуют свое уникальное значение.
 * Например, в данном случае вернётся true:
 * {Marty=Stepp, Stuart=Reges, Jessica=Miller, Amanda=Camp,
 * Hal=Perkins}
 * А в данном false:
 * {Kendrick=Perkins, Stuart=Reges, Jessica=Miller, Bruce=Reges,
 * Hal=Perkins}
 */
public class Task3 {

    public static void main(String[] args) {
//        Map<String, String> map = new HashMap<>();
//        map.put("Marty", "Stepp");
//        map.put("Stuart", "Reges");
//        map.put("Jessica", "Miller");
//        map.put("Amanda", "Camp");
//        map.put("Hal", "Perkins");
        Map<String, String> mapUnique = Map.of(
                "Marty", "Stepp",
                "Stuart", "Reges",
                "Jessica", "Miller",
                "Amanda", "Camp",
                "Hal", "Perkins"
        );
        System.out.println(isUnique(mapUnique));
        Map<String, String> mapNotUnique = Map.of(
                "Kendrick", "Perkins",
                "Stuart", "Reges",
                "Jessica", "Miller",
                "Bruce", "Reges",
                "Hal", "Perkins"
        );
        System.out.println(isUnique(mapNotUnique));
    }

    private static boolean isUnique(Map<String, String> map) {
        return map.size() == new HashSet<>(map.values()).size();
    }
}
