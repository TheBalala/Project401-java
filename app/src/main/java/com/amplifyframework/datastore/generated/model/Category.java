package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.HasMany;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Category type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Categories")
@Index(name = "byComplain", fields = {"categoryName","cityName"})
public final class Category implements Model {
  public static final QueryField ID = field("Category", "id");
  public static final QueryField CATEGORY_NAME = field("Category", "categoryName");
  public static final QueryField CITY_NAME = field("Category", "cityName");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String categoryName;
  private final @ModelField(targetType="Complain") @HasMany(associatedWith = "categoryName", type = Complain.class) List<Complain> Complain = null;
  private final @ModelField(targetType="String") String cityName;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getCategoryName() {
      return categoryName;
  }
  
  public List<Complain> getComplain() {
      return Complain;
  }
  
  public String getCityName() {
      return cityName;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Category(String id, String categoryName, String cityName) {
    this.id = id;
    this.categoryName = categoryName;
    this.cityName = cityName;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Category category = (Category) obj;
      return ObjectsCompat.equals(getId(), category.getId()) &&
              ObjectsCompat.equals(getCategoryName(), category.getCategoryName()) &&
              ObjectsCompat.equals(getCityName(), category.getCityName()) &&
              ObjectsCompat.equals(getCreatedAt(), category.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), category.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getCategoryName())
      .append(getCityName())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Category {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("categoryName=" + String.valueOf(getCategoryName()) + ", ")
      .append("cityName=" + String.valueOf(getCityName()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static CategoryNameStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Category justId(String id) {
    return new Category(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      categoryName,
      cityName);
  }
  public interface CategoryNameStep {
    BuildStep categoryName(String categoryName);
  }
  

  public interface BuildStep {
    Category build();
    BuildStep id(String id);
    BuildStep cityName(String cityName);
  }
  

  public static class Builder implements CategoryNameStep, BuildStep {
    private String id;
    private String categoryName;
    private String cityName;
    @Override
     public Category build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Category(
          id,
          categoryName,
          cityName);
    }
    
    @Override
     public BuildStep categoryName(String categoryName) {
        Objects.requireNonNull(categoryName);
        this.categoryName = categoryName;
        return this;
    }
    
    @Override
     public BuildStep cityName(String cityName) {
        this.cityName = cityName;
        return this;
    }
    
    /** 
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String categoryName, String cityName) {
      super.id(id);
      super.categoryName(categoryName)
        .cityName(cityName);
    }
    
    @Override
     public CopyOfBuilder categoryName(String categoryName) {
      return (CopyOfBuilder) super.categoryName(categoryName);
    }
    
    @Override
     public CopyOfBuilder cityName(String cityName) {
      return (CopyOfBuilder) super.cityName(cityName);
    }
  }
  
}
