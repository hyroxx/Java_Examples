
import java.net.*;  
import java.io.*;  
class client{  
public static void main(String args[])throws Exception{  
Socket s=new Socket("localhost",3333);  
DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
 
String str=" ",cipherText ="";  
cipherText =din.readUTF();  
cipherText = cipherText.toLowerCase();
int i,key=0;
for(i=0;i<cipherText .length();i++){
 
      if(cipherText .charAt(i)==' ')
           key++;
}
if(key==0){
    key=5;}
else{
  key=key*3;
}
 
String decryptMessage = "";
        for( i=0; i < cipherText.length();i++)  
        {
            // Shift one character at a time
            char alphabet = cipherText.charAt(i);
            // if alphabet lies between a and z
            if(alphabet >= 'a' && alphabet <= 'z')
            {
                // shift alphabet
                alphabet = (char) (alphabet - key);
           
                // shift alphabet lesser than 'a'
                if(alphabet < 'a') {
                    //reshift to starting position
                    alphabet = (char) (alphabet-'a'+'z'+1);
                }
                decryptMessage = decryptMessage + alphabet;
            }    
                // if alphabet lies between A and Z
            else if(alphabet >= 'A' && alphabet <= 'Z')
            {
             // shift alphabet
                alphabet = (char) (alphabet - key);
               
                //shift alphabet lesser than 'A'
                if (alphabet < 'A') {
                    // reshift to starting position
                    alphabet = (char) (alphabet-'A'+'Z'+1);
                }
                decryptMessage = decryptMessage + alphabet;            
            }
            else
            {
             decryptMessage = decryptMessage + alphabet;            
            }
        }
System.out.println("Decryped Text:  "+decryptMessage   );  
System.out.println("Encryped Text:  "+cipherText );  
 
dout.flush();  
dout.close();  
s.close();  
}}  
