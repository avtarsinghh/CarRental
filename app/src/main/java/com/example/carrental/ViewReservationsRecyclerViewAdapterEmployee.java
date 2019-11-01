package com.example.carrental;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Map;

public class ViewReservationsRecyclerViewAdapterEmployee extends RecyclerView.Adapter<ViewReservationsRecyclerViewAdapterEmployee.ViewHolder> {
    LayoutInflater layoutInflater;
    Context context;
    Map<String, Transaction> transactionMap;
    ArrayList<String> arrayList;

    TransactionRepository transactionRepository;

    public ViewReservationsRecyclerViewAdapterEmployee(Context context, Map<String, Transaction> transactionMap) {
        this.context = context;
        this.transactionMap = transactionMap;
        this.layoutInflater = LayoutInflater.from(context);
        arrayList = new ArrayList<>(transactionMap.keySet());
        transactionRepository =  TransactionRepository.getInstance();
    }

    @NonNull
    @Override
    public ViewReservationsRecyclerViewAdapterEmployee.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.reservation_list_employee, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.tvLicense.setText(transactionMap.get(arrayList.get(position)).vehicle.licencePlate);
        if ((transactionMap.get(arrayList.get(position)).rental.startDate) != null) {
            holder.tvStartDate.setText(transactionMap.get(arrayList.get(position)).rental.startDate);
            holder.tvEndDate.setText(transactionMap.get(arrayList.get(position)).rental.endDate);
        }

        if ((transactionMap.get(arrayList.get(position)).reservation.startDate) != null) {
            holder.tvStartDate.setText(transactionMap.get(arrayList.get(position)).reservation.startDate);
            holder.tvEndDate.setText(transactionMap.get(arrayList.get(position)).reservation.endDate);
        }
        holder.tvModel.setText(transactionMap.get(arrayList.get(position)).vehicle.model);
        holder.tvBrand.setText(transactionMap.get(arrayList.get(position)).vehicle.brand);
        holder.tvReturn.setText(transactionMap.get(arrayList.get(position)).returnDate);

        holder.btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transactionRepository.removeTransaction(arrayList.get(position));
                transactionMap.remove(arrayList.get(position));
                notifyItemRangeChanged(position, transactionMap.size());
                arrayList.remove(position);
                notifyDataSetChanged();
                Toast.makeText(context, "Reservation Cancelled successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return transactionMap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBrand, tvModel, tvStartDate, tvEndDate, tvLicense, tvReturn;
        Button btnCancel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvBrand = itemView.findViewById(R.id.tvBrandReservationListEmployee);
            tvModel = itemView.findViewById(R.id.tvModelReservationListEmployee);
            tvStartDate = itemView.findViewById(R.id.tvStartDateReservationListEmployee);
            tvEndDate = itemView.findViewById(R.id.tvEndDateReservationListEmployee);
            tvLicense = itemView.findViewById(R.id.tvLicenseReservationListEmployee);
            tvReturn = itemView.findViewById(R.id.tvReturnReservationListEmployee);
            btnCancel = itemView.findViewById(R.id.btnCancelReservationEmployee);
        }
    }
}
