package co.edu.uco.postula2.domain;

import java.util.UUID;

public class Domain {

    private UUID id;

    public Domain(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
