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
    int min = 11;
    int max = -1;
    int range;
    int [] array = new int[100];

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

    Threadly t1 = new Threadly(0, 49, array, range, min, max);
    Threadly t2 = new Threadly(50, 99, array, range, min, max);
    //start threads

    t1.start();
    t2.start();
    //join threads
//    t1.join();
//    t2.join();

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
      int [] counterArray = new int[range + 1];
      int [] newArray = new int[array.length];
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
    //go through counterArray, and fill in the number of values in newArray
      for(int k = 0; k < counterArray.length; k++)
      {
        int valueNum = counterArray[k];
        tracker = tracker + valueNum;

        for(int m = tracker - valueNum; m < tracker; m++)
        {
    //using the offset, fill valueNum number of instances of (k + min) in newArray, using tracker offset to index
          newArray[m] = k + min;
          System.out.println(newArray[m]);
        }
      }

  }//run

}
//working under the assumption that the two counter arrays are being passed into the method
merge(int[] counter1, int [] counter2)
{
  int[] sortedArray = new int[counter1.length + counter2.length];
  //get number of values for each index from counter1 & counter2
  for(int index = 0; index < counter1.length; index++)
  {
    int total = counter1[index] + counter2[index];
    int track = track + total;
    for(int p = track - valueNum; p < track; p++)
    {
      sortedArray[p] = index;
      System.out.println(sortedArray[p]);
    }
  }
  //add them together
  //iterate through sorted Array similarly to the run() function
  //repeat for all indexes in the counter1

  return sortedArray;
}
