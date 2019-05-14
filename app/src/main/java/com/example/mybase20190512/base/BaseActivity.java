package com.example.mybase20190512.base;

import android.os.Bundle;
import androidx.annotation.Nullable;

import com.trello.rxlifecycle3.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends RxAppCompatActivity {

    protected abstract int getLayoutId();
    protected abstract void onBindView(@Nullable Bundle savedInstanceState);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        onBindView(savedInstanceState);
    }
}
