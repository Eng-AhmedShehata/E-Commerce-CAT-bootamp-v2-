//1
package com.ashehata.e_commerce;

//2

import android.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.MyViewHolder> {

    //3
    private List<Product> productList;

    //4
    public ProductsAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.root_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // 5
        Product product = productList.get(position);
        holder.title.setText(product.getTitle());
        holder.price.setText(product.getPrice() + "");
        Glide.with(holder.image.getContext()).load(product.getImage()).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                builder.setMessage(product.getTitle())
                        .setTitle(product.getDescription());
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        //6
        public TextView title;
        public TextView price;
        public CircleImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            price = itemView.findViewById(R.id.tv_price);
            image = itemView.findViewById(R.id.image);

        }

        
        /*
AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
builder.setMessage(R.string.dialog_message)
       .setTitle(R.string.dialog_title);
AlertDialog dialog = builder.create();
         */

    }
}