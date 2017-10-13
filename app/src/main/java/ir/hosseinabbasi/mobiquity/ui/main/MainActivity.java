package ir.hosseinabbasi.mobiquity.ui.main;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import javax.inject.Inject;
import butterknife.ButterKnife;
import ir.hosseinabbasi.mobiquity.R;
import ir.hosseinabbasi.mobiquity.ui.base.BaseActivity;
import ir.hosseinabbasi.mobiquity.ui.category.CategoryListView;

public class MainActivity extends BaseActivity implements IMainActivityView {

    @Inject
    MainActivityPresenter<IMainActivityView> mPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        initViews();
        mPresenter.onAttach(this);
    }

    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    private void initViews() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.v_container, CategoryListView.getInstance(), CategoryListView.TAG)
                .commit();
    }

}
