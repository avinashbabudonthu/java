package springboot.data.jpa.repository;


public class EmployeeJpaRepositoryImpl implements EmployeeJpaRepositoryCustom {

    @Override
    public String cutomMethod() {
        return "Custom method";
    }

}