package com.vso.models;

import java.security.SecureRandom;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class Password {
	// The higher the number of iterations the more
	// expensive computing the hash is for us and
	// also for an attacker.
	private static final int iterations = 20 * 1000;
	private static final int saltLen = 32;
	private static final int desiredKeyLen = 256;

	/**
	 * Computes a salted PBKDF2 hash of given plaintext password suitable for
	 * storing in a database. Empty passwords are not supported.
	 */
	public static String getSaltedHash(String password) throws Exception {
		byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(saltLen);
		System.out.println("Password.java method:getSaltedHash salt:" + Base64.encodeBase64String(salt));
		// store the salt with the password
		return Base64.encodeBase64String(salt) + "$" + hash(password, salt);
	}

	/**
	 * Checks whether given plaintext password corresponds to a stored salted
	 * hash of the password.
	 */
	public static boolean check(String password, String storedPassword) throws Exception {
		System.out.println("Password.java method:check ************************************************************");
		String[] saltAndPass = storedPassword.split("\\$");
		if (saltAndPass.length != 2) {
			throw new IllegalStateException("The stored password have the form 'salt$hash'");
		}
		String hashOfInput = hash(password, Base64.decodeBase64(saltAndPass[0]));
		System.out.println("Password.java method:check hashOfInput: " + hashOfInput);
		System.out.println("Password.java method:check storedPassword: " + saltAndPass[1]);
		System.out.println("Password.java method:check equals: " + hashOfInput.equals(saltAndPass[1]));
		return hashOfInput.equals(saltAndPass[1]);
	}

	public static boolean checkCookiePassword(String cookiePassword, String dbPassword) throws Exception {
		System.out.println("Password.java checkCookiePassword ************************************************************");
		String[] saltAndPassCookie = cookiePassword.split("\\$");
		if (saltAndPassCookie.length != 2) {
			throw new IllegalStateException("The stored password have the form 'salt$hash'");
		}
		String[] saltAndPassDB = cookiePassword.split("\\$");
		if (saltAndPassDB.length != 2) {
			throw new IllegalStateException("The stored password have the form 'salt$hash'");
		}
		System.out.println("Password.java checkCookiePassword equals: " + saltAndPassDB[1].equals(saltAndPassCookie[1]));
		return saltAndPassDB[1].equals(saltAndPassCookie[1]);
	}
	
	// using PBKDF2 from Sun, an alternative is https://github.com/wg/scrypt
	// cf. http://www.unlimitednovelty.com/2012/03/dont-use-bcrypt.html
	private static String hash(String password, byte[] salt) throws Exception {
		if (password == null || password.length() == 0)
			throw new IllegalArgumentException("Empty passwords are not supported.");
		SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		SecretKey key = f.generateSecret(new PBEKeySpec(password.toCharArray(), salt, iterations, desiredKeyLen));
		return Base64.encodeBase64String(key.getEncoded());
	}

	public static boolean compareHashs(String firstHash, String secondHash) {
		String[] firstHashSaltAndPass = firstHash.split("\\$");
		if (firstHashSaltAndPass.length != 2) {
			throw new IllegalStateException("The stored password have the form 'salt$hash'");
		}
		String[] secondHashSaltAndPass = firstHash.split("\\$");
		if (secondHashSaltAndPass.length != 2) {
			throw new IllegalStateException("The stored password have the form 'salt$hash'");
		}
		return firstHashSaltAndPass[1].equals(secondHashSaltAndPass[1]) ? true : false;
	}

}