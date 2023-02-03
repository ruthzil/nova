package br.com.ruthzil.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class TesteMD5 {
	private static char[] hexDigits = "0123456789ABCDEF".toCharArray();

	private static String hex(byte[] bytes) {
		StringBuilder sb = new StringBuilder();
		for (byte b : bytes) {
			sb.append(hexDigits[(b & 0xF0) >>> 4]).append(hexDigits[b & 0x0F]);
		}
		return sb.toString();
	}

	public static String calcMD5(String senha) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			InputStream is = null;
			try {
				is = new BufferedInputStream(new FileInputStream(senha));
				byte[] buf = new byte[8192];
				for (int nBytes = is.read(buf, 0, buf.length); nBytes > 0; nBytes = is.read(buf, 0, buf.length)) {
					md.update(buf, 0, nBytes);
				}
			} catch (IOException ex) {
				if (is != null)
					try {
						is.close();
					} catch (IOException ex2) {
					}
			}
			byte[] digest = md.digest();
			return hex(digest);
		} catch (NoSuchAlgorithmException ex) {
			// MD5 sempre está disponível
			throw new RuntimeException("Can't happen", ex);
		}
	}
}
