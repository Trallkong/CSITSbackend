package com.trallkong.csitsbackend.security;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class CryptoUtils {

    private static final int ITERATIONS = 3;
    private static final int MEMORY_KB = 64 * 1024;
    private static final int PARALLELISM = 1;

    public static String encrypt(String plainText) {
        Argon2 argon2 = Argon2Factory.create(
                Argon2Factory.Argon2Types.ARGON2id
        );

        try {
            return argon2.hash(
                    ITERATIONS,
                    MEMORY_KB,
                    PARALLELISM,
                    plainText.toCharArray()
            );
        } finally {
            argon2.wipeArray(plainText.toCharArray());
        }
    }

    public static boolean verify(String hash, String password) {
        Argon2 argon2 = Argon2Factory.create(
                Argon2Factory.Argon2Types.ARGON2id
        );

        char[] pwd = password.toCharArray();

        try {
            return argon2.verify(hash, pwd);
        } finally {
            argon2.wipeArray(pwd);
        }
    }
}
