package com.example.myapplication;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class EmailAdapter extends RecyclerView.Adapter<EmailAdapter.EmailViewHolder> {
    private List<Email> emails;
    private OnEmailClickListener listener;

    public interface OnEmailClickListener {
        void onEmailClick(Email email);
    }

    public EmailAdapter(List<Email> emails, OnEmailClickListener listener) {
        this.emails = emails;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EmailViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_email, parent, false);
        return new EmailViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailViewHolder holder, int position) {
        Email email = emails.get(position);
        holder.senderText.setText(email.getSender());
        holder.subjectText.setText(email.getSubject());
        holder.dateText.setText(email.getDate());

        holder.itemView.setOnClickListener(v -> listener.onEmailClick(email));
    }

    @Override
    public int getItemCount() {
        return emails.size();
    }

    static class EmailViewHolder extends RecyclerView.ViewHolder {
        TextView senderText, subjectText, dateText;

        EmailViewHolder(@NonNull View itemView) {
            super(itemView);
            senderText = itemView.findViewById(R.id.sender_text);
            subjectText = itemView.findViewById(R.id.subject_text);
            dateText = itemView.findViewById(R.id.date_text);
        }
    }
}
