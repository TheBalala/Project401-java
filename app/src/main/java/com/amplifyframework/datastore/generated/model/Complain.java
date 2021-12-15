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

/** This is an auto generated class representing the Complain type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Complains")
@Index(name = "byComplain", fields = {"categoryName","username","cityName","Description","State","fileUrl","lon","lat"})
public final class Complain implements Model {
  public static final QueryField ID = field("Complain", "id");
  public static final QueryField DESCRIPTION = field("Complain", "Description");
  public static final QueryField CATEGORY_NAME = field("Complain", "categoryName");
  public static final QueryField USERNAME = field("Complain", "username");
  public static final QueryField CITY_NAME = field("Complain", "cityName");
  public static final QueryField STATE = field("Complain", "State");
  public static final QueryField FILE_URL = field("Complain", "fileUrl");
  public static final QueryField LON = field("Complain", "lon");
  public static final QueryField LAT = field("Complain", "lat");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String Description;
  private final @ModelField(targetType="String") String categoryName;
  private final @ModelField(targetType="String") String username;
  private final @ModelField(targetType="String") String cityName;
  private final @ModelField(targetType="String", isRequired = true) String State;
  private final @ModelField(targetType="String") String fileUrl;
  private final @ModelField(targetType="Float") Double lon;
  private final @ModelField(targetType="Float") Double lat;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getDescription() {
      return Description;
  }
  
  public String getCategoryName() {
      return categoryName;
  }
  
  public String getUsername() {
      return username;
  }
  
  public String getCityName() {
      return cityName;
  }
  
  public String getState() {
      return State;
  }
  
  public String getFileUrl() {
      return fileUrl;
  }
  
  public Double getLon() {
      return lon;
  }
  
  public Double getLat() {
      return lat;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Complain(String id, String Description, String categoryName, String username, String cityName, String State, String fileUrl, Double lon, Double lat) {
    this.id = id;
    this.Description = Description;
    this.categoryName = categoryName;
    this.username = username;
    this.cityName = cityName;
    this.State = State;
    this.fileUrl = fileUrl;
    this.lon = lon;
    this.lat = lat;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Complain complain = (Complain) obj;
      return ObjectsCompat.equals(getId(), complain.getId()) &&
              ObjectsCompat.equals(getDescription(), complain.getDescription()) &&
              ObjectsCompat.equals(getCategoryName(), complain.getCategoryName()) &&
              ObjectsCompat.equals(getUsername(), complain.getUsername()) &&
              ObjectsCompat.equals(getCityName(), complain.getCityName()) &&
              ObjectsCompat.equals(getState(), complain.getState()) &&
              ObjectsCompat.equals(getFileUrl(), complain.getFileUrl()) &&
              ObjectsCompat.equals(getLon(), complain.getLon()) &&
              ObjectsCompat.equals(getLat(), complain.getLat()) &&
              ObjectsCompat.equals(getCreatedAt(), complain.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), complain.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDescription())
      .append(getCategoryName())
      .append(getUsername())
      .append(getCityName())
      .append(getState())
      .append(getFileUrl())
      .append(getLon())
      .append(getLat())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Complain {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("Description=" + String.valueOf(getDescription()) + ", ")
      .append("categoryName=" + String.valueOf(getCategoryName()) + ", ")
      .append("username=" + String.valueOf(getUsername()) + ", ")
      .append("cityName=" + String.valueOf(getCityName()) + ", ")
      .append("State=" + String.valueOf(getState()) + ", ")
      .append("fileUrl=" + String.valueOf(getFileUrl()) + ", ")
      .append("lon=" + String.valueOf(getLon()) + ", ")
      .append("lat=" + String.valueOf(getLat()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static DescriptionStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static Complain justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Complain(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      Description,
      categoryName,
      username,
      cityName,
      State,
      fileUrl,
      lon,
      lat);
  }
  public interface DescriptionStep {
    StateStep description(String description);
  }
  

  public interface StateStep {
    BuildStep state(String state);
  }
  

  public interface BuildStep {
    Complain build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep categoryName(String categoryName);
    BuildStep username(String username);
    BuildStep cityName(String cityName);
    BuildStep fileUrl(String fileUrl);
    BuildStep lon(Double lon);
    BuildStep lat(Double lat);
  }
  

  public static class Builder implements DescriptionStep, StateStep, BuildStep {
    private String id;
    private String Description;
    private String State;
    private String categoryName;
    private String username;
    private String cityName;
    private String fileUrl;
    private Double lon;
    private Double lat;
    @Override
     public Complain build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Complain(
          id,
          Description,
          categoryName,
          username,
          cityName,
          State,
          fileUrl,
          lon,
          lat);
    }
    
    @Override
     public StateStep description(String description) {
        Objects.requireNonNull(description);
        this.Description = description;
        return this;
    }
    
    @Override
     public BuildStep state(String state) {
        Objects.requireNonNull(state);
        this.State = state;
        return this;
    }
    
    @Override
     public BuildStep categoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }
    
    @Override
     public BuildStep username(String username) {
        this.username = username;
        return this;
    }
    
    @Override
     public BuildStep cityName(String cityName) {
        this.cityName = cityName;
        return this;
    }
    
    @Override
     public BuildStep fileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
        return this;
    }
    
    @Override
     public BuildStep lon(Double lon) {
        this.lon = lon;
        return this;
    }
    
    @Override
     public BuildStep lat(Double lat) {
        this.lat = lat;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String description, String categoryName, String username, String cityName, String state, String fileUrl, Double lon, Double lat) {
      super.id(id);
      super.description(description)
        .state(state)
        .categoryName(categoryName)
        .username(username)
        .cityName(cityName)
        .fileUrl(fileUrl)
        .lon(lon)
        .lat(lat);
    }
    
    @Override
     public CopyOfBuilder description(String description) {
      return (CopyOfBuilder) super.description(description);
    }
    
    @Override
     public CopyOfBuilder state(String state) {
      return (CopyOfBuilder) super.state(state);
    }
    
    @Override
     public CopyOfBuilder categoryName(String categoryName) {
      return (CopyOfBuilder) super.categoryName(categoryName);
    }
    
    @Override
     public CopyOfBuilder username(String username) {
      return (CopyOfBuilder) super.username(username);
    }
    
    @Override
     public CopyOfBuilder cityName(String cityName) {
      return (CopyOfBuilder) super.cityName(cityName);
    }
    
    @Override
     public CopyOfBuilder fileUrl(String fileUrl) {
      return (CopyOfBuilder) super.fileUrl(fileUrl);
    }
    
    @Override
     public CopyOfBuilder lon(Double lon) {
      return (CopyOfBuilder) super.lon(lon);
    }
    
    @Override
     public CopyOfBuilder lat(Double lat) {
      return (CopyOfBuilder) super.lat(lat);
    }
  }
  
}
