package com.sample.project;

import com.sample.project.Utils.Util;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) throws NoSuchPaddingException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, InvalidKeyException {
		SpringApplication.run(ProjectApplication.class, args);

		DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		Calendar calobj = Calendar.getInstance();
		System.out.println(df.format(calobj.getTime()));

//		Random r = new Random();
//		char c = (char)(r.nextInt(26) + 'a');
//		System.out.println(c);

//		Random rd = new Random();
//		String abc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		char letter = abc.charAt(rd.nextInt(abc.length()));

//		Random r = new Random();
//		char random_3_Char = (char) (97 + r.nextInt(26));


//		String SALTCHARS = "1234567890";
//		StringBuilder salt = new StringBuilder();
//		Random rnd = new Random();
//		while (salt.length() < 24) { // length of the random string.
//			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
//			salt.append(SALTCHARS.charAt(index));
//		}
//		String saltStr = salt.toString();
//		System.out.println(saltStr);




//		String auth = "don";
//    byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
//    String result=new String(encodedAuth);
//    System.out.println(":::::: PASSWORD "+result);


//		Util util = new Util();
//		String pass ="paycms$%@";
//		//String pass ="nibssmysqldatabase";
//		String encypt = util.encryptData(pass);
//		System.out.println(":::::: ENCRYPTION "+encypt);
//
//		String decrypt = util.decryptData(encypt);
//		System.out.println(":::::: DECRYPTION "+decrypt);


	}

}


