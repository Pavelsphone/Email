package com.example.myapplication;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity
        implements EmailAdapter.OnEmailClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            EmailListFragment listFragment = new EmailListFragment();
            listFragment.setOnEmailClickListener(this);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.email_list_container, listFragment)
                    .commit();
        }
    }

    @Override
    public void onEmailClick(Email email) {
        EmailDetailFragment detailFragment = EmailDetailFragment.newInstance(email);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.email_detail_container, detailFragment);
        transaction.commit();
    }
}
