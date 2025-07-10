package com.example.myapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthProvider

@Composable
fun OTPScreen(
    verificationId: String,
    onVerified: () -> Unit
) {
    val context = LocalContext.current
    var otpCode by remember { mutableStateOf("") }
    var isVerifying by remember { mutableStateOf(false) }

    Surface(
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
                text = "Enter OTP",
                style = MaterialTheme.typography.headlineSmall,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = otpCode,
                onValueChange = { otpCode = it },
                label = { Text("OTP") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (otpCode.length >= 6) {
                        isVerifying = true
                        val credential = PhoneAuthProvider.getCredential(verificationId, otpCode)
                        FirebaseAuth.getInstance().signInWithCredential(credential)
                            .addOnCompleteListener { task ->
                                isVerifying = false
                                if (task.isSuccessful) {
                                    onVerified()
                                } else {
                                    Toast.makeText(context, "Verification failed", Toast.LENGTH_SHORT).show()
                                }
                            }
                    } else {
                        Toast.makeText(context, "Enter valid OTP", Toast.LENGTH_SHORT).show()
                    }
                },
                enabled = !isVerifying,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                Text(text = if (isVerifying) "Verifying..." else "Verify")
            }
        }
    }
}
