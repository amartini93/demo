package test.ey.demo.util;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class JwtKeyGenerator {
    public static SecretKey generateKey() {
        try {
            // Use a KeyGenerator for HMAC
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");

            // Generate a 256-bit key
            keyGenerator.init(256);
            return keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating JWT key", e);
        }
    }
}
