package co.edu.uco.postula2.application.secondaryports.service;

import co.edu.uco.postula2.domain.postulant.PostulantDomain;

public interface NotificationService {

    void notifyNewPostulant(PostulantDomain postulantDomain);
}
