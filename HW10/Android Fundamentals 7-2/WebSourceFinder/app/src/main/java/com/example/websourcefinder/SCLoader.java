package com.example.websourcefinder;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class SCLoader extends AsyncTaskLoader<String> {

    private String mQueryString;
    private String mTransferProtocol;
    Context mContext;

    public SCLoader(@NonNull Context context, String queryString, String transferProtocol) {
        super(context);
        mContext = context;
        mQueryString = queryString;
        mTransferProtocol = transferProtocol;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetUtil.getSourceCode(mContext, mQueryString, mTransferProtocol);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
