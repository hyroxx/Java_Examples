import java.io.*;
import java.net.*;
public class udpClientEO
{
  public static void main(String args[])
  {
      try
      {
         DatagramSocket ds = new DatagramSocket(1000);
         BufferedReader br = new BufferedReader(new
         InputStreamReader(System.in));
         System.out.println("Enter edge lengths respectively : ");
         String a = br.readLine();
         String b = br.readLine();
         String c = br.readLine();
         byte a1[] = new byte[1024];
         byte b1[] = new byte[1024];
         byte c1[] = new byte[1024];
         a1=a.getBytes();
         b1=b.getBytes();
         c1=c.getBytes();
         DatagramPacket dpa = new DatagramPacket(a1,a1.length,InetAddress.getLocalHost(),2000);
         DatagramPacket dpb = new DatagramPacket(b1,b1.length,InetAddress.getLocalHost(),2000);
         DatagramPacket dpc = new DatagramPacket(c1,c1.length,InetAddress.getLocalHost(),2000);
         ds.send(dpa);
         ds.send(dpb);
         ds.send(dpc);
         byte x[] = new byte[1024];
         byte y[] = new byte[1024];
         byte z[] = new byte[1024];
         DatagramPacket dp1 = new DatagramPacket(x,x.length);
         DatagramPacket dp2 = new DatagramPacket(y,y.length);
         DatagramPacket dp3 = new DatagramPacket(z,z.length);
         ds.receive(dp1);
         String str = new String(dp1.getData(),0,dp1.getLength());
         System.out.println(str);
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
}