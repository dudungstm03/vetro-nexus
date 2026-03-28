package com.vetro.nexus.data.local;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.security.crypto.EncryptedSharedPreferences;
import androidx.security.crypto.MasterKey;

public class SecureStorage {
    private static final String SHARED_PREFS_FILE = "secure_prefs";
    private SharedPreferences sharedPreferences;

    public SecureStorage(Context context) throws Exception {
        MasterKey masterKey = new MasterKey.Builder(context)\n                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)\n                .build();
        sharedPreferences = EncryptedSharedPreferences.create(
                context,
                SHARED_PREFS_FILE,
                masterKey,
                EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
                EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        );
    }

    public void putString(String key, String value) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }
}
