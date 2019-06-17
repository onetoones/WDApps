package com.wd.tech.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment<T extends BasePresenter> extends Fragment implements BaseView {
    private boolean isInitView = false;
    private View views;
    public  T presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int layout = getLayout();
        if (0 != layout) {
            views = View.inflate(getActivity(), layout, null);
             presenter = getPresenter();
            if (presenter!=null){
                presenter.BasePresenter(this);
        }
        }
        return views;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        isInitView = true;//视图创建完成，状态改为true
        if (getUserVisibleHint()) {//Fragment可见进行数据加载
            initDate();
            isInitView = false;
        }
        bindEvent();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isInitView && isVisibleToUser) {//视图变为可见并且是第一次加载
            initDate();
            isInitView = false;
        }
    }
        //绑定监听
    protected abstract void bindEvent();

    protected abstract void initDate();

    protected abstract void initView();

    protected abstract int getLayout();

    protected abstract T getPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        presenter.onDestroys();
    }
}
