/**
 * Mathew Gabriel Lopez Garcia A01635001
 */

import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA{

    private final static BigInteger one = new BigInteger("1");
    public final SecureRandom random = new SecureRandom();

    public BigInteger llavePrivada;
    public BigInteger llavePublica;
    private BigInteger modulo;

    //Generar los numeros primos para las llaves de tamaño N
    RSA(int N){
        BigInteger p = BigInteger.probablePrime(N/2, random);
        BigInteger q = BigInteger.probablePrime(N/2, random);
        modulo = p.multiply(q);
        BigInteger phi = (p.subtract(one)).multiply(q.subtract(one));
        llavePublica = new BigInteger("65537");
        llavePrivada = llavePublica.modInverse(phi);
    }

    public BigInteger encriptar(BigInteger mensaje){

        return mensaje.modPow(llavePublica, modulo);
    }

    public BigInteger desencriptar(BigInteger mensajeEncriptado, BigInteger privateKey){
        return mensajeEncriptado.modPow(privateKey, modulo);
    }

}