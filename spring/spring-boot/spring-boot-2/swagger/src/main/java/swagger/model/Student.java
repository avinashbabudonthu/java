package swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@Data
@Builder
@ApiModel(description = "Student model")
public class Student {

    private String id;

    @ApiModelProperty(notes = "Numbers not allowed in the name")
    private String name;

    @ApiModelProperty(notes = "Birth date should be in the past")
    private Date birthDate;
}
