import java.util.*;

/**
 * Created by lukbanc on 11/5/16.
 */

public class Client extends Thread{

    public static int NumReq;
    public static int NumberOfClients;
    public static double TotalTime = 0.0;

    public Client() {super();}

    public void run() {

      int clientId = (int) getId();
          for (int i = 0; i < NumReq; i++){
            try{
              Thread.sleep((long) (5 + Math.random() * (15 - 5) + 1));
            }
            catch (InterruptedException e){}
            int request = (int) (1 + Math.random() * (16000 - 1 + 1));
            Request clientReq = new Request(clientId, request);
            //time in milli start
            long startTime = System.currentTimeMillis();
            FCFS.addTo(clientReq);
            while(FCFS.isRunning(clientId)){} //do nothing till false
            //time in milli end
            long endTime = System.currentTimeMillis() - startTime;
            CollectTime.getAddT(endTime);
          }
      }

    public static void main(String args[]){

        /* Create clients*/
        NumberOfClients = Integer.parseInt(args[0]);
        Client[] client = new Client[(Integer.parseInt(args[0]))];
        NumReq = Integer.parseInt(args[1]);
        for (int i=0; i < Integer.parseInt(args[0]); i++){
            client[i] = new Client();
            client[i].start();
        }

        /* Create Driver thread*/
        Driver driver = new Driver();
        driver.start();
    }
}
