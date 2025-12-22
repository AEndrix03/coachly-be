package it.coachly.api.security.jwt;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.util.StreamUtils;

import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Configuration
public class JwtDecoderConfig {

    @Bean
    public JwtDecoder jwtDecoder() {
        try {
            var resource = new ClassPathResource("jwt/dominatus-public.pem");
            String publicKeyPEM = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8)
                    .replace("-----BEGIN PUBLIC KEY-----", "")
                    .replace("-----END PUBLIC KEY-----", "")
                    .replaceAll("\\s", "");

            byte[] decoded = Base64.getDecoder().decode(publicKeyPEM);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
            RSAPublicKey publicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(spec);

            return NimbusJwtDecoder.withPublicKey(publicKey).build();
        } catch (Exception e) {
            throw new RuntimeException("Errore caricamento chiave pubblica JWT", e);
        }
    }

}
