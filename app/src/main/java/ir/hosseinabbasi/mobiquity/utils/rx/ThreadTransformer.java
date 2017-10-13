package ir.hosseinabbasi.mobiquity.utils.rx;

import io.reactivex.SingleTransformer;

public interface ThreadTransformer {
  <T> SingleTransformer<T, T> applySchedulers();
}
