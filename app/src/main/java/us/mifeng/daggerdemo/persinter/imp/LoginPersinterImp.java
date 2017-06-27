package us.mifeng.daggerdemo.persinter.imp;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import javax.inject.Inject;

import us.mifeng.daggerdemo.view.MyView;

/**
 * Created by shido on 2017/6/27.
 */

public class LoginPersinterImp implements LoginPersinter {
    private MyView myView;

    @Inject
    LoginPersinterImp(MyView myView){
        this.myView=myView;
    }

    @Override
    public void Login(final EditText etu, final EditText etp) {
        etu.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String username = s.toString();
                if (!TextUtils.isEmpty(username)){
                }else {
                    myView.inErroy();
                }
            }
        });
        etp.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String password = s.toString();
                if (!TextUtils.isEmpty(password)){
                    if ("username".equals(etu.getText().toString().trim())&&
                            "password".equals(password)){
                        myView.inSuccess();
                    }else {
                        myView.inErroy();
                    }
                }else {
                    myView.inErroy();
                }
            }
        });
    }
}
