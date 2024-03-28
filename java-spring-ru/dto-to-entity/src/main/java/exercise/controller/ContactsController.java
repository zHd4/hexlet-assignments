package exercise.controller;

import exercise.dto.ContactCreateDTO;
import exercise.dto.ContactDTO;
import exercise.model.Contact;
import exercise.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactsController {

    @Autowired
    private ContactRepository contactRepository;

    // BEGIN
    @PostMapping
    public ResponseEntity<ContactDTO> create(@RequestBody ContactCreateDTO createDTO) {
        Contact contact = toEntity(createDTO);
        contactRepository.save(contact);

        return ResponseEntity.status(HttpStatus.CREATED).body(toDTO(contact));
    }

    private Contact toEntity(ContactCreateDTO dto) {
        Contact contact = new Contact();

        contact.setFirstName(dto.getFirstName());
        contact.setLastName(dto.getLastName());
        contact.setPhone(dto.getPhone());

        return contact;
    }

    private ContactDTO toDTO(Contact contact) {
        ContactDTO dto = new ContactDTO();

        dto.setId(contact.getId());
        dto.setFirstName(contact.getFirstName());
        dto.setLastName(contact.getLastName());
        dto.setPhone(contact.getPhone());
        dto.setCreatedAt(contact.getCreatedAt());
        dto.setUpdatedAt(contact.getUpdatedAt());

        return dto;
    }
    // END
}
