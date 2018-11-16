package com.medandevelop.mvpdesignpatternvalidation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.medandevelop.mvpdesignpatternvalidation.Presenter.ILoginPresenter;
import com.medandevelop.mvpdesignpatternvalidation.Presenter.LoginPresenter;
import com.medandevelop.mvpdesignpatternvalidation.View.ILoginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginView {
    EditText edt_email,edt_password;
    Button btn_login;
    ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //init view
        btn_login =(Button) findViewById(R.id.btn_login);
        edt_email = (EditText) findViewById(R.id.edt_email);
        edt_password = (EditText) findViewById(R.id.edt_password);
        //init
        loginPresenter = new LoginPresenter(this);
        //event
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLogin(edt_email.getText().toString(),edt_password.getText().toString());
            }
        });
    }

    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(this,message,Toast.LENGTH_SHORT).show();
    }
}
