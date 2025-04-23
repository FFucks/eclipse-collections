package com.ffucks;

import org.eclipse.collections.api.LazyIterable;
import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.list.primitive.MutableIntList;
import org.eclipse.collections.api.multimap.list.MutableListMultimap;
import org.eclipse.collections.impl.list.mutable.primitive.IntArrayList;

public class Test {

    public static void main(String[] args) {

        creatingCollections();
        //filterMapCollections();
        //groupByCollections();

    }

    public static void creatingCollections() {
        MutableList<String> fruits = Lists.mutable.with("Apple", "Banana", "Orange");
        System.out.println(fruits);
    }

    public static void filterMapCollections() {
        MutableList<String> names = Lists.mutable.with("John", "Jane", "Jack", "Jill");

        // Filter names starting with "J"
        MutableList<String> filtered = names.select(name -> name.startsWith("J"));

        // Transform to uppercase
        MutableList<String> uppercased = filtered.collect(String::toUpperCase);
        System.out.println(uppercased);
    }

    public static void groupByCollections() {
        var words = Lists.mutable.with("apple", "banana", "cherry", "avocado", "blueberry");

        MutableListMultimap<Character, String> groupedByFirstLetter =
                words.groupBy(word -> word.charAt(0));

        System.out.println(groupedByFirstLetter);
    }

    public static void primitiveCollections() {
        MutableIntList numbers = new IntArrayList();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Sum of elements
        int sum = Math.toIntExact(numbers.sum());
        System.out.println("Sum: " + sum);
    }

    public static void eagerLazyEvaluationsCollections() {
        MutableList<Integer> numbers = Lists.mutable.with(1, 2, 3, 4, 5, 6);

        // Eager
        MutableList<Integer> evens = numbers.select(n -> n % 2 == 0);
        System.out.println("Eager: " + evens);

        // Lazy
        LazyIterable<Integer> lazyEvens = numbers.asLazy().select(n -> n % 2 == 0);
        System.out.println("Lazy: " + lazyEvens.toList());
    }
}
