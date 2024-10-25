package org.example.web;

import jakarta.ejb.EJB;

import javax.faces.bean.RequestScoped;
import javax.faces.event.NamedEvent;

@NamedEvent
@RequestScoped
public class EmpruntBean {
    @EJB
    private EmpruntService empruntService;

    private Long cdId;

    public String emprunterCD() {
        boolean success = empruntService.emprunterCD(cdId);
        return success ? "empruntSuccess" : "empruntFailure";
    }

    public Long getCdId() {
        return cdId;
    }

    public void setCdId(Long cdId) {
        this.cdId = cdId;
    }

}
