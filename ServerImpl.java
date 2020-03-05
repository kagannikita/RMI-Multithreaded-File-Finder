import java.io.File;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
public class ServerImpl extends UnicastRemoteObject implements ClientInterface
{
    public ServerImpl() throws RemoteException{}
    public   List<String> search(final String pattern, final File folder, List<String> result) {
        Thread t = Thread.currentThread();
        t.setName("My Thread");
        t.setPriority(1);
        for (final File f : folder.listFiles()) {
            if (f.isDirectory()) {
                search(pattern, f, result);
            }
            if (f.isFile()) {
                if (f.getName().matches(pattern)) {
                    result.add(f.getAbsolutePath());
                    System.out.println("File:"+f);
                }
            }
        }
        int active = Thread.activeCount();
        System.out.println("currently active threads: " + active);
        Thread all[] = new Thread[active];
        Thread.enumerate(all);
        for (int i = 0; i < active; i++) {
            System.out.println(i + ": " + all[i]);
        }
        return result;

    }
}