// RMIExample.java
// Interface for the RMI remote object.
// Note:  Interface must extend from java.rmi.Remote
//          Methods must throw RemoteExcpetion

import java.rmi.*;

public interface RMIExample extends Remote
{
        public boolean PostMsg(String strMsg) throws RemoteException;
        public long Factorial(long lVal) throws RemoteException;
}
