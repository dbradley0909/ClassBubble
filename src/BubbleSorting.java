import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
//import java.util.*;
public class BubbleSorting {

    public static void printArray(int[] array){
        for(int a : array){
            System.out.println(a + " ");
        }
        System.out.println();

}

public static int[] createRandomArray(int arrayLength){
    int[] array = new int[arrayLength];
    Random random = new Random();
    for(int i= 0; i< arrayLength; i ++){
    array[i] = random.nextInt(100);
}
return array;
}
public static void writeArrayToFile(int[] array, String fileName) throws Exception {
    try {
    FileWriter fileWriter = new FileWriter(fileName);
    for (int a: array) {
    fileWriter.write(a + "\n");
     }
    fileWriter.close();
    } catch(IOException e) {
    System.out.println("Encounter and IOEception");
    e.printStackTrace();
    }
}

public static int[] readArrayFromFile(String fileName) {
File file = new File(fileName);
try{
Scanner scanner = new Scanner(file);
ArrayList <Integer> arrayList = new ArrayList<>();
while (scanner.hasNextLine()){
    String str = scanner.nextLine();
    int a = Integer.parseInt(str);
    arrayList.add(a);
}
int [] array = new int[arrayList.size()];
for( int i =0; i < arrayList.size(); i++) {
    array[i] = arrayList.get(i);
}
scanner.close();
return array;
} catch(FileNotFoundException e){
    e.printStackTrace();
}
return null;
}

public static void bubbleSort(int[] array){
    for(int i= array.length -1; i >0; i--){
        for(int j= 0; j < i; j++){
            if (array[j] > array[j + 1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
                
        }
        }
        printArray(array);
    }

}
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input filename");
        String fileName = scanner.next();
        // static would be used for other methods because it was what your main folder has methods wont work if dont use static
       // int arrayLength = 5;
        //int [] array = createRandomArray(arrayLength);
        //String fileName = "intergers.txt";
        //printArray(array);
        //make sure to method call the fuction or code wont work
       // writeArrayToFile(array, fileName);
        int[] array = readArrayFromFile(fileName);
        
        writeArrayToFile(array, "sorted.txt");
        bubbleSort(array);
        printArray(array);
        scanner.close();
    }
}
