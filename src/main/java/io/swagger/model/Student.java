package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Student
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-09-17T13:54:44.727808364Z[GMT]")


public class Student   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("surname")
  private String surname = null;

  @JsonProperty("patronymic")
  private String patronymic = null;

  @JsonProperty("variant")
  private Integer variant = null;

  @JsonProperty("worksSubmitted")
  private Integer worksSubmitted = null;

  @JsonProperty("rating")
  private Integer rating = null;

  public Student name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   **/
  @Schema(description = "")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Student surname(String surname) {
    this.surname = surname;
    return this;
  }

  /**
   * Get surname
   * @return surname
   **/
  @Schema(description = "")
  
    public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public Student patronymic(String patronymic) {
    this.patronymic = patronymic;
    return this;
  }

  /**
   * Get patronymic
   * @return patronymic
   **/
  @Schema(description = "")
  
    public String getPatronymic() {
    return patronymic;
  }

  public void setPatronymic(String patronymic) {
    this.patronymic = patronymic;
  }

  public Student variant(Integer variant) {
    this.variant = variant;
    return this;
  }

  /**
   * Get variant
   * @return variant
   **/
  @Schema(description = "")
  
    public Integer getVariant() {
    return variant;
  }

  public void setVariant(Integer variant) {
    this.variant = variant;
  }

  public Student worksSubmitted(Integer worksSubmitted) {
    this.worksSubmitted = worksSubmitted;
    return this;
  }

  /**
   * Get worksSubmitted
   * @return worksSubmitted
   **/
  @Schema(description = "")
  
    public Integer getWorksSubmitted() {
    return worksSubmitted;
  }

  public void setWorksSubmitted(Integer worksSubmitted) {
    this.worksSubmitted = worksSubmitted;
  }

  public Student rating(Integer rating) {
    this.rating = rating;
    return this;
  }

  /**
   * Get rating
   * @return rating
   **/
  @Schema(description = "")
  
    @Valid
    public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return Objects.equals(this.name, student.name) &&
        Objects.equals(this.surname, student.surname) &&
        Objects.equals(this.patronymic, student.patronymic) &&
        Objects.equals(this.variant, student.variant) &&
        Objects.equals(this.worksSubmitted, student.worksSubmitted) &&
        Objects.equals(this.rating, student.rating);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, surname, patronymic, variant, worksSubmitted, rating);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Student {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    surname: ").append(toIndentedString(surname)).append("\n");
    sb.append("    patronymic: ").append(toIndentedString(patronymic)).append("\n");
    sb.append("    variant: ").append(toIndentedString(variant)).append("\n");
    sb.append("    worksSubmitted: ").append(toIndentedString(worksSubmitted)).append("\n");
    sb.append("    rating: ").append(toIndentedString(rating)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
