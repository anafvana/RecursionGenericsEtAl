package Oppgave1;

public class Rekursjon {

    // Oppgave 1.1 på to måter
    static int getsum(int n) {
        return n == 0 ? 0 : n + getsum(n-1);
    }

    static int summation(int x){
        if(x >= 0) {
            return x + summation(x - 1);
        }
        return 0;
    }

    // Oppgave 1.2
    static int power(int base, int exponent){
        if(exponent == 0) {
            return 1;
        }
        return (base * power(base, exponent-1));
    }

    // Oppgave 1.3
    static void reverseList(int[] list, int length, int position){
        if(length == 5){
            System.out.print(list[position]);
            return;
        }
        System.out.print(list[position] + " ");
        reverseList(list, length+1, position-1);
    }

    // Oppgave 1.4
    static int findLowest(int[] list, int length){
        if(length == 1) {
            return list[0];
        }
        int lowestExceptLast = findLowest(list, length-1);
        if(list[length-1] < lowestExceptLast){
            return list[length-1];
        }
        return lowestExceptLast;
    }

    // Oppgave 1.5
    static int searchList(int[] list, int length, int position, int searchNum){
        if (length == 1 && searchNum != list[position]) {
            return -1;
        }
        if (list[position] == searchNum){
            return position;
        }
        return searchList(list, length-1, position+1, searchNum);
    }

    public static void main(String[] args) {
        int[] ints = {11,22,3,44,55};

        System.out.println(getsum(20));
        System.out.println(summation(20));
        System.out.println(power(6, 3));
        reverseList(ints, 1, 4);
        System.out.println();
        System.out.println("The lowest number in the array is: " + findLowest(ints, 5));
        System.out.println("The index of the number you searched for is: " + searchList(ints, 5, 0, 22));
    }
}
