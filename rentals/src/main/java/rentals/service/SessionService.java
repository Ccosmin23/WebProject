package rentals.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import rentals.entity.SessionEntity;
import rentals.repository.SessionRepository;

@Service
public class SessionService {
    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public void saveSession(HttpSession session) {
        SessionEntity sessionEntity = new SessionEntity();

//        sessionEntity.setId(Long.valueOf(session.getId()));
        // Set other properties...
        sessionRepository.save(sessionEntity);
    }
}
