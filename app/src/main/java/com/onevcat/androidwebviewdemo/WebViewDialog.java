package com.onevcat.androidwebviewdemo;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

public class WebViewDialog extends Dialog {

    public String url;

    private FrameLayout _content;
    private WebView _webView;

    public WebViewDialog(Context context) {
        super(context, android.R.style.Theme_Holo_NoActionBar);

        Window window = this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        createContent();
        createWebView();

        addContentView(this._content,
                new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        this._content.addView(this._webView);
    }

    private void createWebView() {
        _webView = new WebView(getContext());

        WebViewClient webClient = new WebViewClient() {

        };

        _webView.setWebViewClient(webClient);

        WebChromeClient chromeClient = new WebChromeClient() {

        };
        _webView.setWebChromeClient(chromeClient);

        WebSettings settings = _webView.getSettings();
        settings.setJavaScriptEnabled(true);
    }

    private void createContent() {
        this._content = new FrameLayout(getContext());
        this._content.setVisibility(View.VISIBLE);
    }

    public void showMe() {
        _webView.loadUrl(url);
        show();
    }
}
