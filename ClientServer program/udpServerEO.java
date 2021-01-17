import java.io.*;
import java.net.*;
public class udpServerEO
{
   public static void main(String args[])
   {
       try
       {
          DatagramSocket ds = new DatagramSocket(2000);
          System.out.println("Server started");
          byte a[] = new byte[1024];
          byte b[] = new byte[1024];
          byte c[] = new byte[1024];
          DatagramPacket dpa = new DatagramPacket(a,a.length);
          DatagramPacket dpb = new DatagramPacket(b,b.length);
          DatagramPacket dpc = new DatagramPacket(c,c.length);
          ds.receive(dpa);
          ds.receive(dpb);
          ds.receive(dpc);
          String stra = new String(dpa.getData(),0,dpa.getLength());
          String strb = new String(dpb.getData(),0,dpb.getLength());
          String strc = new String(dpc.getData(),0,dpc.getLength());
          System.out.println(stra);
          System.out.println(strb);
          System.out.println(strc);
          int a1 = Integer.parseInt(stra);
          int b1 = Integer.parseInt(strb);
          int c1 = Integer.parseInt(strc);
          String s= new String();
          if (a1 + b1 <= c1 || a1 + c1 <= b1 || b1 + c1 <= a1) 
            s = "It is not Triangle"; 
          else
            s = "It is Triangle"; 
          byte bb1[] = new byte[1024];
          bb1 = s.getBytes();
          DatagramPacket dp1 = new DatagramPacket(bb1,bb1.length,InetAddress.getLocalHost(),1000);
          ds.send(dp1);
       }
       catch(Exception e)
       {
          e.printStackTrace();
       }
     }
}