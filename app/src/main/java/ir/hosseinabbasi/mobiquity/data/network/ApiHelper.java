package ir.hosseinabbasi.mobiquity.data.network;

import java.util.List;
import io.reactivex.Single;
import ir.hosseinabbasi.mobiquity.data.db.model.Category;
import retrofit2.http.GET;

public interface ApiHelper {

    @GET(".")
    Single<List<Category>> getCategories();

}
