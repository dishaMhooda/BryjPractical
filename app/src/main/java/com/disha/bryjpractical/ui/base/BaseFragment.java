package com.disha.bryjpractical.ui.base;

import android.webkit.WebView;

import androidx.fragment.app.Fragment;

import com.disha.bryjpractical.ui.custom.CustomWebView;
import com.disha.bryjpractical.ui.listeners.ILoadedListener;

public class BaseFragment extends Fragment {

    public void setListenerAndWebView(ILoadedListener iLoadedListener, WebView webView , String url){
        CustomWebView webView1 = new CustomWebView();
        webView1.setListener(iLoadedListener);
        webView.setWebViewClient(webView1);
        webView.loadUrl(url);
    }
}
