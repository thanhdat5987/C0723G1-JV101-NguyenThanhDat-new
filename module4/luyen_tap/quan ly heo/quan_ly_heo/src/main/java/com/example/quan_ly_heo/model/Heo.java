package com.example.quan_ly_heo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Heo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String maHeo;
    private String ngayNhapChuong;
    private String trongLuongNhapChuong;
    private String ngayXuatChuong;
    private String trongLuongKhiXuatChuong;
    @ManyToOne
    @JoinColumn(name = "id_xuat_xu")
    private XuatXu xuatXu;
}
