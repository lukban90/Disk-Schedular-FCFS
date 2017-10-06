/**
 * Created by lukbanc on 11/9/16.
 */
public class Request {

    public int clientId;
    public static int reqNum;

    public Request (int clientId, int reqNum){
        this.clientId = clientId;
        this.reqNum = reqNum;
    }
}
