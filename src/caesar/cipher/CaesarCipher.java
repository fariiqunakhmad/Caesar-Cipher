/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caesar.cipher;

import java.util.Scanner;

/**
 *
 * @author Afa
 */
public class CaesarCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan plaintext:");
        String str = input.nextLine();
        System.out.println("Masukkan nilai offset:");
        int os = input.nextInt();
        System.out.println("");
        System.out.println("Hasil encode (ciphertext):");
        String cipher= CaesarCipher.encode( str, os );
        System.out.println( cipher );
        System.out.println("");
        System.out.println("Hasil decode (plaintext):");
        System.out.println( CaesarCipher.decode( cipher, os ));
    }
     public static String decode(String ciphertext, int offset) {
//        return encode(enc, 26-offset);
         StringBuilder stringBuilder = new StringBuilder();
        for (char p : ciphertext.toCharArray()) {
            int os;
//            System.out.println(p+" "+Character.getType(p));
            if (Character.isLetter(p)) {
                os = (26-offset) % 26 + 26;
                if (Character.isUpperCase(p)) {
                    stringBuilder.append((char) ('A' + (p - 'A' + os) % 26 ));
                } else {
                    stringBuilder.append((char) ('a' + (p - 'a' + os) % 26 ));
                }
            } else if(Character.isDigit(p)){
                os = (10-offset) % 10 + 10;
                
                stringBuilder.append((char) ('0' + (p - '0' + os) % 10 ));
            }else {
                stringBuilder.append(p);
            }
        }
        return stringBuilder.toString();
    }

    public static String encode(String plaintext, int offset) {
//        offset = offset % 26 + 26;
        StringBuilder stringBuilder = new StringBuilder();
        for (char p : plaintext.toCharArray()) {
            int os;
//            System.out.println(p+" "+Character.getType(p));
            if (Character.isLetter(p)) {
                os = offset % 26 + 26;
                if (Character.isUpperCase(p)) {
                    stringBuilder.append((char) ('A' + (p - 'A' + os) % 26 ));
                } else {
                    stringBuilder.append((char) ('a' + (p - 'a' + os) % 26 ));
                }
            } else if(Character.isDigit(p)){
                os = offset % 10 + 10;
                stringBuilder.append((char) ('0' + (p - '0' + os) % 10 ));
            }else {
                stringBuilder.append(p);
            }
        }
        return stringBuilder.toString();
    }
}
