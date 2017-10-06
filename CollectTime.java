import java.util.*;

public class CollectTime {

  private static List<Long> CollectOfTimes = new LinkedList<Long>();
  private static long valOfMean;
  private static long totalTime;

  /* Calculates the Mean and saves the totalTime*/
  public synchronized static void outPutCalc() {

    long result = 0;
    for(int i = 0; i < CollectOfTimes.size(); i++){
      result = result + CollectOfTimes.get(i);
    }

    totalTime = result;
    valOfMean = (result/(Client.NumberOfClients * Client.NumReq));
    System.out.println("Mean: " + (result/(Client.NumberOfClients * Client.NumReq)) + " ms");
    //return result;
  }

  /* Helper function fro obataining the variance*/
  public synchronized static double varAux(int reqTime){
    long val = 0;
    val = (reqTime - valOfMean) * (reqTime - valOfMean);
    return val;
  }

  /* Caculates the variance*/
  public synchronized static double variance(List<Long> l) {
    double varResult = 0;
    for(int i = 0; i < CollectOfTimes.size(); i++) {
      varResult = varResult + varAux(i);
    }
    System.out.println("Variance: " + varResult + " ms");
    return varResult;
  }

  /* Method that Client uses to add time for each request fullfilled*/
  public synchronized static void getAddT(long value) {
    CollectOfTimes.add(value);
  }

  /* Method that variance uses to help obtain the variance*/
  public synchronized static List<Long> getList() {
    return CollectOfTimes;
  }

  /* Caculates the throughPut*/
  public synchronized static void throughPut() {
    double throughPut = (double)(Client.NumberOfClients * Client.NumReq)/totalTime;
    //System.out.println("totalRequests " + (Client.NumberOfClients * Client.NumReq));
    //System.out.println("totalTime: " + totalTime);
    System.out.println("Throughput: " + throughPut);
    //return throughPut;
  }


}
