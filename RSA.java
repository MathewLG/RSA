/**
 * Mathew Gabriel Lopez Garcia A01635001
 */

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class RSA{

    private final static BigInteger one = new BigInteger("1");
    public final SecureRandom random = new SecureRandom();

    public BigInteger llavePrivada;
    public BigInteger llavePublica;
    private BigInteger modulo;
    private BigInteger e;
    private int bitlength = 1024;
    //private Random r;
    private BigInteger d;
    String llave = "";

    //Generar los numeros primos para las llaves de tamaño N
    RSA(int N){
        BigInteger p = BigInteger.probablePrime(N/2, random);
        BigInteger q = BigInteger.probablePrime(N/2, random);
        modulo = p.multiply(q);
        e = BigInteger.probablePrime(N / 2, random);
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
        {
            e.add(BigInteger.ONE);
        }
        d = e.modInverse(phi);
        llave += e;
        llave += d;
        //System.out.println(llave);
        llavePublica = new BigInteger(llave);
        llavePrivada = llavePublica.modInverse(phi);
    }

    public BigInteger encriptar(BigInteger mensaje){

        return mensaje.modPow(llavePublica, modulo);
    }

    public BigInteger desencriptar(BigInteger mensajeEncriptado, BigInteger privateKey){
        return mensajeEncriptado.modPow(privateKey, modulo);
    }

}