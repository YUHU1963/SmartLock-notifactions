package com.example.smartlock;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class NotificationFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewNotifications);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        List<CustomNotification> notificationList = new ArrayList<>();
        notificationList.add(new CustomNotification("Motion detected at the front door at 7:45 AM", false));
        notificationList.add(new CustomNotification("Door unlocked by Jane Doe at 9:15 AM", false));
        notificationList.add(new CustomNotification("Failed unlock attempt at 10:20 PM - incorrect PIN entered", true));
        notificationList.add(new CustomNotification("Auto-lock enabled – door locked at 10:00 PM", false));
        notificationList.add(new CustomNotification("Door unlocked by Jane Doe at 11:15 PM", false));


        NotificationAdapter adapter = new NotificationAdapter(notificationList);
        recyclerView.setAdapter(adapter);

        return view;
    }
}

