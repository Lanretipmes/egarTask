package com.testtask.egar.service;

import com.testtask.egar.entity.Security;
import com.testtask.egar.repository.SecurityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.Comparator;
import java.util.List;

@Service
public class SecurityService {

    private SecurityRepository securityRepository;

    @Autowired
    public SecurityService (SecurityRepository securityRepository){
        this.securityRepository = securityRepository;
    }

    @Transactional
    public void save(Security security) {
        if (security != null)
            securityRepository.save(security);
    }

    @Transactional
    public void delete(Security security) {
        securityRepository.delete(security);
    }

    @Transactional
    public List<Security> findAll() {
        List<Security> out = securityRepository.findAll();
        out.sort(Comparator.comparing(Security::getDate));
        return out;
    }

    @Transactional
    public void update(Security newSecurity) {
        Security security = securityRepository.findById(newSecurity.getId()).orElseThrow(EntityNotFoundException::new);
        security.setDate(newSecurity.getDate());
        security.setName(newSecurity.getName());
        security.setCost(newSecurity.getCost());
    }
}
