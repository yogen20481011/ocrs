package com.ocrms.ocrmsbca.service.impl;

import com.ocrms.ocrmsbca.Enum.EComplainStatus;
import com.ocrms.ocrmsbca.components.FileStorageComponent;
import com.ocrms.ocrmsbca.dto.ComplainDto;
import com.ocrms.ocrmsbca.dto.ResponseDto;
import com.ocrms.ocrmsbca.entity.complain.Complain;
import com.ocrms.ocrmsbca.repository.complain.ComplainRepository;
import com.ocrms.ocrmsbca.repository.user.UserRepository;
import com.ocrms.ocrmsbca.service.complain.ComplainService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class ComplainServiceImpl implements ComplainService {
    private final ComplainRepository complainRepository;
    private final FileStorageComponent fileStorageComponent;
    private final UserRepository userRepository;
    public ComplainServiceImpl(ComplainRepository complainRepository, FileStorageComponent fileStorageComponent, UserRepository userRepository) {
        this.complainRepository = complainRepository;
        this.fileStorageComponent = fileStorageComponent;
        this.userRepository = userRepository;
    }
    @Override
    public ComplainDto save(ComplainDto complainDto) throws ParseException, IOException {

       /* ResponseDto responseDto = fileStorageComponent.storeFile(complainDto.getMultipartFile());
        if (responseDto.isStatus()) {*/
        Complain complain=new Complain();
        complain.setId(complainDto.getId());
        complain.setAddress(complainDto.getAddress());
        complain.setCrime(complainDto.getCrime());
        complain.setCrimeDate(new SimpleDateFormat("yyyy-dd-mm").parse(complainDto.getCrimeDate()));
        complain.setComplainDate(new Date());
        if (complain.getId() == null) {
            complain.setComplainStatus(EComplainStatus.PENDING);
        } else {
            complain.setComplainStatus(complainDto.getComplainStatus());
            complain.setUser(complainDto.getUser());
        }
        complain.setDescription(complainDto.getDescription());
        /*  complain.setPhoto(responseDto.getMessage());*/
        complain.setUser(complainDto.getUser());
        complainRepository.save(complain);
   /* }*/
        return complainDto;
    }

   @Override
    public List<ComplainDto> findAll() throws IOException {
     /*    List<ComplainDto> complainList = new ArrayList<>();
        List<Complain> complainList1 = complainRepository.getComplainList();
        for (Complain complain : complainList1) {
            complainList.add(ComplainDto.builder()
                    .id(complain.getId())
                    .address(complain.getAddress())
                    .crime(complain.getCrime())
                    .crimeDate(new SimpleDateFormat("yyyy-MM-dd").format(complain.getCrimeDate()))
                    .complainStatus(complain.getComplainStatus())
                    .complainDate(complain.getComplainDate())
                    .description(complain.getDescription())
                    .photo(fileStorageComponent.base64Encoded(complain.getPhoto()))
                    .user(complain.getUser())
                    .build());
        }
        return complainList;*/
       return null;
    }

    @Override
    public ComplainDto findById(Long aLong) throws IOException {
        Complain complain;
        Optional<Complain> optionalComplain = complainRepository.findById(aLong);
        if (optionalComplain.isPresent()) {
            complain = optionalComplain.get();
            return ComplainDto.builder()
                    .id(complain.getId())
                    .address(complain.getAddress())
                    .crime(complain.getCrime())
                    .crimeDate(new SimpleDateFormat("yyyy-MM-dd").format(complain.getCrimeDate()))
                    .complainStatus(complain.getComplainStatus())
                    .complainDate(complain.getComplainDate())
                    .description(complain.getDescription())
                /*    .photo(fileStorageComponent.base64Encoded(complain.getPhoto()))*/
                    .user(complain.getUser())
                    .build();

        }
        return null;
    }

    @Override
    public void deleteById(Long aLong) {
        complainRepository.deleteById(aLong);

    }

    public List<ComplainDto> findAllComplain() {
        //return entity convert the dto
        List<ComplainDto> complainList = new ArrayList<>();
        List<Complain> complainList1 = complainRepository.getComplainDetails();
        for (Complain complain : complainList1) {
            complainList.add(ComplainDto.builder()
                    .id(complain.getId())
                    .address(complain.getAddress())
                    .crime(complain.getCrime())
                    .crimeDate(new SimpleDateFormat("yyyy-MM-dd").format(complain.getCrimeDate()))
                    .complainStatus(complain.getComplainStatus())
                    .complainDate(complain.getComplainDate())
                    .description(complain.getDescription())
                    .user(complain.getUser())
                    .build());
        }
        return complainList;
    }

    public ComplainDto update(ComplainDto complainDto) throws ParseException, IOException {
        Complain complain=new Complain();
        complain.setId(complainDto.getId());
        complain.setAddress(complainDto.getAddress());
        complain.setCrime(complainDto.getCrime());
        complain.setCrimeDate(new SimpleDateFormat("yyyy-dd-mm").parse(complainDto.getCrimeDate()));
        complain.setComplainDate(new Date());
        complain.setComplainStatus(complainDto.getComplainStatus());
        complain.setDescription(complainDto.getDescription());
        complain.setUser(complainDto.getUser());
        complainRepository.save(complain);
        return complainDto;
    }
}
