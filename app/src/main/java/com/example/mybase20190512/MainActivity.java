package com.example.mybase20190512;

import androidx.annotation.Nullable;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mybase20190512.base.BaseActivity;
import com.example.mybase20190512.net.rx.RxHelper;
import com.example.mybase20190512.net.rx.RxRestClient;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BaseActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onBindView(@Nullable Bundle savedInstanceState) {
        final String url = "http://ha.doov.com.cn:9066//address/query?AppEnv=system:android,version:8.1.0&QueryIMEI=358240051111110&Latitude=22.53&QueryIP=192.168.232.2&ClientVersion=3.1.4&Longitude=114.03&AppID=AppStore&Sign=1glihU9DPWee+UJ82u3+mw3Bdnr9u01at0M/xJnPsGuHh+JA5bk3zbWaoWhU6GmLab3dIM4JNdktTcEUI9/FBGhgfLO39BKX/eBCFQ3bXAmIZn4l26fiwoO613BptT44GTEtnPiQ6+tnLsGlVSrFZaLB9FVhrGfipH2SWJcnwYs=&PayProvider=0&MobileType=generic_x86&QueryMobile=15555215554&Accounts=StoreAccount&SignType=RSA";
        RxRestClient.builder()
                .url(url)
                .build()
                .get()
                .compose(RxHelper.io_main(this))
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@io.reactivex.annotations.NonNull String s) {
                        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(@io.reactivex.annotations.NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
