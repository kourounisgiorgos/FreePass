package gr.hua.freepass.Repositories;

import gr.hua.freepass.Entities.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen,Long> {
}
