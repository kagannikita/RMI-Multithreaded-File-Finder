import java.rmi.*;
import java.net.*;
import java.io.*;
import java.util.*;
public class Client implements Runnable{
    public static void main(String args[]) throws Exception {
        new Client().run();
    }
    public void run(){
        try{
            String host="localhost";
            System.out.println("Client running");
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter path: ");
            String directory=sc.nextLine();
            long start = System.currentTimeMillis();
            ClientInterface remobj=(ClientInterface)Naming.lookup("rmi://"+host+"/ClientInterface");
            final File folder = new File(directory);
            List<String> result = new ArrayList<>();
            List<String> res=remobj.search(".*\\.*", folder, result);
            //for (String s : res) {
            // System.out.println("File:"+s);
            //}
            //C:\Program Files\Microsoft Office 15
            //C:\Program Files\R
            System.out.println("Count files in directory "+directory+": " + res.size());
            long end = System.currentTimeMillis();
            float sec = (end - start) / 1000F;
            System.out.println(sec + " seconds");
        }
        catch(RemoteException re){
            re.printStackTrace();
        }
        catch(NotBoundException nbe){
            nbe.printStackTrace();
        }
        catch(MalformedURLException mfe){
            mfe.printStackTrace();
        }
    }
}