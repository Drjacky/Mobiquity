package ir.hosseinabbasi.mobiquity.ui.detail;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import ir.hosseinabbasi.mobiquity.R;
import ir.hosseinabbasi.mobiquity.data.db.model.ProductsItem;
import ir.hosseinabbasi.mobiquity.data.db.model.SalePrice;
import ir.hosseinabbasi.mobiquity.data.network.ApiEndPoint;
import ir.hosseinabbasi.mobiquity.di.ActivityContext;
import ir.hosseinabbasi.mobiquity.ui.base.BaseFragment;

public class DetailView extends BaseFragment implements IDetailView {

    public static final String TAG = "DetailView";

    @Inject
    @ActivityContext
    Context mContext;

    @Inject
    Resources mResources;

    @Inject
    DetailPresenter<DetailView> mPresenter;

    @BindView(R.id.fragment_detail_txtTitle)
    TextView txtPhotoTitle;

    @BindView(R.id.fragment_detail_imgThumbnail)
    ImageView imgPhotoThumbnail;

    public static DetailView getInstance() {
        return new DetailView();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);
        initViews();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    private void initViews() {
        Bundle bundle = this.getArguments();
        ProductsItem product = bundle.getParcelable("product");
        if(product != null) {
            SalePrice productSalePrice = product.getSalePrice();
            txtPhotoTitle.setText(mResources.getString(R.string.fragment_detail_nameAndPrice, product.getName(), productSalePrice.getAmount(), productSalePrice.getCurrency()));
            Picasso.with(mContext)
                    .load(ApiEndPoint.ENDPOINT_AMAZONAWS + product.getUrl())
                    .placeholder(mContext.getResources().getDrawable(R.mipmap.ic_launcher))
                    .into(imgPhotoThumbnail);
        }
    }

}
