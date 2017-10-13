package ir.hosseinabbasi.mobiquity.data.db.model;

import android.os.Parcel;
import android.os.Parcelable;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ProductsItem implements Parcelable {

	@SerializedName("salePrice")
	private SalePrice salePrice;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("id")
	private String id;

	@SerializedName("categoryId")
	private String categoryId;

	@SerializedName("url")
	private String url;

	public void setSalePrice(SalePrice salePrice){
		this.salePrice = salePrice;
	}

	public SalePrice getSalePrice(){
		return salePrice;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setCategoryId(String categoryId){
		this.categoryId = categoryId;
	}

	public String getCategoryId(){
		return categoryId;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
	public String toString(){
		return
				"ProductsItem{" +
						"salePrice = '" + salePrice + '\'' +
						",name = '" + name + '\'' +
						",description = '" + description + '\'' +
						",id = '" + id + '\'' +
						",categoryId = '" + categoryId + '\'' +
						",url = '" + url + '\'' +
						"}";
	}

	protected ProductsItem(Parcel in) {
		salePrice = (SalePrice) in.readValue(SalePrice.class.getClassLoader());
		name = in.readString();
		description = in.readString();
		id = in.readString();
		categoryId = in.readString();
		url = in.readString();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeValue(salePrice);
		dest.writeString(name);
		dest.writeString(description);
		dest.writeString(id);
		dest.writeString(categoryId);
		dest.writeString(url);
	}

	@SuppressWarnings("unused")
	public static final Parcelable.Creator<ProductsItem> CREATOR = new Parcelable.Creator<ProductsItem>() {
		@Override
		public ProductsItem createFromParcel(Parcel in) {
			return new ProductsItem(in);
		}

		@Override
		public ProductsItem[] newArray(int size) {
			return new ProductsItem[size];
		}
	};
}