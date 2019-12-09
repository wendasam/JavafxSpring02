package com.pawencode.latihanspring.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Data // untuk generate getter setter
@Entity // entitas dalam database
@Table(name="person") // tabel dalam database
@EntityListeners(AuditingEntityListener.class)
@ComponentScan
public class ModelPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="uuid", strategy = "uuid2")
    @Column(name="Id")
    private String idperson;
    @Column(name="nama")

    private String nama;
    private String jk;
    private String prodi;

    @Column(name="blnwisuda")
    private String bulan;

    @Column(name = "thnwisuda")
    private String tahun;

}
