
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;

public class Server implements Sorter{
    public Server() {}

    final Stack<Integer> stack = new Stack<Integer>();

    public void pushValue(int val) {
        stack.push(val);
    }

    // public void pushOperator(String operator){
    //     switch(operator){
    //         case "ascending": 

    //     }
    // }

    public int pop(){
        return stack.pop();
    } 

    public static void main(String args[]) {
        try {
            Server obj = new Server();
            Sorter stub = (Sorter) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Sorter", stub);

            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}