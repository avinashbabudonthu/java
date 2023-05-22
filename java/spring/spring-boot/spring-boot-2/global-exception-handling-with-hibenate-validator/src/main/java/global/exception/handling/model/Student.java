package global.exception.handling.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 1, max = 10, message = "name should me minimum 1 character and maximum 10 characters")
    private String name;
    private Date joiningDate;
}
