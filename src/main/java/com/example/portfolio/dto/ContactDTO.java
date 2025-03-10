package com.example.portfolio.dto;

import com.example.portfolio.entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {
    private String addr;
    private String tel;
    private String email;
    private String openHours;

    public ContactDTO(Contact contact) {
        this.addr = contact.getAddr();
        this.tel = contact.getTel();
        this.email = contact.getEmail();
        this.openHours = contact.getOpenHours();
    }
}
