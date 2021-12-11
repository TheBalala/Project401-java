package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
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
public final class Complain implements Model {
  public static final QueryField ID = field("Complain", "id");
  public static final QueryField DESCRIPTION = field("Complain", "Description");
  public static final QueryField CATEGORY = field("Complain", "complainCategoryId");
  public static final QueryField USER = field("Complain", "complainUserId");
  public static final QueryField CITY = field("Complain", "complainCityId");
  public static final QueryField STATE = field("Complain", "State");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String Description;
  private final @ModelField(targetType="Category") @BelongsTo(targetName = "complainCategoryId", type = Category.class) Category Category;
  private final @ModelField(targetType="User") @BelongsTo(targetName = "complainUserId", type = User.class) User User;
  private final @ModelField(targetType="City") @BelongsTo(targetName = "complainCityId", type = City.class) City City;
  private final @ModelField(targetType="String", isRequired = true) String State;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getDescription() {
      return Description;
  }
  
  public Category getCategory() {
      return Category;
  }
  
  public User getUser() {
      return User;
  }
  
  public City getCity() {
      return City;
  }
  
  public String getState() {
      return State;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Complain(String id, String Description, Category Category, User User, City City, String State) {
    this.id = id;
    this.Description = Description;
    this.Category = Category;
    this.User = User;
    this.City = City;
    this.State = State;
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
              ObjectsCompat.equals(getCategory(), complain.getCategory()) &&
              ObjectsCompat.equals(getUser(), complain.getUser()) &&
              ObjectsCompat.equals(getCity(), complain.getCity()) &&
              ObjectsCompat.equals(getState(), complain.getState()) &&
              ObjectsCompat.equals(getCreatedAt(), complain.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), complain.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getDescription())
      .append(getCategory())
      .append(getUser())
      .append(getCity())
      .append(getState())
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
      .append("Category=" + String.valueOf(getCategory()) + ", ")
      .append("User=" + String.valueOf(getUser()) + ", ")
      .append("City=" + String.valueOf(getCity()) + ", ")
      .append("State=" + String.valueOf(getState()) + ", ")
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
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      Description,
      Category,
      User,
      City,
      State);
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
    BuildStep category(Category category);
    BuildStep user(User user);
    BuildStep city(City city);
  }
  

  public static class Builder implements DescriptionStep, StateStep, BuildStep {
    private String id;
    private String Description;
    private String State;
    private Category Category;
    private User User;
    private City City;
    @Override
     public Complain build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Complain(
          id,
          Description,
          Category,
          User,
          City,
          State);
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
     public BuildStep category(Category category) {
        this.Category = category;
        return this;
    }
    
    @Override
     public BuildStep user(User user) {
        this.User = user;
        return this;
    }
    
    @Override
     public BuildStep city(City city) {
        this.City = city;
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
    private CopyOfBuilder(String id, String description, Category category, User user, City city, String state) {
      super.id(id);
      super.description(description)
        .state(state)
        .category(category)
        .user(user)
        .city(city);
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
     public CopyOfBuilder category(Category category) {
      return (CopyOfBuilder) super.category(category);
    }
    
    @Override
     public CopyOfBuilder user(User user) {
      return (CopyOfBuilder) super.user(user);
    }
    
    @Override
     public CopyOfBuilder city(City city) {
      return (CopyOfBuilder) super.city(city);
    }
  }
  
}
