package com.example.modernartui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SeekBar seekBar1;
    View view1,view2,view3,view4,view5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        onclick();
    }

    private void Anhxa() {
        seekBar1 = findViewById(R.id.seekbar);
        view1 = findViewById(R.id.view1);
        view2 = findViewById(R.id.view2);
        view3 = findViewById(R.id.view3);
        view4 = findViewById(R.id.view4);
        view5 = findViewById(R.id.view5);
    }

    private void onclick() {
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                view1.setBackgroundColor((Color.rgb(23 - progress, 200 + progress, 99 + progress)));
                view2.setBackgroundColor(Color.rgb(255, 133 + progress, 144 - progress));
                view3.setBackgroundColor((Color.rgb(88 + progress, 200 - progress, 177 + progress)));
                view4.setBackgroundColor(Color.rgb(230, 56 + progress, 233 - progress));
                view5.setBackgroundColor(Color.rgb(0, 100 + progress, 300 - progress));
                seekBar.invalidate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu1:
                dialog();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void dialog() {
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        b.setMessage("Lấy cảm hứng từ các tác phẩm của Piet Mondrian"+"\n"+
                "Nhấp vào bên dưới để tìm hiểu thêm!")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Uri uri = Uri.parse("https://www.moma.org/");
                        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // User cancelled the dialog
                    }
                });
        b.create().show();
    }
}