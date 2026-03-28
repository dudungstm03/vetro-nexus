package com.vetro.nexus.data.remote

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await

class FirebaseRepository {
    private val database: DatabaseReference = FirebaseDatabase.getInstance().reference

    // Method to save user settings
    suspend fun saveUserSettings(userId: String, settings: Map<String, Any>) {
        database.child("user_settings").child(userId).setValue(settings).await()
    }

    // Method to retrieve user settings
    suspend fun getUserSettings(userId: String): Map<String, Any>? {
        return database.child("user_settings").child(userId).get().await().getValue(Map::class.java) as? Map<String, Any>
    }

    // Method to save crosshair configuration
    suspend fun saveCrosshairConfig(userId: String, config: Map<String, Any>) {
        database.child("crosshair_config").child(userId).setValue(config).await()
    }

    // Method to retrieve crosshair configuration
    suspend fun getCrosshairConfig(userId: String): Map<String, Any>? {
        return database.child("crosshair_config").child(userId).get().await().getValue(Map::class.java) as? Map<String, Any>
    }
}