import java.util.*;

/**
 * Created by lukbanc on 11/8/16.
 */

public class FCFS extends Thread {

    /* Queue for the FCFS method*/
    /* Map Client Processes to booleans so isRunning gets set from true to false */
    private static Queue<Request> Q = new LinkedList<>();
    private static HashMap<Integer, Boolean> clientProcesses = new HashMap<Integer, Boolean>();

    /* Function that adds the Client's request to the Queue */
    public synchronized static void addTo(Request t) {

        Q.add(t);
        clientProcesses.put(t.clientId, true);
    }

    /* isRunning is a method that Client asks in the while loop
    *  will break from while loop once servicedReq is called
    *  from Driver
    */
    public synchronized static boolean isRunning(int clientId) {
      return clientProcesses.get(clientId);
    }

    /* Method that driver calls once request is fullfilled
    *  Will break out from while loop in Client class
    */
    public synchronized static void servicedReq(int clientId) {
      clientProcesses.put(clientId, false);
    }

    /* Gets the request that Driver calls
    *  For SSTF calls findNearestReq
    */
    public synchronized static Request getRequest() {

      if(Q.isEmpty()){
        return null;
      }
      else{
        return Q.poll();
      }
    }

    /* Method that Driver calls repeatedly if there is anything in the List*/
    public synchronized static boolean notEmpty() {
      if(!Q.isEmpty()){
        return true;
      }
      else {return false;}
    }
}
