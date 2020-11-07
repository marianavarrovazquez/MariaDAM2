/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m9_act5;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author maria
 */
public class RSA {
    public PrivateKey PrivateKey = null;
    public PublicKey PublicKey = null;
    
    public void setPrivateKeyString(String key) throws NoSuchAlgorithmException, InvalidKeySpecException{
        byte[] encodedPrivateKey = stringToBytes(key);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(encodedPrivateKey);
	PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec);
	this.PrivateKey = privateKey;
    }
    
    public void setPublicKeyString(String key) throws NoSuchAlgorithmException, InvalidKeySpecException{		
	byte[] encodedPublicKey = stringToBytes(key);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
	X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(encodedPublicKey);
	PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
	this.PublicKey = publicKey;
    }

    public String getPrivateKeyString(){
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(this.PrivateKey.getEncoded());
	return bytesToString(pkcs8EncodedKeySpec.getEncoded());
    }

    public String getPublicKeyString(){
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(this.PublicKey.getEncoded());
     	return bytesToString(x509EncodedKeySpec.getEncoded());
    }
		
    public void genKeyPair(int size) throws NoSuchAlgorithmException,NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException  {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
	kpg.initialize(size);
	KeyPair kp = kpg.genKeyPair();
	PublicKey publicKey = kp.getPublic();
	PrivateKey privateKey = kp.getPrivate();
        this.PrivateKey = privateKey;
        this.PublicKey = publicKey;
    }

    public String Encrypt(String plain) throws NoSuchAlgorithmException,NoSuchPaddingException, InvalidKeyException,IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, UnsupportedEncodingException, NoSuchProviderException {
        byte[] encryptedBytes; 
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, this.PublicKey);
        encryptedBytes = cipher.doFinal(plain.getBytes());
        return bytesToString(encryptedBytes);
    }

    public String Decrypt(String result) throws NoSuchAlgorithmException,NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] decryptedBytes;
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, this.PrivateKey);
        decryptedBytes = cipher.doFinal(stringToBytes(result));
        return new String(decryptedBytes);
    }
}
