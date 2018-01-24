import java.net.Socket;
import java.util.Scanner;
import java.lang.Exception;
import java.lang.Thread;

class PortScanner{
    public static void main(String []args){
        Scanner s= new Scanner(System.in);
        int port;
        System.out.print("Enter web url :");
        String url = s.next();
        for(port=0;port<65536;port++){
            ScannerThread h = new ScannerThread(url,port);
            h.start();
        }
        s.close();
    }
}
class ScannerThread extends Thread{
    int port;
    String url;
    ScannerThread(String url,int port){
        this.url=url;
        this.port=port;
    }
    private void getStatus(){
        try{
            Socket skt = new Socket(url,port);
            System.out.println(port);
            skt.close();
        }catch(Exception e){
            //Handle Exception here
        }
    }
    public void run(){
        getStatus();
    }

}
