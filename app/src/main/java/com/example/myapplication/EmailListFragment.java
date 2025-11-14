package com.example.myapplication;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class EmailListFragment extends Fragment {
    private EmailAdapter adapter;
    private List<Email> emails;
    private EmailAdapter.OnEmailClickListener listener;

    public void setOnEmailClickListener(EmailAdapter.OnEmailClickListener listener) {
        this.listener = listener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_email_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.email_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        emails = createSampleEmails();
        adapter = new EmailAdapter(emails, email -> {
            if (listener != null) {
                listener.onEmailClick(email);
            }
        });

        recyclerView.setAdapter(adapter);
        return view;
    }

    private List<Email> createSampleEmails() {
        List<Email> emails = new ArrayList<>();
        emails.add(new Email("Иван Петров", "Важное обновление", "Уважаемые пользователи, мы хотим сообщить о важном обновлении...", "10:30"));
        emails.add(new Email("Мария Сидорова", "Приглашение на встречу", "Приглашаем вас на встречу завтра в 15:00 в конференц-зале.", "Вчера"));
        emails.add(new Email("Команда поддержки", "Подтверждение регистрации", "Ваша регистрация успешно завершена. Добро пожаловать!", "Пн"));
        emails.add(new Email("Алексей Иванов", "Отчет по проекту", "Прилагаю отчет по проекту за последний квартал.", "Пн"));
        emails.add(new Email("Служба безопасности", "Обновление политики безопасности", "Просим ознакомиться с новой политикой безопасности.", "Вс"));
        return emails;
    }
}

