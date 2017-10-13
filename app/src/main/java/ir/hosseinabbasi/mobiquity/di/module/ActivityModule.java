package ir.hosseinabbasi.mobiquity.di.module;

import android.app.Activity;
import android.content.Context;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;
import ir.hosseinabbasi.mobiquity.di.ActivityContext;
import ir.hosseinabbasi.mobiquity.di.PerActivity;
import ir.hosseinabbasi.mobiquity.ui.main.IMainActivityPresenter;
import ir.hosseinabbasi.mobiquity.ui.main.IMainActivityView;
import ir.hosseinabbasi.mobiquity.ui.main.MainActivityPresenter;

@Module
public class ActivityModule {

    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    Activity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    @PerActivity
    IMainActivityPresenter<IMainActivityView> provideMainActivityPresenter(MainActivityPresenter<IMainActivityView>
                                                               presenter) {
        return presenter;
    }

}
