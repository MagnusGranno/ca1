/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author olive
 */
public class PersonDTO {

    private String firstName;
    private String lastName;
    private String email;
    private int id;
    private AddressDTO address;
    private List<HobbyDTO> hobbies;
    private List<PhoneDTO> phones;

    public PersonDTO() {
    }

    public PersonDTO(Person person) {
        this.email = person.getEmail();
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.id = person.getId();
        if (person.getAddress() != null) {
            this.address = new AddressDTO(person.getAddress());
            if (person.getAddress().getCityInfo() != null) {
                this.address.setCityInfo(new CityInfoDTO(person.getAddress().getCityInfo()));
            }
        }
        if (person.getHobbies() != null) {
            this.hobbies = HobbyDTO.getDTO(person.getHobbies());
        }
        if (person.getPhones() != null) {
            this.phones = PhoneDTO.getDTO(person.getPhones());
        }
    }

    public static List<PersonDTO> getDTO(List<Person> persons) {
        if (persons != null) {
            List<PersonDTO> personDTO = new ArrayList<>();
            persons.forEach(p -> personDTO.add(new PersonDTO(p)));
            return personDTO;
        } else {
            return null;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public List<HobbyDTO> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<HobbyDTO> hobbies) {
        this.hobbies = hobbies;
    }

    public List<PhoneDTO> getPhones() {
        return phones;
    }

    public void setPhones(List<PhoneDTO> phones) {
        this.phones = phones;
    }

    public void addPhone(PhoneDTO phoneDTO) {
        this.phones.add(phoneDTO);
    }

    public void removePhone(PhoneDTO phoneDTO) {
        this.phones.remove(phoneDTO);
    }
}
