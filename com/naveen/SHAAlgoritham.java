package com.naveen;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHAAlgoritham {
	
	final String merchantId = "M2sSQjY7";
	final String txnId      = "100123abc";
	float    amount         = 200;
	String productInfo      = "mobile";
	String firstName        = "naveen";
	String email            = "naveenjava484@gmail.com";
	String salt             = "FfcLv3Ob47";
	String udf1  ="";
	String udf2  ="";
	String udf3  ="";
	String udf4  ="";
	String udf5  ="";
	
	String hashSequence ="";
	String result="";
	public  String getPassword() 
	{
		hashSequence = merchantId+txnId+amount+productInfo+firstName+email+udf1+udf2+udf3+udf4+udf5+salt;
		System.out.println(hashSequence);
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			digest.reset();
			digest.update(hashSequence.getBytes("utf8"));
			result =  String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	/*public String shaPassword()
	{
		hashSequence = merchantId+txnId+amount+productInfo+firstName+email+udf1+udf2+udf3+udf4+udf5+salt;
		byte data[] = new byte[1024];
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-512");
			digest.reset();
			digest.update(hashSequence.getBytes("utf8"));
			result =  String.format("%040x", new BigInteger(1, digest.digest()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/
}
