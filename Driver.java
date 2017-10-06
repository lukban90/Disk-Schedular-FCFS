import java.util.*;
/**
 * Created by lukbanc on 11/6/16.
 */

public class Driver extends Thread{

    public Driver() {super();}

    public void run() {

      int curPosition = 0;
      int counter = 0;
      int totalRequests = Client.NumberOfClients * Client.NumReq;
      while (counter < totalRequests){
        if(FCFS.notEmpty()){
          Request currentReq = FCFS.getRequest();
          if(currentReq == null){continue;}
          try{sleep((long)(10 + (0.1 * Math.abs(curPosition - currentReq.reqNum))));}
          catch(InterruptedException e){}
          FCFS.servicedReq(currentReq.clientId);
          curPosition = currentReq.reqNum;
          counter++;
        }
      }
      CollectTime.outPutCalc();
      CollectTime.variance(CollectTime.getList());
      CollectTime.throughPut();
    }
}
