package com.atefsaif.customrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    private String[] titles={"word","Excel","PowerPoint","Outlook"};
    private String[] details={"editeur de text","tableur","logiciel de presentation","client de courrier electronique"};
    private  int[] images = {R.drawable.word,
                            R.drawable.excel,
                            R.drawable.powerpoint,
                            R.drawable.outlook};
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.activity_list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.itemTitle.setText(titles[position]);
        holder.itemDetail.setText(details[position]);
        holder.itemImage.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView itemImage;
        private TextView itemTitle;
        private TextView itemDetail;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage=itemView.findViewById(R.id.item_image);
            itemTitle=itemView.findViewById(R.id.item_title);
            itemDetail=itemView.findViewById(R.id.item_detail);

            itemView.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    int position=getAdapterPosition();
                    Snackbar.make(v,titles[position] + " : " + details[position],Snackbar
                            .LENGTH_LONG).
                            setAction("Action",null).show();
                }
            });

        }
    }
}
