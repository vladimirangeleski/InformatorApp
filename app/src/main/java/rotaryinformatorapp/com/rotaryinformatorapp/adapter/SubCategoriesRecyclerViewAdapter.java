package rotaryinformatorapp.com.rotaryinformatorapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import rotaryinformatorapp.com.rotaryinformatorapp.R;
import rotaryinformatorapp.com.rotaryinformatorapp.model.SubCategory;

/**
 * Created by Vladimir on 5/5/2016.
 */
public class SubCategoriesRecyclerViewAdapter extends RecyclerView.Adapter<SubCategoriesRecyclerViewAdapter.MyViewHolder> {

    public interface OnSubCategoryItemClickListener {
        public void onSubCategoryClick(SubCategory category, int position);
    }

    private List<SubCategory> data = Collections.emptyList();
    private LayoutInflater inflater;
    private Context context;
    private OnSubCategoryItemClickListener listener;

    public SubCategoriesRecyclerViewAdapter(Context context, List<SubCategory> data, OnSubCategoryItemClickListener listener) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_sub_category, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final SubCategory category = data.get(position);

        holder.title.setText(category.getName().toUpperCase());
        holder.indicator.setBackgroundResource(category.getColor());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null)
                    listener.onSubCategoryClick(category, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private View indicator;

        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            indicator = itemView.findViewById(R.id.indicator);
        }
    }
}
