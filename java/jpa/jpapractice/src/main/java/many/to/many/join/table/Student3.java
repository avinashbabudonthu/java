package many.to.many.join.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_s")
public class Student3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student3_id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student3_id",
            joinColumns = {
                @JoinColumn(name = "student3_course3", nullable = false, updatable = false)
            },
            inverseJoinColumns = {
                @JoinColumn(name = "course3_id", nullable = false, updatable = false)
            }
    )
    private List<Course3> courses;

}