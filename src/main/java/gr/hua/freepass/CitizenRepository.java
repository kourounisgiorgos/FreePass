package gr.hua.freepass;


import gr.hua.freepass.models.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
    Citizen findByUserName(String userName);
}
