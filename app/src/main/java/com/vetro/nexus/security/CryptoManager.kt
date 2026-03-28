import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec
import javax.crypto.spec.SecretKeySpec
import java.util.Base64

class CryptoManager {
    private val AES_GCM_NO_PADDING = "AES/GCM/NoPadding"
    private val TAG_LENGTH_BIT = 128

    fun generateKey(): SecretKey {
        val keyGen = KeyGenerator.getInstance("AES")
        keyGen.init(256) // AES-256
        return keyGen.generateKey()
    }

    fun encrypt(plainText: String, secretKey: SecretKey): String {
        val cipher = Cipher.getInstance(AES_GCM_NO_PADDING)
        cipher.init(Cipher.ENCRYPT_MODE, secretKey)
        val iv = cipher.iv
        val cipherText = cipher.doFinal(plainText.toByteArray())
        val ivAndCipherText = iv + cipherText
        return Base64.getEncoder().encodeToString(ivAndCipherText)
    }

    fun decrypt(cipherTextWithIv: String, secretKey: SecretKey): String {
        val ivAndCipherText = Base64.getDecoder().decode(cipherTextWithIv)
        val iv = ivAndCipherText.copyOfRange(0, 12) // First 12 bytes for IV
        val cipherText = ivAndCipherText.copyOfRange(12, ivAndCipherText.size)
        val cipher = Cipher.getInstance(AES_GCM_NO_PADDING)
        val spec = GCMParameterSpec(TAG_LENGTH_BIT, iv)
        cipher.init(Cipher.DECRYPT_MODE, secretKey, spec)
        val plainText = cipher.doFinal(cipherText)
        return String(plainText)
    }
}