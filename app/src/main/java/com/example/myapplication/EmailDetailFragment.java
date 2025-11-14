package com.example.myapplication;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class EmailDetailFragment extends Fragment {

    public static EmailDetailFragment newInstance(Email email) {
        EmailDetailFragment fragment = new EmailDetailFragment();
        Bundle args = new Bundle();
        args.putString("sender", email.getSender());
        args.putString("subject", email.getSubject());
        args.putString("content", email.getContent());
        args.putString("date", email.getDate());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_email_detail, container, false);

        if (getArguments() != null) {
            TextView senderText = view.findViewById(R.id.detail_sender);
            TextView subjectText = view.findViewById(R.id.detail_subject);
            TextView contentText = view.findViewById(R.id.detail_content);
            TextView dateText = view.findViewById(R.id.detail_date);

            senderText.setText(getArguments().getString("sender"));
            subjectText.setText(getArguments().getString("subject"));
            contentText.setText(getArguments().getString("content"));
            dateText.setText(getArguments().getString("date"));
        }

        return view;
    }
}

