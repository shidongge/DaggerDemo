package us.mifeng.daggerdemo.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;
import javax.inject.Inject;
import dagger.Component;
import dagger.Module;
import dagger.Provides;
import us.mifeng.daggerdemo.R;
import us.mifeng.daggerdemo.persinter.imp.LoginPersinter;
import us.mifeng.daggerdemo.persinter.imp.LoginPersinterImp;
import us.mifeng.daggerdemo.view.MyView;

public class MainActivity extends AppCompatActivity implements MyView{
    @Inject
    LoginPersinterImp loginPersinter;

    private EditText mEt2;
    private EditText mEt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEt1 = (EditText) findViewById(R.id.mEt1);
        mEt2 = (EditText) findViewById(R.id.mEt2);
        DaggerMainActivity_MyConpoment.builder()
                .myModule(new MyModule(this))
                .build()
                .inject(this);
        loginPersinter.Login(mEt1,mEt2);
    }


    @Override
    public void inSuccess() {
        startActivity(new Intent(MainActivity.this,BActivity.class));
    }

    @Override
    public void inErroy() {
        Toast.makeText(this, "账号或密码错误", Toast.LENGTH_SHORT).show();
    }

    @Module
    public class MyModule{
        private MyView view;

        public MyModule(MyView view){
            this.view=view;
        }

        @Provides
        MyView provideMyView(){
            return view;
        }
    }

    @Component(modules = MyModule.class)
    public interface MyConpoment{
        void inject(MainActivity main);
    }
}
