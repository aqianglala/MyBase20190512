package com.example.mybase20190512.base;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle3.components.support.RxFragment;

import butterknife.ButterKnife;

public abstract class BaseFragment extends RxFragment {

    public abstract Object setLayout();
    public abstract void onBindView(@Nullable Bundle savedInstanceState, @NonNull View rootView);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView;
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((int) setLayout(), container, false);
        } else if (setLayout() instanceof View) {
            rootView = (View) setLayout();
        } else {
            throw new ClassCastException("type of setLayout() must be int or View!");
        }
        ButterKnife.bind(this, rootView);
        onBindView(savedInstanceState, rootView);
        return rootView;
    }
}
