package com.fiivirtualcatalog.modules.login.rsa;


import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Alex on 30.03.2017.
 */
public class RSA {

    private BigInteger p;
    private BigInteger q;
    private BigInteger n;
    private BigInteger e;
    private BigInteger d;
    private BigInteger phi;
    private BigInteger x;

    public RSA(String s)
    {
        this.x=new BigInteger(s);
        p=new BigInteger(512, new Random());
        q=new BigInteger(512, new Random());
        d=new BigInteger("0");
        n=new BigInteger("0");
        phi=new BigInteger("0");
        e=new BigInteger("17");
    }

    public BigInteger getX() {
        return x;
    }


    public void computeNumbers()
    {
        p=p.nextProbablePrime();
        q=q.nextProbablePrime();
        n=p.multiply(q);
        BigInteger x=new BigInteger("1");
        phi=p.subtract(x).multiply(q.subtract(x));
        while(!e.gcd(phi).equals(new BigInteger("1")))
            e=e.nextProbablePrime();
        d=e.modInverse(phi);
    }

    public String criptare()
    {
        x=x.modPow(this.e,this.n);
       return x.toString();
    }

    public String decriptareTCR()
    {
        BigInteger a= new BigInteger("1");
        BigInteger dp=d.mod(p.subtract(a));
        BigInteger dq=d.mod(q.subtract(a));
        BigInteger qInv=q.modInverse(p);
        BigInteger m1=x.modPow(dp,p);
        BigInteger m2=x.modPow(dq,q);
        BigInteger h=qInv.multiply(m1.subtract(m2)).mod(p);
        x=m2.add(h.multiply(q));
        return x.toString();
    }

}