package project.service;

import model.dto.FormDto;
import model.utils.FormUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.repositoty.FormRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FormService {

    private FormRepository formRepository;

    @Autowired
    public FormService(final FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    public List<FormDto> getAllForms() {
        return formRepository.findAll().stream()
                .map(FormUtil::fromModelToDto)
                .collect(Collectors.toList());
    }
}
