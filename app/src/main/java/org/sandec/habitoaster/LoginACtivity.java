package org.sandec.habitoaster;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import io.fabric.sdk.android.Fabric;

public class LoginACtivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

private static final String TAG = "AuthenticationActivity";
private static final int RC_SIGN_IN = 9002;
private SignInButton mSignInButton;
private GoogleApiClient mGoogleApiClient;
private FirebaseAuth mAuth;
private FirebaseAuth.AuthStateListener mAuthListener;

@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_login);

    YoYo.with(Techniques.FadeIn)
            .duration(4000)
            .playOn(findViewById(R.id.fbs));


    //TODO 4: Authentication
    //1
    GoogleSignInOptions gso =
            new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.default_web_client_id))
                    .requestEmail()
                    .build();

    //tambah sendiri setelah 1
    mGoogleApiClient = new GoogleApiClient.Builder(LoginACtivity.this)
            .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
            .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
            .build();

    //2
    mAuth = FirebaseAuth.getInstance();

    //3
    mAuthListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user != null) {
                // User is signed in
                Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());

                masukAplikasiUtama();
            } else {
                // User is signed out
                Log.d(TAG, "onAuthStateChanged:signed_out");

//                Toast.makeText(login.this, "Anda Belum login.",
//                        Toast.LENGTH_SHORT).show();

                Toast.makeText(LoginACtivity.this, "Anda Belum LoginACtivity.",
                        Toast.LENGTH_SHORT).show();

            }
            // ...
        }
    };

    //4
    mSignInButton = (SignInButton) findViewById(R.id.sign_in_button);
    mSignInButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            signIn();
        }
    });

}

    //5
    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi
                .getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    //6
    //ctrl + o , pilih onActivityResult
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi
                    .getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                //jika LoginACtivity google sukses, maka daftarkan ke firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);
            } else {
                // LoginACtivity gagal
                Log.e(TAG, "Login Google Gagal.");
                Toast.makeText(this, "Login Google Gagal.", Toast.LENGTH_SHORT).show();
            }
        }
    }


    //lanjutan 2
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    //8
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        AuthCredential credential = GoogleAuthProvider
                .getCredential(acct.getIdToken(), null);
        Log.d(TAG, "firebaseAuthWithGoogle: "+ credential.toString());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //jika LoginACtivity gagal akan muncul pesan gagal
                        // jika sukses maka akan pindah ke MainActivity
                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginACtivity.this, "Authentication failed. "+task.getException(),
                                    Toast.LENGTH_SHORT).show();
                            Log.e(TAG, "onComplete: Failed ",task.getException());
                        } else {
                            Toast.makeText(LoginACtivity.this, "Authentication success.",
                                    Toast.LENGTH_SHORT).show();
                            masukAplikasiUtama();
                        }
                    }
                });
    }

    //lanjutan 3
    private void masukAplikasiUtama() {
        startActivity(new Intent(LoginACtivity.this, MainActivity.class));
        finish();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Toast.makeText(this, "Google Play Services error.", Toast.LENGTH_SHORT).show();
    }

}


