package co.jaimecobo.javaspringmaven0724.database.dao;

import co.jaimecobo.javaspringmaven0724.database.entity.Employee;
import co.jaimecobo.javaspringmaven0724.database.entity.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRoleDAO extends JpaRepository<EmployeeRole, Long> {
    List<EmployeeRole> findByEmployeeId(Integer id);
}
