/**
 * Mathew Gabriel Lopez Garcia
 * A01635001
 */

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        System.out.println("BIENVENIDO AL SISTEMA DE ENCRIPCION DE MENSAJES RSA DE MATHEW LOPEZ \n");
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Ingrese el texto que desea encriptar \n");
        String s = scanner.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        TimeUnit.MILLISECONDS.sleep(300);
        System.out.println("Generando sus credenciales... \n");
        for(int i = 0; i < 200; i++){
            System.out.print("-");
            TimeUnit.MILLISECONDS.sleep(30);
        }
        System.out.println();
        int N = s.length() * 8;
        RSA key = new RSA(N);
        //System.out.println(key);
        System.out.println("SU LLAVE PUBLICA ES: " + key.llavePublica);
        System.out.println("SU LLAVE PRIVADA ES: " + key.llavePrivada);
        System.out.println("***NUNCA COMPARTA SU LLAVE PRIVADA***");
        byte[] mensaje = s.getBytes();
        BigInteger message = new BigInteger(mensaje);
        BigInteger encriptar = key.encriptar(message);
        System.out.println("Su mensaje encriptado es: " + encriptar);
        System.out.println("Ingrese su llave privada para desencriptar el mensaje");
        String input = scanner.nextLine();
        BigInteger inputKey = new BigInteger(input);
        System.out.println("El mensaje desencriptado con esa llave es: ");
        BigInteger desencriptar = key.desencriptar(encriptar,inputKey);
        String desencriptado = new String(desencriptar.toByteArray(), StandardCharsets.UTF_8);
        System.out.println(desencriptado);
        System.out.println("¿El mensaje no tiene sentido? Revise su llave privada \n");
        while(!input.equals("1")){
            System.out.println("INGRESE SU LLAVE PRIVADA");
            input = scanner.nextLine();
            inputKey = new BigInteger(input);
            desencriptar = key.desencriptar(encriptar,inputKey);
            desencriptado = new String(desencriptar.toByteArray(),StandardCharsets.UTF_8);
            System.out.println("El mensaje desencriptado con esa llave es:");
            System.out.println(desencriptado);
            System.out.println("El mensaje no tiene sentido? Revise su llave privada");
            System.out.println("Para salir ingrese 1");

        }
        System.out.println("HASTA LA PROXIMA!");
    }
}
