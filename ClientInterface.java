import java.io.File;
        import java.rmi.*;
        import java.util.List;
public interface ClientInterface extends Remote
{
    public List<String> search(final String pattern, final File folder, List<String> result) throws RemoteException;
}