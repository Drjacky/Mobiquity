package ir.hosseinabbasi.mobiquity.data;

import android.content.Context;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;
import io.reactivex.Single;
import ir.hosseinabbasi.mobiquity.data.db.model.Category;
import ir.hosseinabbasi.mobiquity.data.network.ApiHelper;
import ir.hosseinabbasi.mobiquity.di.ApplicationContext;

@Singleton
public class AppDataManager implements DataManager {

    private static final String TAG = "AppDataManager";

    private final Context mContext;
    private final ApiHelper mApiHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context,
                          ApiHelper apiHelper) {
        mContext = context;
        mApiHelper = apiHelper;
    }

    @Override
    public Single<List<Category>> getCategories() { // Get the whole data from server
        return mApiHelper.getCategories();
    }

}
