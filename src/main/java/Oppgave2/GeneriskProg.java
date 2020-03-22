package Oppgave2;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;

public class GeneriskProg {

    // Oppgave 2.1
    static <T> void printArray(T[]array){
        for(T t : array){
            System.out.print(t + " ");
        }
        System.out.println();
    }

    // Oppgave 2.2
    static <T> void reverseArray(T[]array) {
        Collections.reverse(Arrays.asList(array));
    }

    public static void main(String[] args) {
        Integer[] intsz = {11,22,3,44,55};
        String[] words = {"Hei", "på", "deg"};

        printArray(intsz);
        reverseArray(intsz);
        printArray(intsz);
        printArray(words);
        reverseArray(words);
        printArray(words);

        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(5);
        arrayList.add(8);
        arrayList.add(13);
        arrayList.add(21);
        arrayList.add(34);
        arrayList.add(55);
        arrayList.add(88);
        System.out.println("Lengden til listen er: " + arrayList.size());
        System.out.print(arrayList);
        System.out.println();
        System.out.println("Indeksen du lette etter gir elementet: " + arrayList.get(3));
    }
}

// Oppgave 2.3
class MyArrayList<E> extends AbstractList<E> {
    private static java.lang.Object[] elements;

    public MyArrayList() {
        elements = new Object[10];
    }

    @Override
    public int size() {
        Object[] copy = elements.clone();
        return copy.length;
    }

    public boolean add(E element){
        for(int i = 0; i < elements.length; i++){
            if(elements[i] == null){
                elements[i] = element;
                return true;
            }
        }
        return false;
    }

    public E get(int index) {
        return (E) elements[index];
    }
}
