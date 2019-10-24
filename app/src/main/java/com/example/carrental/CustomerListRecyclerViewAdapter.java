package com.example.carrental;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CustomerListRecyclerViewAdapter extends RecyclerView.Adapter<CustomerListRecyclerViewAdapter.ViewHolder> {
    LayoutInflater layoutInflater;
    Context context;
    Map<String, User> users;
    UserRepository userRepository;
    ArrayList<String> uNames;

    public CustomerListRecyclerViewAdapter(Context context, Map<String, User> users){
        this.context = context;
        this.users = users;
        layoutInflater = LayoutInflater.from(context);
        userRepository = UserRepository.getInstance();
        uNames = new ArrayList<>(users.keySet());
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.customer_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.tvUserName.setText(uNames.get(position));
        holder.tvName.setText(users.get(uNames.get(position)).firstName+" "+users.get(uNames.get(position)).lastName);
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = holder.tvUserName.getText().toString().toLowerCase();
                userRepository.deleteUser(userName);
                users = userRepository.getUsers();
                uNames.remove(userName);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, users.size());
                notifyDataSetChanged();
            }
        });

        holder.btnModify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvName, tvUserName;
        Button btnDelete, btnModify;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvNameCustomerList);
            tvUserName = itemView.findViewById(R.id.tvUserNameCustomerList);
            btnDelete = itemView.findViewById(R.id.btnDeleteCustomerList);
            btnModify = itemView.findViewById(R.id.btnModifyCustomerList);
        }
    }
}
