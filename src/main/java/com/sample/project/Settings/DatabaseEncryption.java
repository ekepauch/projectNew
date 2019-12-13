//package com.sample.project.Settings;
//
//
//import org.apache.commons.dbcp.BasicDataSource;
//import sun.misc.BASE64Decoder;
//
//import java.io.IOException;
//
//public class DatabaseEncryption extends BasicDataSource {
//
//
//
//
//    public synchronized void setPassword(String encodedPassword){
//        this.password = decode(encodedPassword);
//    }
//
//    private String decode(String password) {
//        BASE64Decoder decoder = new BASE64Decoder();
//        String decodedPassword = null;
//        try {
//            decodedPassword = new String(decoder.decodeBuffer(password));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return decodedPassword;
//    }
//
////    private String generateBase64() {
////        String auth = password;
////        byte[] encodedAuth = org.apache.commons.codec.binary.Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
////        String result=new String(encodedAuth);
////        System.out.println(":::::: Basic Auth "+result);
////        return result;
////    }
//
//
//}
