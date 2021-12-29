package gr.hua.freepass;


import gr.hua.freepass.models.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
}
