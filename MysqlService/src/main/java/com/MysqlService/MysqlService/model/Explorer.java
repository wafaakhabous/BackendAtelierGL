package com.MysqlService.MysqlService.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Explorer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonManagedReference("Blog_Exp")
    @OneToMany(mappedBy = "explorer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Blog> blogs = new ArrayList<>();
}
