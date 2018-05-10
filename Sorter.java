//Audrey Meadows
import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.lang.Math;

//Filling the newArray


class Sorter
{
  public static void main(String [] args)
  {
    //make an array to be sorted
    int tracker = 0;
    int min = 11;
    int max = -1;
    int range;
    int [] array = new int[100];
    int [] newArray = new int[100];
    int [] counterArray1 = new int[50];
    int [] counterArray2 = new int[50];

    Random rand = new Random();

    System.out.println("The unsorted array");
    for(int i = 0; i < 100; i++)
    {
      array[i] = rand.nextInt(10) + 1;
      System.out.print(array[i] + " ");

      if(array[i] > max)
      {
        max = array[i];
      }
      if(array[i] < min)
      {
        min = array[i];
      }
    }
    range = max - min;
    //create threads

    Threadly t1 = new Threadly(0, 49, array, range, min, max, counterArray1);
    Threadly t2 = new Threadly(50, 99, array, range, min, max, counterArray2);
    //start threads

    t1.start();
    t2.start();
    //join threads
    try
    {
      t1.join();
      t2.join();
    } catch(Exception e)
    {
      System.out.println("join(s) has/have failed");
    }

  //merge thread data
    //get number of values for each index from counter1 & counter2
    for(int index = 0; index < counterArray1.length; index++)
    {
      int instances = counterArray1[index] + counterArray2[index];
      tracker = tracker + instances;
      for(int p = tracker - instances; p < tracker; p++)
      {
        newArray[p] = index + 1;
        System.out.println(newArray[p]);
      }
    }
  }

}

class Threadly extends Thread
{
  int startIndex;
  int endIndex;
  int array[];
  int counterArray[];
  int range;
  int min;
  int max;

  Threadly(int startIndex, int endIndex, int [] array, int range, int min, int max, int [] counterArray)
  {
    this.startIndex = startIndex;
    this.endIndex = endIndex;
    this.array = array;
    this.range = range;
    this.min = min;
    this.max = max;
    this.counterArray = counterArray;

  }//constructor

  public void run()
  {
    //make an array with the length of the range

      int [] newArray = new int[array.length];//    MOVE TO THE MAIN
      int tracker = 0;
      int offset;
    //go through data array and counter sort the dooblie doo where index 0 represents min, 1 represents min + 1, all the way to n being max
      for(int j = startIndex; j < endIndex; j++)
      {
        int value = array[j];
        //System.out.println("value: " + value + "   min: " + min); Works just fine

        counterArray[value - min ] = counterArray[value - min] + 1;
        System.out.println("index: "+ (value - min) +"   data value :" +counterArray[value - min]);
      }

  }//run

}
