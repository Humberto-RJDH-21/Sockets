 import java.net.*;
 import java.io.*;
/* *
 * E s te e je m p lo i l u s t r a l a s lla m ad as d e m étodo b á s i c a s p a r a s o c k e ts
 * d a ta g r a m a s i n c o n e x ió n .
 * G a u th o r M. L . L iu
 */
 public class Ejemplo1Receptor{

 // Una a p lic a c ió n q ue r e c i b e un m en saje u ti li z a n d o un s o c k e t datagram a
 // s i n c o n e x ió n .
 // S e e s p e r a un a rg u m e n to d e l í n e a d e m a n d a to :
 // e n u m ero d e p u e r t o d e l s o c k e t d e l r e c e p t o r >
 // N o ta : s e d e b e r í a e s p e c i f i c a r e l m ism o n ú m ero d e p u e r t o
 // e n l o s a rg u m e n to s d e l í n e a d e m a n d a to d e l e m i s o r .

 public static void main(String[ ] args) throws SocketException, IOException {
    if (args. length != 1)
        System.out.println("Este programa requiere un argumento de línea de mandato.");
    else {
        int puerto = Integer.parseInt(args[0]);
        final int MAX_LON = 10 ;
 // Esta es la longitud máxima asumida en octetos
 // del datagrama que se va a recibir.
        try {
            DatagramSocket miSocket = new DatagramSocket (puerto);
 // instancia un socket datagrama para recibir los datos
            byte[]almacen = new byte[ MAX_LON ] ;
 DatagramPacket datagrama = new DatagramPacket(almacen,MAX_LON);
 miSocket.receive (datagrama);
 String mensaje = new String(almacen);
 System.out.println(mensaje);
 miSocket.close( );
        } // fin de try
 catch (Exception ex) {
    ex.printStackTrace( );
    } // fin de catch
 } // fin de else
 } // fin de main
} // f i n d e c l a s s