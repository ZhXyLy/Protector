package ai.hou.protector;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

public class ProtectorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = new View(this);
        //1像素
        view.setLayoutParams(new ViewGroup.LayoutParams(1, 1));
        setContentView(view);

        startService(new Intent(this, ClockService.class));
    }
}
