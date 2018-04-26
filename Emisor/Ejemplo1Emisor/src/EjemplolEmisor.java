import java.io.IOException;
 import java.net.*;
/**
5 * Este ejemplo ilustra las llamadas de método básicas para sockets
 * datagrama sin conexión
 * Universidad de la Sierra Sur
 * Lic. Informática
 */
 public class EjemplolEmisor {

 // Una aplicación que manda un mensaje utilizando un socket datagrama
 // sin conexión.
 // Se esperan tres argumentos de línea de mandato, en orden:
 // cnoirbre del dominio o dirección IP del receptor>
 // <número del puerto del socket del receptor>
 // mensaje, una cadena, para mandar>

    public static void main(String[ ] args) {
       if (args. length != 3)
          System.out.println("Este programa requiere 3 argumentos de linea de mandato");
       else {
          try {
              InetAddress maquinaReceptora = InetAddress. getByName (args [ 0 ]) ;
              int puertoReceptor = Integer.parseInt(args[1]);
              String mensaje = args[2];

              // instancia un socket datagrama para mandar los datos
              DatagramSocket miSocket = new DatagramSocket ();
              byte[ ] almacén = mensaje.getBytes();
              DatagramPacket datagrama = new DatagramPacket(almacén, almacén.length, maquinaReceptora, puertoReceptor);
              miSocket.send(datagrama);
              miSocket.close();
          } // fin de try
          catch (IOException | NumberFormatException ex) {
              ex.printStackTrace() ;
          } // fin de catch
       } // fin de else
    } // fin de main
}