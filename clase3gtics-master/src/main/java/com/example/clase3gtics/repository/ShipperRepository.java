package com.example.clase3gtics.repository;

import com.example.clase3gtics.entity.Shipper;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipperRepository extends JpaRepository<Shipper, Integer> {

    List<Shipper> findByCompanyName(String textoIngresado);

    @Query(nativeQuery = true, value = "SELECT * FROM shippers where CompanyName = ?1")
    List<Shipper> buscarPorNombreCompania(String textoIngreso);

    @Query(nativeQuery = true, value = "SELECT * FROM shippers where phone like %?1%")
    List<Shipper> buscarPorTelefonoConNumero5(String numero);

    //para insertar/actualizar/borrar -> agregar @Transactional y @Modifying
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE shippers SET Phone = ?1 WHERE ShipperID = ?2")
    void actualizarTelefono(String phone, int shipperId);
}

