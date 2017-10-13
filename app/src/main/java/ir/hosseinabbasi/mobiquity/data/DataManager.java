package ir.hosseinabbasi.mobiquity.data;

import java.util.List;
import io.reactivex.Observable;
import ir.hosseinabbasi.mobiquity.data.db.model.Category;
import ir.hosseinabbasi.mobiquity.data.network.ApiHelper;

public interface DataManager extends ApiHelper {
    //It contains methods, exposed for all the data handling operations. Ideally, it delegates the services provided by all the Helper classes.
}
