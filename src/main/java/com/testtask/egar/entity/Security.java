package com.testtask.egar.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "securities")
@NoArgsConstructor
@RequiredArgsConstructor
public class Security {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull private LocalDate date;
    @NonNull private String name;
    @NonNull private int cost;

}
