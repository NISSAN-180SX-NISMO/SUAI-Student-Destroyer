package io.swagger.DataBase.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {
    private Long id;
    private String name = null;
    private String surname = null;
    private String patronymic = null;
    private Integer variant = null;
    private Integer worksSubmitted = null;
    private Integer rating = null;
}
