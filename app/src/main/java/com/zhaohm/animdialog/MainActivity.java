package com.zhaohm.animdialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {
    private Button button_determine, button_cancel;      //定义对话框按钮
    private AlertDialog dlg;                               //定义对话框
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d("aa", "onKeyDown: bb");
        if (keyCode == KeyEvent.KEYCODE_BACK){
            dlg = new AlertDialog.Builder(this).create();
            dlg.show();
            Window window = dlg.getWindow();
            window.setGravity(Gravity.CENTER);
            window.setWindowAnimations(R.style.mystyle);
            window.setContentView(R.layout.dialog_layout);

            button_determine = (Button) window.findViewById(R.id.btn_determine);
            button_cancel = (Button) window.findViewById(R.id.btn_cancel);
            Log.d("aa", "onKeyDown: aa");
            initEvent();
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 该方法出事对话框中按钮的事件，单击确定按钮退出该应用
     * 单击取消按钮，对话框将移动至底部消失
     */
    private void initEvent() {
        button_determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();          //对话框移动到底部消失
                finish();               //关闭当前应用
            }
        });
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();          //对话框移动到底部消失
            }
        });
    }
}
