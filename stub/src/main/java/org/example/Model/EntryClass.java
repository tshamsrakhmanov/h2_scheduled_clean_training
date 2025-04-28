package org.example.Model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Long mdmCode;

    private String correspondId;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime creationTime;

}
