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

public class ProAdapter extends RecyclerView.Adapter<ProAdapter.ProViewHolder> {

    // 배열 선언
    ArrayList<OrderHelperClass> proLocation;

    public ProAdapter(ArrayList<OrderHelperClass> proLocation) {
        this.proLocation = proLocation;
    }

    @NonNull
    @Override
    public ProViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pro_card_design,parent,false);
        ProViewHolder proViewHolder = new ProViewHolder(view);

        return proViewHolder;
    }

    @Override
    public void  onBindViewHolder(@NonNull ProViewHolder holder, int position) {

        OrderHelperClass orderHelperClass = proLocation.get(position);

        // 담아놓는 역할
        holder.image.setImageResource(orderHelperClass.getImage());
        holder.title.setText(orderHelperClass.getTitle());
        holder.desc.setText(orderHelperClass.getDescription());


    }

    @Override
    public int getItemCount() {

        return proLocation.size();
    }

    public static class ProViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView title, desc;

        public ProViewHolder(@NonNull View itemView) {
            super(itemView);

            // hooks
            image = itemView.findViewById(R.id.pro_image);
            title = itemView.findViewById(R.id.pro_tit);
            desc = itemView.findViewById(R.id.pro_desc);


        }
    }
}
