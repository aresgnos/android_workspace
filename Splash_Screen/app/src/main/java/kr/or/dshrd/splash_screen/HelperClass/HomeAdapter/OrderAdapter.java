package kr.or.dshrd.splash_screen.HelperClass.HomeAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import kr.or.dshrd.splash_screen.R;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.OrderViewHolder> {

    // 배열 선언
    ArrayList<OrderHelperClass> orderLocation;

    public OrderAdapter(ArrayList<OrderHelperClass> orderLocation) {
        this.orderLocation = orderLocation;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_card_design,parent,false);
        OrderViewHolder orderViewHolder = new OrderViewHolder(view);

        return orderViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {

        OrderHelperClass orderHelperClass = orderLocation.get(position);

        // 담아놓는 역할
        holder.image.setImageResource(orderHelperClass.getImage());
        holder.title.setText(orderHelperClass.getTitle());
        holder.desc.setText(orderHelperClass.getDescription());


    }

    @Override
    public int getItemCount() {
        return orderLocation.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, desc;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);

            // hooks
            image = itemView.findViewById(R.id.order_image);
            title = itemView.findViewById(R.id.order_title);
            desc = itemView.findViewById(R.id.order_desc);


        }
    }
}
