package com.amplifyframework.datastore.generated.model;

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

/** This is an auto generated class representing the City type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Cities")
public final class City implements Model {
  public static final QueryField ID = field("City", "id");
  public static final QueryField CITY_NAME = field("City", "cityName");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String cityName;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
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
  
  private City(String id, String cityName) {
    this.id = id;
    this.cityName = cityName;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      City city = (City) obj;
      return ObjectsCompat.equals(getId(), city.getId()) &&
              ObjectsCompat.equals(getCityName(), city.getCityName()) &&
              ObjectsCompat.equals(getCreatedAt(), city.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), city.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getCityName())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("City {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("cityName=" + String.valueOf(getCityName()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
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
  public static City justId(String id) {
    return new City(
      id,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      cityName);
  }
  public interface BuildStep {
    City build();
    BuildStep id(String id);
    BuildStep cityName(String cityName);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String cityName;
    @Override
     public City build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new City(
          id,
          cityName);
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
    private CopyOfBuilder(String id, String cityName) {
      super.id(id);
      super.cityName(cityName);
    }
    
    @Override
     public CopyOfBuilder cityName(String cityName) {
      return (CopyOfBuilder) super.cityName(cityName);
    }
  }
  
}
