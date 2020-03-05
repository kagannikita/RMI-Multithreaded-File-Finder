import java.rmi.*;
import java.net.*;
public class Server
{
    public static void main(String args[]) throws Exception
    {
        new Server();
    }
    public Server(){
        try{
            System.out.println("Server running");
            ServerImpl locobj=new ServerImpl();
            Naming.rebind("rmi:///ClientInterface",locobj);
        }
        catch(RemoteException re){
            re.printStackTrace();
        }
        catch(MalformedURLException mfe){
            mfe.printStackTrace();
        }
    }
}