/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.tecsegapi.util;


import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 *
 * @author Wolverine
 */
public class Criptografia {
	
	
 
    
	public String encript(String value) {
		String senha = null;
		MessageDigest algorithm = null;
		try {
			algorithm = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte messageDigest[] = null;
		try {
			messageDigest = algorithm.digest(value.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(Criptografia.class.getName()).log(Level.SEVERE, null, ex);
		}

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		senha = hexString.toString();
		return senha;
	}
}
