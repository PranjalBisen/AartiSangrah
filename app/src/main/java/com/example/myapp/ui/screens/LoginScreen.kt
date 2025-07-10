package com.example.myapp.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.core.app.ComponentActivity
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

@Composable
fun LoginScreen(
    activity: ComponentActivity,
    onCodeSent: (String) -> Unit
) {
    val context = LocalContext.current
    var phoneNumber by remember { mutableStateOf("") }
    var isSending by remember { mutableStateOf(false) }

    Surface( // This applies themed background
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Login with Phone",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = { Text("Phone Number") },
                placeholder = { Text("+91XXXXXXXXXX") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Phone,
                    imeAction = ImeAction.Done
                ),
                visualTransformation = VisualTransformation.None,
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (phoneNumber.length >= 10) {
                        isSending = true
                        val fullNumber = if (phoneNumber.startsWith("+")) phoneNumber else "+91$phoneNumber"
                        val options = PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance())
                            .setPhoneNumber(fullNumber)
                            .setTimeout(60L, TimeUnit.SECONDS)
                            .setActivity(activity)
                            .setCallbacks(object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                override fun onVerificationCompleted(credential: PhoneAuthCredential) {}

                                override fun onVerificationFailed(e: FirebaseException) {
                                    isSending = false
                                    Toast.makeText(context, "Verification failed: ${e.message}", Toast.LENGTH_LONG).show()
                                }

                                override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
                                    isSending = false
                                    onCodeSent(verificationId)
                                }
                            })
                            .build()
                        PhoneAuthProvider.verifyPhoneNumber(options)
                    } else {
                        Toast.makeText(context, "Please enter a valid phone number", Toast.LENGTH_SHORT).show()
                    }
                },
                enabled = !isSending,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(text = if (isSending) "Sending..." else "Send OTP")
            }
        }
    }
}
