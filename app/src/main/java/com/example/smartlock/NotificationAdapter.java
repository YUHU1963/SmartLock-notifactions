package com.example.smartlock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.smartlock.R;
import com.example.smartlock.CustomNotification;
import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.ViewHolder> {

    private List<CustomNotification> notificationList;

    public NotificationAdapter(List<CustomNotification> notificationList) {
        this.notificationList = notificationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notification, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CustomNotification notification = notificationList.get(position);
        holder.contentTextView.setText(notification.getContent());

        if (notification.isError()) {
            holder.itemView.setBackgroundResource(R.drawable.notification_background_error);
        } else {
            holder.itemView.setBackgroundResource(R.drawable.notification_background);
        }
    }

    @Override
    public int getItemCount() {
        return notificationList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView contentTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contentTextView = itemView.findViewById(R.id.contentTextView);
        }
    }
}
