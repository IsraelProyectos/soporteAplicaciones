package cat.israel.spring.servicios;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ConvertirAmd5 {

	public String getMD5(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(password.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String passAmd5 = number.toString(16);

			while (passAmd5.length() < 32) {
				passAmd5 = "0" + passAmd5;
			}
			return passAmd5;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}
