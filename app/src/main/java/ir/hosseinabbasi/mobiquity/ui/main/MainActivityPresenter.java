package ir.hosseinabbasi.mobiquity.ui.main;

import javax.inject.Inject;
import ir.hosseinabbasi.mobiquity.data.DataManager;
import ir.hosseinabbasi.mobiquity.ui.base.BasePresenter;
import ir.hosseinabbasi.mobiquity.utils.rx.RxDisposableFactory;
import ir.hosseinabbasi.mobiquity.utils.rx.RxDisposables;
import ir.hosseinabbasi.mobiquity.utils.rx.ThreadTransformer;

public final class MainActivityPresenter<V extends IMainActivityView> extends BasePresenter<V> implements IMainActivityPresenter<V> {

    private final ThreadTransformer threadTransformer;
    private final RxDisposables disposables;

    @Inject
    public MainActivityPresenter(DataManager dataManager,
                                 ThreadTransformer threadTransformer,
                                 RxDisposableFactory rxDisposableFactory) {
        super(dataManager, threadTransformer, rxDisposableFactory);
        this.threadTransformer = getThreadTransformer();
        this.disposables = getRxDisposables();
    }

}
