package com.disha.bryjpractical.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.disha.bryjpractical.R;
import com.disha.bryjpractical.ui.base.BaseFragment;
import com.disha.bryjpractical.ui.listeners.ILoadedListener;
import com.disha.bryjpractical.util.Constants;


public class BagFragment extends BaseFragment {

    WebView webView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_bag,
                container, false);
         webView = (WebView) rootView.findViewById(R.id.wbSample);

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        setListenerAndWebView((ILoadedListener) getActivity(),webView, Constants.BAG_URL);
        return rootView;

    }

}
