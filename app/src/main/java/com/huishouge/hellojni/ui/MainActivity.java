package com.huishouge.hellojni.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.huishouge.hellojni.R;
import com.huishouge.hellojni.adapter.MyRecyclerViewAdapter;
import com.huishouge.hellojni.jni.JniUtil;
import com.huishouge.hellojni.util.ToastUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.CallBack {


    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initData();

        initRV();

        refreshRV();
    }

    private void refreshRV() {
        if (null != myRecyclerViewAdapter) {
            myRecyclerViewAdapter.setData(data);
            myRecyclerViewAdapter.notifyDataSetChanged();
        }
    }

    private MyRecyclerViewAdapter myRecyclerViewAdapter;
    private List<String> data;

    private void initRV() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(linearLayoutManager);
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(this);
        rv.setAdapter(myRecyclerViewAdapter);
    }

    private JniUtil jniUtil;

    private void initData() {
        data = new ArrayList<String>();
        data.add(getString(R.string.jni_test));
        data.add(getString(R.string.jni_int_add));
//        data.add(getString(R.string.des_encryption));
//        data.add(getString(R.string.md5_encryption));
//        data.add(getString(R.string.base64_encryption));
//        data.add(getString(R.string.yh_encryption));

        jniUtil = new JniUtil();

    }

    @Override
    public void rVOnItemClick(int position) {
        if (null != myRecyclerViewAdapter) {
            String str = myRecyclerViewAdapter.getItem(position);
            if (!TextUtils.isEmpty(str)) {
                if (str.equals(getString(R.string.jni_test))) {
                    ToastUtils.show(this, jniUtil.helloFromC());
                } else if (str.equals(getString(R.string.jni_int_add))) {
                    ToastUtils.show(this, "1+2=" + jniUtil.add(1, 2));
                }
//                else if (str.equals(getString(R.string.md5_encryption))) {
////                    startActivity(new Intent(MainActivity.this,RSAEncryptionActivity.class));
//                }
            }
        }
    }

}
