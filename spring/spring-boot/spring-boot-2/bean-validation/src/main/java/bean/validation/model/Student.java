package bean.validation.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @NotNull(message = "Id should not be null")
    private Integer id;

    @Size(min = 1, max = 50, message = "Name should have minimum 1 character and maximum 50 characters")
    private String name;

    private Date joiningDate;

    private Double grade;

    @Email(message = "Invalid email id")
    private String email;
}
