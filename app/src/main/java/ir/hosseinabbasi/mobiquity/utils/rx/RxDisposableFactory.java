package ir.hosseinabbasi.mobiquity.utils.rx;

import javax.inject.Inject;
import ir.hosseinabbasi.mobiquity.utils.rx.impl.CompositeDisposablesImpl;

public class RxDisposableFactory {

    @Inject
    public RxDisposableFactory() {
    }

    public RxDisposables get() {
        return new CompositeDisposablesImpl();
    }
}
