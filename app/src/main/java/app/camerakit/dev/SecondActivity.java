package app.camerakit.dev;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import jpegkit.Jpeg;
import jpegkit.JpegImageView;

public class SecondActivity extends AppCompatActivity {

    Button button;
    private JpegImageView jpegImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button = findViewById(R.id.button);
        jpegImageView = findViewById(R.id.image);
        final Jpeg jpeg = (Jpeg) getIntent().getParcelableExtra("parcel_data");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        jpegImageView.post(new Runnable() {
            @Override
            public void run() {
                jpegImageView.setJpeg(jpeg);
                jpeg.release();
            }
        });

    }
}
