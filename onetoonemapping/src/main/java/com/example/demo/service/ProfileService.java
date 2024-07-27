package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Profile1;
import com.example.demo.repository.ProfileRepository;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public Profile1 saveProfile(Profile1 profile) {
        return profileRepository.save(profile);
    }

    public Profile1 getProfile(Long id) {
        return profileRepository.findById(id).orElse(null);
    }
}