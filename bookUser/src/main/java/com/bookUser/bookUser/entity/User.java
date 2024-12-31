package com.bookUser.bookUser.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "firstName", length = 20, nullable = false)
    private String firstName;
    @Column(length = 20)
    private String lastName;
    @Column(length = 20, nullable = false, unique = true)
    private String userName;
    @Column(length = 20, nullable = false)
    private String password;

//    @Column(nullable = false)
//    private LocalDateTime dateOfBirth;
//
//    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name = "customer_contact_number", joinColumns = @JoinColumn(name = "customer_id"))
//    @Column(name = "mobile_number", nullable = false)
//    private Set<Integer> phoneNumbers;

}
