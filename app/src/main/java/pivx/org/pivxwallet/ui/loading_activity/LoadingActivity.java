package pivx.org.pivxwallet.ui.loading_activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import pivx.org.pivxwallet.PivxApplication;
import pivx.org.pivxwallet.R;
import pivx.org.pivxwallet.ui.base.BaseActivity;
import pivx.org.pivxwallet.ui.start_activity.StartActivity;
import pivx.org.pivxwallet.ui.wallet_activity.WalletActivity;

public class LoadingActivity extends AppCompatActivity {

    /** Duration of wait **/
    private final int SPLASH_DISPLAY_LENGTH = 20000;
    private boolean ispaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_loading);
        final Runnable r = new Runnable() {
            public void run() {
                jump();
            }
        };

        new Handler().postDelayed(r, SPLASH_DISPLAY_LENGTH);

    }


    private void jump() {

        if (PivxApplication.getInstance().getAppConf().isAppInit()){
            Intent intent = new Intent(this, WalletActivity.class);
            startActivity(intent);
        }else {
            // Jump to your Next Activity or MainActivity
            Intent intent = new Intent(this, StartActivity.class);
            startActivity(intent);
        }
        finish();
    }


}
