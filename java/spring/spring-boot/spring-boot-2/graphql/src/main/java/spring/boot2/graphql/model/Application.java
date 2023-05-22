package spring.boot2.graphql.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    private Integer id;
    private String name;
    private String owner;
    private String description;
}
