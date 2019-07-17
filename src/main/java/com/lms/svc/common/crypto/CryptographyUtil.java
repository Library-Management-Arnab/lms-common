package com.lms.svc.common.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.lms.svc.common.exception.CryptographyException;

public final class CryptographyUtil {
	private static final Logger LOG = LoggerFactory.getLogger(CryptographyUtil.class);
	
	private CryptographyUtil() {
	}

	private static SecretKeySpec secretKey;
	private static byte[] key;
	
	public static String generateSecret() {
		String randomString = RandomStringUtils.randomAlphanumeric(16);
		return Base64.getEncoder().encodeToString(randomString.getBytes());
	}

	public static String encrypt(String originalString, String secretString) {
		try {
			setKey(secretString);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			byte[] finalEncrypted = cipher.doFinal(originalString.getBytes("UTF-8"));
			return Base64.getEncoder().encodeToString(finalEncrypted);
		} catch (Exception e) {
			LOG.error("Error while encrypting string - [{}]", e);
			throw new CryptographyException(e);
		}
	}

	public static String decrypt(String encryptedString, String secretString) {
		try {
			setKey(secretString);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedString)));
		} catch (Exception e) {
			LOG.error("Error while decrypting string - [{}]", e);
			throw new CryptographyException(e);
		}
	}
	
	private static void setKey(String aKey) {
		try {
			key = aKey.getBytes();
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
			LOG.error("Error while setting the key - [{}]", e);
			throw new CryptographyException(e);
		}
	}
	
	public static void main(String[] args) {
		String secret = generateSecret();
		String enc = encrypt("India123$", secret);
		System.out.println("Encrypted String - " + enc);
		enc = encrypt("India123$", "1234567890");
		System.out.println("Re-Encrypted String - " + enc);
		String dec = decrypt(enc, "1234567890");
		System.out.println("Decrypted String - " + dec);
	}
}
