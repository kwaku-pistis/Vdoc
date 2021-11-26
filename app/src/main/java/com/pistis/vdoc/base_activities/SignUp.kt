package com.pistis.vdoc.base_activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.GoogleAuthProvider
import symptomsme.symptomsme.empsoft.projeto.symptomsme.R

class SignUp : AppCompatActivity() {

    private var googleBtn: SignInButton? = null
    private var mAuth: FirebaseAuth? = null
    private var mGoogleSignInClient: GoogleSignInClient? = null
    var mAuthListener: AuthStateListener? = null

    override fun onStart() {
        super.onStart()
        mAuthListener?.let { mAuth?.addAuthStateListener(it) }
        setGoogleBtnText(googleBtn)

        /*TextView textView = SignInButton.getChildAt(0);
        textView.setText("Sign In with Google");*/
    }

    protected fun setGoogleBtnText(googleBtn: SignInButton?) {
        //buttonText = "Sign In with Google";
        for (i in 0 until googleBtn!!.childCount) {
            val v = googleBtn.getChildAt(i)
            if (v is TextView) {
                v.text = "Sign In with Google"
                return
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        googleBtn = findViewById(R.id.googleBtn)
        mAuth = FirebaseAuth.getInstance()

        setGoogleBtnText(googleBtn)
        googleBtn?.setOnClickListener { signIn() }

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        /*mGoogleApiClient = GoogleApiClient.Builder(this)
            .enableAutoManage(this) {
                Toast.makeText(
                    this@SignUp,
                    "Something went wrong",
                    Toast.LENGTH_SHORT
                ).show()
            }
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build()*/

        mAuthListener = AuthStateListener { firebaseAuth ->
            if (firebaseAuth.currentUser != null) {
                val profile = Intent(this@SignUp, MainActivity::class.java)
                startActivity(profile)
            }
        }
    }

    private fun signIn() {
        val signInIntent = mGoogleSignInClient?.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)
                firebaseAuthWithGoogle(account)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
                // ...
            }
        }
    }

    private fun firebaseAuthWithGoogle(account: GoogleSignInAccount?) {
        val credential = GoogleAuthProvider.getCredential(account?.idToken, null)
        mAuth?.signInWithCredential(credential)
            ?.addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithCredential:success")
                    val user = mAuth!!.currentUser
                    //updateUI(user);
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    Snackbar.make(
                        findViewById(R.id.googleBtn),
                        "Authentication Failed.",
                        Snackbar.LENGTH_SHORT
                    ).show()
                    //updateUI(null);
                }

                // ...
            }
    }

    companion object {
        private const val RC_SIGN_IN = 2
        private val TAG: String = "TAG"
    }
}