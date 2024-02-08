package com.MysqlService.MysqlService.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("NORMAL_USER") // La valeur correspondant à cette classe
@Data
@AllArgsConstructor
public class NormalUser extends User{

}
