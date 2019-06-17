package com.wd.tech.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<T extends BasePresenter> extends AppCompatActivity implements BaseView{
    public T presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int layout = setLayout();
        if (layout != 0) {
            setContentView(layout);
            presenter = getPresenter();
            if (presenter != null) {
                presenter.BasePresenter(this);

            }

        }
    }

    protected abstract int setLayout();

    protected abstract T getPresenter();

    protected abstract void initView();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDestroys();
        }
    }
}
