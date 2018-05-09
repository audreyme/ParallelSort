//Audrey Meadows
import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.lang.Math;
class Sorter
{
  public static void main(String [] args)
  {
    //make an array to be sorted
    int min = 11;
    int max = -1;
    int range;
    int [] array = new int[100];

    Random rand = new Random();


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

    Threadly t1 = new Threadly(0, 49, array, range, min, max);
    Threadly t2 = new Threadly(50, 99, array, range, min, max);
    //start threads
    //join threads
    //merge thread data
    //print array data
  }

}

class Threadly extends Thread
{
  int startIndex;
  int endIndex;
  int array[];
  int range;
  int min;
  int max;
  Threadly(int startIndex, int endIndex, int [] array, int range, int min, int max)
  {
    this.startIndex = startIndex;
    this.endIndex = endIndex;
    this.array = array;
    this.range = range;
    this.min = min;
    this.max = max;
  }//constructor

  public void run()
  {
    //make an array with the length of the range
      int [] counterArray = new int[range];
      int [] newArray = new int[array.length];
      int tracker = 0;
    //go through data array and counter sort the dooblie doo where index 0 represents min, 1 represents min + 1, all the way to n being max
      for(int j = 0; j < array.length; j++)
      {
        int value = array[j];
        counterArray[value - min] = counterArray[value - min]++;
        System.out.println(counterArray[value - min]);
      }
    //go through counterArray, and fill in the number of values in newArray
      for(int k = 0; k < counterArray.length; k++)
      {
        int valueNum = counterArray[k];
        for(int m = tracker; m < tracker+valueNum; m++)
        {
          //using the offset, fill valueNum number of instances of (k + min) in newArray
        }

      }
  }//run
}