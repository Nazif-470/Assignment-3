// RMIExampleImpl.java
// Implements the remote object
// Note: The object must extend from UnicastRemoteObject
//       The object must implement the associated interface

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;

public class RMIExampleImpl extends UnicastRemoteObject
    implements RMIExample
{
    protected static String          m_strName;

    public RMIExampleImpl() throws RemoteException
    {
        super(); // call base class constructor
    }
   
    public boolean PostMsg(String strMsg) throws RemoteException
    {
        System.out.println("Server: PostMsg() invoked...");
        System.out.println("Server: Message > " + strMsg);
        return true;
    }

    public long Factorial(long lVal) throws RemoteException
    {
        long lRes = FactorialEx(lVal);
        System.out.println("Server: Factorial() invoked...");
        System.out.println("Server: Factorial("+lVal+") = " + lRes);
        return lRes;
    }
   
    protected long FactorialEx(long lVal)
    {
        if (lVal <= 1)
            return 1;
        else
            return lVal * FactorialEx(lVal-1);
    }
           
    public static void main(String argv[])
    {
        try
        {
            m_strName = "TheRMIExample";
            System.out.println("Server: Registering RMIExampleImpl as \"" + m_strName +"\"");
            RMIExampleImpl Example = new RMIExampleImpl();
            Naming.rebind(m_strName, Example);
            System.out.println("Server: Ready...");
        }
        catch (Exception e)
        {
            System.out.println("Server: Failed to register RMIExampleImpl: " + e);
        }
    }
}