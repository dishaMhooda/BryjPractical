package com.disha.bryjpractical.ui.custom;

import android.graphics.Bitmap;
import android.webkit.WebResourceRequest;
import android.webkit.WebViewClient;

import com.disha.bryjpractical.ui.listeners.ILoadedListener;

public class CustomWebView extends WebViewClient  {

    public ILoadedListener iLoadedListener;
    public void setListener(ILoadedListener iLoadedListener){
        this.iLoadedListener = iLoadedListener;
    }

    @Override
    public boolean shouldOverrideUrlLoading(android.webkit.WebView view, WebResourceRequest request) {
        return super.shouldOverrideUrlLoading(view, request);
    }

    @Override
    public void onPageStarted(android.webkit.WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        iLoadedListener.onPageStarted();
    }

    @Override
    public void onPageFinished(android.webkit.WebView view, String url) {
        iLoadedListener.onPageLoaded();
    }
}
