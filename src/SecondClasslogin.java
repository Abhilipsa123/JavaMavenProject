import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.spec.ECGenParameterSpec;

import javax.crypto.KeyGenerator;

public class SecondClasslogin {
    String[] values ;
    public static void main(String[] args) {
    KeyPairGenerator keyPairGen1 = null;
    
    try {
        keyPairGen1 = KeyPairGenerator.getInstance("RSA");
    } catch (NoSuchAlgorithmException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
    keyPairGen1.initialize(1024); // Noncompliant

    KeyPairGenerator keyPairGen5 = null;
    try {
        keyPairGen5 = KeyPairGenerator.getInstance("EC");
    } catch (NoSuchAlgorithmException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
    }
    ECGenParameterSpec ecSpec1 = new ECGenParameterSpec("secp112r1"); // Noncompliant
    try {
        keyPairGen5.initialize(ecSpec1);
    } catch (InvalidAlgorithmParameterException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    KeyGenerator keyGen1 = null;
    try {
        keyGen1 = KeyGenerator.getInstance("AES");
    } catch (NoSuchAlgorithmException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    keyGen1.init(64); // Noncompliant  
    }
    // Note that values is a String array in the code below.
    //
    public void setValues(String[] somevalues) {
            this.values = somevalues;
    
    try {
        /* ... */
      } catch(Exception e) {
        e.printStackTrace();        // Noncompliant
      }

}
}
