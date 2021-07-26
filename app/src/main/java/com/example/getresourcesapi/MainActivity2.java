package com.example.getresourcesapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity2 extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private RelativeLayout mRelativeLayout;
    private TextView mTvName, mTvYear, mTvPantone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initViews();
        int postId = getIntent().getIntExtra("number",-1);
        callApi(postId);

    }

    private void callApi(int postId) {
        ApiService apiService = Network.getInstance().create(ApiService.class);
        apiService.getUser(postId).enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                ResponseDTO model = response.body();
                mTvName.setText(model.getData().getName());
                mTvYear.setText(model.getData().getYear() + "");
                mTvPantone.setText(model.getData().getPantoneValue());
                mProgressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {

            }
        });
    }

    private void initViews() {
        mProgressBar = findViewById(R.id.progressBar);
        mRelativeLayout = findViewById(R.id.relativeLayout);
        mTvName = findViewById(R.id.tvName);
        mTvYear = findViewById(R.id.tvYear);
        mTvPantone = findViewById(R.id.tvPantoneValue);

    }
}