package com.tnsif.placement.service;

import com.tnsif.placement.entity.Certificate;
import com.tnsif.placement.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    public Certificate saveCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    public Certificate getCertificateById(Long id) {
        return certificateRepository.findById(id).orElse(null);
    }

    public void deleteCertificate(Long id) {
        certificateRepository.deleteById(id);
    }
}