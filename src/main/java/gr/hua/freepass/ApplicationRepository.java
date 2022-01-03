package gr.hua.freepass;

import gr.hua.freepass.models.Application;
import gr.hua.freepass.models.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application,Integer> {
    Application findByUserName(String userName);
}
