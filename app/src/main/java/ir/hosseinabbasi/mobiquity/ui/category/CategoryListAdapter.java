package ir.hosseinabbasi.mobiquity.ui.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.afollestad.sectionedrecyclerview.SectionedRecyclerViewAdapter;
import com.afollestad.sectionedrecyclerview.SectionedViewHolder;
import com.squareup.picasso.Picasso;
import java.util.List;
import ir.hosseinabbasi.mobiquity.R;
import ir.hosseinabbasi.mobiquity.data.db.model.Category;
import ir.hosseinabbasi.mobiquity.data.db.model.ProductsItem;
import ir.hosseinabbasi.mobiquity.data.network.ApiEndPoint;

public class CategoryListAdapter extends SectionedRecyclerViewAdapter<CategoryListAdapter.MyViewHolder> {

    private static ICategoryListView mListener;
    private Context mContext;
    private static List<Category> allData;

    public CategoryListAdapter(Context context, List<Category> data, ICategoryListView listener) {
        this.mContext = context;
        this.allData = data;
        this.mListener = listener;
    }

    @Override
    public int getSectionCount() {
        return allData.size();
    }

    @Override
    public int getItemCount(int categoryIndex) {
        return allData.get(categoryIndex).getProducts().size();
    }

    @Override
    public void onBindHeaderViewHolder(MyViewHolder holder, int categoryIndex, boolean expanded) {
        String categoryName = allData.get(categoryIndex).getName();
        holder.title.setText(categoryName);
        holder.caret.setImageResource(expanded ? R.drawable.ic_collapse : R.drawable.ic_expand);
    }

    @Override
    public void onBindFooterViewHolder(MyViewHolder holder, int categoryIndex) {
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int categoryIndex, int relativePosition, int absolutePosition) {
        List<ProductsItem> itemsInCategory = allData.get(categoryIndex).getProducts();

        String productName = itemsInCategory.get(relativePosition).getName();
        String productUrl = itemsInCategory.get(relativePosition).getUrl();
        holder.title.setText(productName);
        Picasso.with(mContext)
                .load(ApiEndPoint.ENDPOINT_AMAZONAWS + productUrl) // Thumbnail URL
                .placeholder(mContext.getResources().getDrawable(R.mipmap.ic_launcher))
                .resize(96,96)
                .into(holder.caret);
    }

    @Override
    public int getItemViewType(int section, int relativePosition, int absolutePosition) {
        if (section == 1) {
            // VIEW_TYPE_FOOTER is -3, VIEW_TYPE_HEADER is -2, VIEW_TYPE_ITEM is -1.
            // You can return 0 or greater.
            return 0;
        }
        return super.getItemViewType(section, relativePosition, absolutePosition);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int layout;
        switch (viewType) {
            case VIEW_TYPE_HEADER:
                layout = R.layout.item_list_category;
                break;
            case VIEW_TYPE_ITEM:
                layout = R.layout.item_list_product;
                break;
            default:
                layout = R.layout.item_list_product;
                break;
        }

        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        return new MyViewHolder(v, this);
    }

    static class MyViewHolder extends SectionedViewHolder implements View.OnClickListener {

        final TextView title;
        final ImageView caret;
        final CategoryListAdapter adapter;

        MyViewHolder(View itemView, CategoryListAdapter adapter) {
            super(itemView);
            this.title = itemView.findViewById(R.id.title);
            this.caret = itemView.findViewById(R.id.caret);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int selectedCategory = getRelativePosition().section();
            int selectedProduct = getRelativePosition().relativePos();

            if (isFooter())
                return; // ignore footer clicks

            if (isHeader())
                adapter.toggleSectionExpanded(getRelativePosition().section());
            else{
                ProductsItem product = allData.get(selectedCategory).getProducts().get(selectedProduct);
                mListener.loadProductDetail(product);
            }

        }
    }

}
