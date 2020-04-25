package ibm.com.workshop.ui.login.confirmationScreen;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ibm.com.workshop.R;

public class RecyclerViewVerticalListAdapter extends RecyclerView.Adapter<RecyclerViewVerticalListAdapter.foodViewHolder>{
    public List<FoodsModel> foodsList;
    Context context;

    public RecyclerViewVerticalListAdapter(List<FoodsModel> foodsList, Context context) {
        this.foodsList = foodsList;
        this.context = context;
    }

    @NonNull
    @Override
    public foodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflate the layout file
        View foodLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.confirmation_screen_food_layout,parent, false);
        foodViewHolder foodViewHolder = new foodViewHolder(foodLayoutView);
        return  foodViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull foodViewHolder holder, int position) {
        holder.foodImageView.setImageResource(foodsList.get(position).foodImage);
        holder.foodTextView.setText(foodsList.get(position).foodName);
    }

    @Override
    public int getItemCount() {
        return foodsList.size();
    }

    public class foodViewHolder extends RecyclerView.ViewHolder{

        ImageView foodImageView;
        TextView foodTextView;
        @SuppressLint("CutPasteId")
        public foodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImageView = itemView.findViewById(R.id.food_image_view);
            foodTextView = itemView.findViewById(R.id.food_name_text_view);

        }

    }
}
