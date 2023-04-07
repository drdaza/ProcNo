package com.procno.project_procno.user.application.services;

import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.procno.project_procno.interfaces.services.AdminService;
import com.procno.project_procno.profile.domain.models.Profile;
import com.procno.project_procno.profile.domain.payloads.EditProfilePayload;
import com.procno.project_procno.profile.infrastructure.repositories.ProfileRepository;
import com.procno.project_procno.user.domain.exceptions.UserNotFoundException;
import com.procno.project_procno.user.domain.models.User;
import com.procno.project_procno.user.infrastructure.repositories.UserRepository;

@Service
public class UserInfoService implements AdminService<EditProfilePayload, String>{

    @Autowired
    private ProfileRepository profileRepository;

    private UserRepository repository;

    public UserInfoService(UserRepository repository) {
        this.repository = repository;
    }

    public User getOne(String username) {
        return repository.findByUsername(username).orElseThrow(()->new UserNotFoundException("User not found"));
    }

    @Override
    public void delete(String id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }


    @Override
    public EditProfilePayload update(String id, EditProfilePayload entity) {

        User userDB = repository.findByUsername(id).orElseThrow(()-> new UserNotFoundException("user not found"));

        userDB.setEmail(decoder(entity.getEmail()));

        Profile profileToEdit = userDB.getProfile();

        profileToEdit.setName(decoder(entity.getName()));
        profileToEdit.setLastName(decoder(entity.getLastName()));

        userDB.setProfile(profileToEdit);

        Profile profileDBUpdate = profileRepository.save(profileToEdit);

        User userDBUpdate = repository.save(userDB);

        return new EditProfilePayload(profileDBUpdate.getName(), profileDBUpdate.getLastName(), userDBUpdate.getEmail());
    }

    @Override
    public List<EditProfilePayload> listAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    private String decoder(String infoToDecode){
        byte[] decodifiedBytesInfo = Base64.getDecoder().decode(infoToDecode);
        String decodifiedInfo = new String(decodifiedBytesInfo).split(":")[0];

        return decodifiedInfo;
    }

    
}
