package org.sandec.habitoaster;

import android.app.ProgressDialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

import org.sandec.habitoaster.utils.Logger;

public class BaseActivity extends AppCompatActivity {

    private ProgressDialog mProgressDialog;

    //region Activity Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Logger.debug(getClass().getSimpleName(), "onCreate: is called.");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onRestart() {
        Logger.debug(getClass().getSimpleName(), "onRestart: is called.");
        super.onRestart();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Logger.debug(getClass().getSimpleName(), "onRestoreInstanceState: is called.");
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        Logger.debug(getClass().getSimpleName(), "onStart: is called.");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Logger.debug(getClass().getSimpleName(), "onResume: is called.");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Logger.debug(getClass().getSimpleName(), "onPause: is called.");
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Logger.debug(getClass().getSimpleName(), "onSaveInstanceState: is called.");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStop() {
        Logger.debug(getClass().getSimpleName(), "onSTop: is called.");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Logger.debug(getClass().getSimpleName(), "onDestroy: is called.");
        super.onDestroy();
    }
    //endregion

    //region Common Callback methods
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Logger.debug(getClass().getSimpleName(), "onConfigurationChanged: is called.");
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        Logger.debug(getClass().getSimpleName(), "onBackPressed: is called.");
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Logger.debug(getClass().getSimpleName(), "onCreateOptionsMenu: is called.");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Logger.debug(getClass().getSimpleName(), "onPrepareOptionsMenu: is called.");
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Logger.debug(getClass().getSimpleName(), "onOptionsItemSelected: " + item.getTitle() + " is called.");
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        Logger.debug(getClass().getSimpleName(), "onTitleChanged: " + title + " is called.");
        super.onTitleChanged(title, color);
    }

    @Override
    public void onContentChanged() {
        Logger.debug(getClass().getSimpleName(), "onContentChanged: is called.");
        super.onContentChanged();
    }

    @Override
    public void onSupportActionModeStarted(@NonNull ActionMode mode) {
        Logger.debug(getClass().getSimpleName(), "onSupportActionModeStarted: is called.");
        super.onSupportActionModeStarted(mode);
    }

    @Override
    public void onSupportActionModeFinished(@NonNull ActionMode mode) {
        Logger.debug(getClass().getSimpleName(), "onSupportActionModeFinished: is called.");
        super.onSupportActionModeFinished(mode);
    }

    @Nullable
    @Override
    public ActionMode onWindowStartingSupportActionMode(@NonNull ActionMode.Callback callback) {
        Logger.debug(getClass().getSimpleName(), "onWindowsStartingSupportActionMode: is called.");
        return super.onWindowStartingSupportActionMode(callback);
    }

    @Override
    public void onCreateSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        Logger.debug(getClass().getSimpleName(), "onCreateSupportNavigateUpTaskStack: is called.");
        super.onCreateSupportNavigateUpTaskStack(builder);
    }

    @Override
    public void onPrepareSupportNavigateUpTaskStack(@NonNull TaskStackBuilder builder) {
        Logger.debug(getClass().getSimpleName(), "onPrepareSupportNavigateUpStack: is called.");
        super.onPrepareSupportNavigateUpTaskStack(builder);
    }

    @Override
    public boolean onSupportNavigateUp() {
        Logger.debug(getClass().getSimpleName(), "onSupportNavigateUp: is called.");
        return super.onSupportNavigateUp();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        Logger.debug(getClass().getSimpleName(), "onPostCreate: is called.");
        super.onPostCreate(savedInstanceState);
    }

    @Override
    protected void onPostResume() {
        Logger.debug(getClass().getSimpleName(), "onPostResume: is called.");
        super.onPostResume();
    }

    @Override
    public boolean onMenuOpened(int featureId, Menu menu) {
        Logger.debug(getClass().getSimpleName(), "onPostResume: " + featureId + " is called.");
        return super.onMenuOpened(featureId, menu);
    }

    @Override
    public void onPanelClosed(int featureId, Menu menu) {
        Logger.debug(getClass().getSimpleName(), "onPanelClosed: " + featureId + " is called.");
        super.onPanelClosed(featureId, menu);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Logger.debug(getClass().getSimpleName(), "onKeyDown: " + keyCode + " is called.");
        return super.onKeyDown(keyCode, event);
    }
    //endregion

    //region Progress dialog
    public void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setCancelable(false);
            mProgressDialog.setMessage("Loading...");
        }

        mProgressDialog.show();
    }

    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
    //endregion

    //region Firebase
    public String getUid() {
        return FirebaseAuth.getInstance().getCurrentUser().getUid();
    }
    //endregion
}
