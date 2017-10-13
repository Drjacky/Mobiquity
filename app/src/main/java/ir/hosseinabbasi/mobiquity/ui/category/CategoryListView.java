package ir.hosseinabbasi.mobiquity.ui.category;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import ir.hosseinabbasi.mobiquity.R;
import ir.hosseinabbasi.mobiquity.data.db.model.Category;
import ir.hosseinabbasi.mobiquity.data.db.model.ProductsItem;
import ir.hosseinabbasi.mobiquity.di.ActivityContext;
import ir.hosseinabbasi.mobiquity.ui.base.BaseFragment;
import ir.hosseinabbasi.mobiquity.ui.detail.DetailView;
import ir.hosseinabbasi.mobiquity.ui.main.MainActivity;

public class CategoryListView extends BaseFragment implements ICategoryListView {

    public static final String TAG = "CategoryListView";

    @Inject
    @ActivityContext
    Context mContext;

    @Inject
    CategoryListPresenter<CategoryListView> mPresenter;

    @BindView(R.id.fragment_category_rcyCategory)
    RecyclerView rcyCategory;

    public static CategoryListView getInstance() {
        return new CategoryListView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);
        initViews();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.getCategoryList();
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void loadCategoryList(List<Category> category) {
        CategoryListAdapter adapter = new CategoryListAdapter(mContext, category, this);
        GridLayoutManager manager =
                new GridLayoutManager(mContext, 1);
        rcyCategory.setLayoutManager(manager);
        adapter.setLayoutManager(manager);
        adapter.shouldShowHeadersForEmptySections(true);
        adapter.shouldShowFooters(false);
        rcyCategory.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void loadProductDetail(ProductsItem product) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("product",product);
        DetailView detailFragment = DetailView.getInstance();
        detailFragment.setArguments(bundle);

        ((MainActivity)mContext).getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.slide_left, R.anim.slide_right)
                .add(R.id.v_container, detailFragment, DetailView.TAG)
                .addToBackStack(DetailView.TAG)
                .commit();
    }

    private void initViews() {
        rcyCategory.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcyCategory.setHasFixedSize(true);
    }

}