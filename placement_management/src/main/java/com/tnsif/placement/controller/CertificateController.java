package com.tnsif.placement.controller;

import com.tnsif.placement.entity.Certificate;
import com.tnsif.placement.service.CertificateService;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    // ✅ Add new certificate
    @PostMapping
    public Certificate addCertificate(@RequestBody Certificate certificate) {
        return certificateService.saveCertificate(certificate);
    }

    // ✅ Get certificate by ID
    @GetMapping("/{id}/get")
    public ResponseEntity<Certificate> getCertificateById(@PathVariable Long id) {
        try {
            Certificate certificate = certificateService.getCertificateById(id);
            return new ResponseEntity<>(certificate, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Get all certificates
    @GetMapping
    public List<Certificate> getAllCertificates() {
        return certificateService.getAllCertificates();
    }

    // ✅ Update certificate
    @PutMapping("/{id}/put")
    public ResponseEntity<Certificate> updateCertificate(@RequestBody Certificate certificate, @PathVariable Long id) {
        try {
            Certificate existingCertificate = certificateService.getCertificateById(id);
            if (existingCertificate != null) {
                certificate.setId(id);
                certificateService.saveCertificate(certificate);
                return new ResponseEntity<>(certificate, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ✅ Delete certificate
    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteCertificate(@PathVariable Long id) {
        try {
            certificateService.deleteCertificate(id);
            return new ResponseEntity<>("Certificate deleted successfully", HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>("Certificate not found", HttpStatus.NOT_FOUND);
        }
    }
}
