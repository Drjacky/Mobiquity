package ir.hosseinabbasi.mobiquity.utils.rx.impl;

import javax.inject.Inject;
import io.reactivex.Scheduler;
import io.reactivex.SingleTransformer;
import ir.hosseinabbasi.mobiquity.utils.rx.ThreadTransformer;
import ir.hosseinabbasi.mobiquity.utils.rx.qualifiers.IOThreadPref;
import ir.hosseinabbasi.mobiquity.utils.rx.qualifiers.UIThreadPref;

public final class ViewThreadTransformer implements ThreadTransformer {

    private final Scheduler subscribeOnScheduler;
    private final Scheduler observeOnScheduler;

    @Inject
    public ViewThreadTransformer(@IOThreadPref Scheduler subscribeOnScheduler,
                                 @UIThreadPref Scheduler observeOnScheduler) {
        this.subscribeOnScheduler = subscribeOnScheduler;
        this.observeOnScheduler = observeOnScheduler;
    }

    @Override
    public <T> SingleTransformer<T, T> applySchedulers() {
        return observable -> observable.subscribeOn(subscribeOnScheduler).observeOn(observeOnScheduler);
    }
}
