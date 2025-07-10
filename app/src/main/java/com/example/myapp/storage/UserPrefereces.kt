package com.example.myapp.storage

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "user_prefs")

class UserPreferences(private val context: Context) {
    private val REMEMBER_ME_KEY = booleanPreferencesKey("remember_me")

    suspend fun setRememberMe(value: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[REMEMBER_ME_KEY] = value
        }
    }

    suspend fun getRememberMe(): Boolean {
        return context.dataStore.data
            .map { preferences -> preferences[REMEMBER_ME_KEY] ?: false }
            .first()
    }
}
